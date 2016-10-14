package astar;

import gui.Tile;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class Node {

    private Tile tile;
    private Node prev;

    public Node(Tile tile, Node prev) {
        this.tile = tile;
        this.prev = prev;
    }

    public int getCost() {
        int thisTile = this.tile.cost();
        int prevTile = prev.tile.cost();
        int diff = thisTile - prevTile;
        if(Math.abs(diff) > 3) {
            return Integer.MAX_VALUE;
        } else {
            if(diff < 0) {
                return 1;
            } else {
                return diff + 1;
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
