package astar;

import gui.Tile;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class Node {

    //enum
    enum Direction {

        //nw = (-1,-1)

        Direction(int row, int col) {

        }
    }

    private Tile tile;
    private Node prev;

    public Node(int[] Location, Tile tile, Node prev) {
        this.tile = tile;
        this.prev = prev;
    }

    // int[] newloc
        //return null of col or row < 1
    //newcol
    //newrow
    private int newCOl(int prevcol) {
        //add to col dirff
        //iff out of counds return -1
        //return diff
        return -1;
    }

    public ArrayList<Node> getNeighbors() {
        ArrayList<Node> neighbors;

        for(Direction dir : Direction.values())
        {

        }
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
