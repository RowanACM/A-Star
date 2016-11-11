package astar;

import gui.AStarWindow;
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
        int myCost = score();
        int compCost = compared.score();// + compared.getHead().getCost();

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
        ArrayList<Node> nodes= head.getNeighbors();
        for(Node n : nodes) {
            neighbors.add(new Path(n));
        }
        return neighbors;
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
