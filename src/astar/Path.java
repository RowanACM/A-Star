package astar;

import gui.Tile;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by lapost48 on 9/23/2016.
 * modified by aMelchior
 */
public class Path implements Comparable<Path>{

    private Node head;

    public Path(Tile start, int[] startLocation) {
        head = new Node(startLocation, start, null);
    }
    private Path(Node head) {
        this.head = head;
    }

    //*
    public int score() {
        return score(head);
    }
    public int score(Node current) {
        if (current.getPrev() == null) {
            return current.getCost();
        } else {
            return current.getCost() + score(current.getPrev());
        }
    }
    //*/

    public int compareTo(Path compared) {
        int myCost = score()//head.getCost();
        int compCost = compared.score();//compared.head.getCost();// + compared.getHead().getCost();

        if (myCost > compCost) {
            return 1;
        } else if(myCost < compCost) {
            return -1;
        } else {
            return 0;
        }
    }

    public ArrayList<Path> getNeighbors( ) {
        ArrayList<Path> neighbors= new ArrayList<>();
        for(Node n : head.getNeighbors()) {
            neighbors.add(new Path(n));
        }
        return neighbors;
    }

    public boolean equals(Object p) {
        int[] thisLoc = head.getLocation();
        int[] pLoc = ((Path)p).getHead().getLocation();
        return pLoc[0] == thisLoc[0] && pLoc[1] == thisLoc[1];
    }

    public Node getHead() {
        return head;
    }

    //////////////////////////////////
    //  Color Modification Methods  //
    //////////////////////////////////

    public void paintCurrent() {
        Node curr = head;
        while (curr != null) {
            curr.setCurrentPath();
            curr = curr.getPrev();
        }
    }

    public void paintFrontier() {
        Node curr = head;
        while(curr != null) {
            curr.setFrontier();
            curr = curr.getPrev();
        }
    }

    public void paintClosed() {
        Node curr = head;
        while(curr != null) {
            curr.setClosed();
            curr = curr.getPrev();
        }
    }

    public String toString() {
        int[] loc = head.getLocation();
        return "[" + loc[0] + ", " + loc[1] + "]";
    }

}
