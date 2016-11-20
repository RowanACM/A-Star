package astar;

import gui.Tile;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class Path {

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

}
