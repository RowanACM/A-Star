package astar;

import gui.*;

import java.util.ArrayList;

/**
 * Created by lapost48 on 9/23/2016.
 * modified by aMelchior
 */
public class Node {

    public static int ROW_LIMIT = 0;
    public static int COL_LIMIT = 0;

    enum Direction {
        N(-1, 0),
        NE(-1, 1),
        E(0, 1),
        SE(1, 1),
        S(1, 0),
        SW(1, -1),
        W(0, -1),
        NW(-1, -1);

        int rowDif;
        int colDif;
        Direction(int row, int col) {
            rowDif = row;
            colDif = col;
        }

        public int[] newLoc(int[] prevLoc) {
            int newRow = newRow(prevLoc[0]);
            int newCol = newCol(prevLoc[1]);
            if(newRow < 1 || newCol < 1)
                return null;
            if(newRow >= Node.ROW_LIMIT || newCol >= Node.COL_LIMIT)
                return null;
            int[] newLoc = {newRow, newCol};
            return newLoc;
        }

        private int newCol(int prevCol) {
            int newCol = prevCol + colDif;
            if(newCol >= Node.COL_LIMIT)
                return -1;
            return newCol;
        }

        private int newRow(int prevRow) {
            int newRow = prevRow + rowDif;
            if(newRow < 0)
                return -1;
            return newRow;
        }
    }

    private int[] location;
    private Tile tile;
    private Node prev;


    public  Node (int[] startLocation, Tile tile) {
        new Node(startLocation, tile, null);
    }
    public Node(int[] startLocation, Tile tile, Node prev) {
        location = startLocation;
        this.tile = tile;
        this.prev = prev;
    }

    public Node getPrev(){
        return prev;
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

    public int[] getLocation() {
        return location;
    }

    public int h() {
        int row2 = AStarWindow.goalLoc[0];
        int col2 = AStarWindow.goalLoc[1];

        System.out.println("heuristic" + "\n\t"
                + location[0] + "," + location[1] + "to " + row2 + "," + col2
                + " is " + Math.sqrt((location[0] - row2)*(location[0] - row2)
                + (location[1] - col2)*(location[1] - col2)));

        double tempDistance = Math.sqrt((location[0] - row2)*(location[0] - row2)
                                      + (location[1] - col2)*(location[1] - col2));
        tempDistance += .5; //rounding up
        return (int)tempDistance + 5; //adds a value to make heuristic more impactful


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
