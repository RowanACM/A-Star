package astar;

import gui.AStarWindow;
import gui.Tile;

import java.util.ArrayList;


/**
 * Created by lapost48 on 9/23/2016.
 */
public class Path implements Comparable<Path>{

    private Node head;

    public Path(Tile start) {
        head = new Node(start, null);
    }

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

    public int compareTo(Path compared) {
        int myCost = head.getCost() + head.h();
        int compCost = compared.getHead().getCost() + compared.getHead().getCost();

        if (myCost > compCost) {
            return 1;
        } else if(myCost < compCost) {
            return -1;
        } else {
            return 0;
        }
    }

    public ArrayList<Path> getNeighbors( AStarWindow w ) { //imports w to use 2d array of tiles. may/may not be correct
        return null; //TODO: return the 8 adjacent paths
    }

    public Node getHead() {
        return head;
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

}
