package astar;

import gui.Tile;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class Path implements Comparable<T> {

    Node head;

    public Path(Tile startTile, int[] startLocation) {
        head = new Node(startLocation, startTile, null);
    }

    private Path(Node head) {
        this.head = head;
    }

    //////////////////////////////////
    //  Color Modification Methods  //
    //////////////////////////////////

    public void paintCurrent() {
        Node realHead = head;
        while(head != null)
            head.setCurrentPath();
        head = realHead;
    }

    public void paintFrontier() {
        Node realHead = head;
        while(head != null)
            head.setFrontier();
        head = realHead;
    }

    public void paintClosed() {
        Node realHead = head;
        while(head != null)
            head.setClosed();
        head = realHead;
    }

    public ArrayList<Path> getNeighbors() {
        ArrayList<Path> result = new ArrayList<Path>();
        for (Node n : head.getNeighbors()) {
            result.add(new Path(n));
        }
        return result;
    }

    @Override
    public int compareTo(T otherPath) {

        otherPath
        
    }


    public boolean equals(Path otherPath){

    }


    //TODO: Create get neighbors

}
