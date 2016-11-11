package astar;

import gui.AStarWindow;
import gui.Tile;
import java.util.ArrayList;

/**
 * Created by lapost48 on 9/23/2016.
 * modified by aMelchior
 */
public class Node {

    //enum
    enum Direction {


        n(-1,0),
        ne(-1,1),
        e(0,1),
        se(1,1),
        s(1,0),
        sw(1,-1),
        w(0,-1),
        nw(-1,-1);

        int rodiff;
        int codiff;
        Direction(int row, int col) {
            rodiff = row;
            codiff = col;
            
        }
         int[] newLoc(int[] location){
             int r = newRow(location[0]);
             int c = newCol(location[1]);
             if(r >= 1 && c >= 1 && r < Node.ROWLIM && c < Node.COLLIM) {
                 int[] result = {r,c};
                 return  result;
             } else
                 return null;
         }

        private int newCol(int prevcol) {
            return prevcol + codiff;
        }
        private int newRow(int prevrow) {
            return prevrow + rodiff;
        }
    }

    public static int ROWLIM = AStarWindow.tiles.length;
    public static int COLLIM = AStarWindow.tiles[0].length;

    private Tile tile;
    private Node prev;
    private int[] location;

    public Node(int[] startLocation, Tile tile, Node prev) {
        location =startLocation;
        this.tile = tile;
        this.prev = prev;
    }
    public  Node (int[] startLocation, Tile tile) {
        new Node(startLocation, tile, null);
    }

    public ArrayList<Node> getNeighbors() {
        ArrayList<Node> neighbors = new ArrayList<>();

        for(Direction d : Direction.values()) {
            int[] loc = d.newLoc(location);

            if(loc != null)
                neighbors.add(new Node(loc, AStarWindow.getInstance().tiles[loc[0]][loc[1]], this));
        }

        return neighbors;
    }


    public int h() {
        return 0;  //TODO: linear distance from endpoint
    }

    public int getCost() {
        if(prev == null) {
            return 0;
        } else {
            int thisTile = this.tile.cost();
            int prevTile = prev.tile.cost();
            int diff = thisTile - prevTile;
            if (Math.abs(diff) > 3) {
                return Integer.MAX_VALUE;
            } else {
                if (diff < 0) {
                    return 1;
                } else {
                    return diff + 1;
                }
            }
        }
    }

    public boolean equals(Node compared){
        return tile == compared.getTile();
    }

    public Tile getTile() {
        return tile;
    }

    public Node getPrev(){
        return  prev;
    }

    public void setCurrentPath() {
        tile.setCurrentPath();
    }

    public void setFrontier() {
        tile.setFrontier();
    }

    public void setClosed() {
        tile.setClosed();
    }

}
