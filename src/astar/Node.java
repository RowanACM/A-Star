package astar;

import gui.*;

import java.util.ArrayList;

/**
 * Created by Nick LaPosta on 9/23/2016.
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

    public Node(int[] startLocation, Tile tile) {
        new Node(startLocation, tile, null);
    }

    public Node(int[] location, Tile tile, Node prev) {
        this.location = location;
        this.tile = tile;
        this.prev = prev;
    }

    public ArrayList<Node> getNeighbors() {
        ArrayList<Node> neighbors = new ArrayList<>();
        for(Direction dir: Direction.values()) {
            int[] newLoc = dir.newLoc(location);
            if(newLoc != null) {
				int r = newLoc[0];
				int c = newLoc[1];
                neighbors.add(new Node(newLoc, AStarWindow.getInstance().tiles[r, c], this));
			}
        }
    }

    public int getCost() {
        if(prev != null) {
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
        } else {
            return 0;
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
