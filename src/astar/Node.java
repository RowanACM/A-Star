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
        return tile.cost();
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
