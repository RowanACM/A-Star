package astar;

import gui.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class Path implements Comparable {

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
        Node cur = head;
        while(cur != null) {
            cur.setCurrentPath();
            cur = cur.getPrev();
        }
    }

    public void paintFrontier() {
        Node cur = head;
        while(cur != null) {
            cur.setFrontier();
            cur = cur.getPrev();
        }
    }

    public void paintClosed() {
        Node cur = head;
        while(cur != null) {
            cur.setClosed();
            cur = cur.getPrev();
        }
    }

    public ArrayList<Path> getNeighbors() {
        ArrayList<Path> result = new ArrayList<Path>();
        for (Node n : head.getNeighbors()) {
            result.add(new Path(n));
        }
        return result;
    }

    public int score(){
        return score(head);
    }

    private int score(Node current){
        if (current.getPrev() == null) {
            return current.getCost();
        }
        else {
            return current.getCost() + score(current.getPrev());
        }
    }

    public int compareTo(Object o) {
        Path compared = (Path) o;
        int myCost = score();
        int compCost = compared.score();

        if ( myCost > compCost ){
            return 1;
        }
        else if (myCost < compCost){
            return -1;
        }
        else {
            return 0;
        }
    }

    public boolean equals(Object o){
        boolean result;
        Path otherPath = (Path) o;

        if ( otherPath.head.getLocation().equals(this.head.getLocation()) )
        {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }

}
