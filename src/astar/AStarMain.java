package astar;

import gui.AStarWindow;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by lapost48 on 9/23/2016.
 * modified by aMelchior (aidan)
 */
public class AStarMain {

    public static void main(String[] args) {

		int[] winSize = AStarWindow.getTilesSize();
        Node.ROW_LIMIT = winSize[0];
        Node.COL_LIMIT = winSize[1];

        PriorityQueue<Path>  frontier = new PriorityQueue<>();
        ArrayList<Path> closed = new ArrayList<>();

        //Tile startTile = AStarWindow.tiles[10][10];
        //Tile goalTile = AStarWindow.tiles[4][4];
        int[] goalLoc= {4,7};
        int[] startLoc = {10,10};
        Node goal = new Node(goalLoc, AStarWindow.getInstance().getTile(goalLoc),null);

        Path current = new Path(AStarWindow.getInstance().getTile(startLoc), startLoc);
        frontier.add(current);

        boolean finished = false;
        while(!finished) {
            current = frontier.poll();
            //

            int[] currLoc = current.getHead().getLocation();
            if(currLoc[0] == goalLoc[0] && currLoc[1] == goalLoc[1]) {
                finished = true;
              //  System.out.println("finished");
            }
            else {

                closed.add(current);

                ArrayList<Path> neighbors = current.getNeighbors();

                for(Path neighbor: neighbors) {
                    if(!closed.contains(neighbor) && !frontier.contains(neighbor))
                        frontier.add(neighbor);
                }

            }

            for(Path p: frontier)
                p.paintFrontier();
            for(Path p: closed) {
                p.paintClosed();
                System.out.println(p);
            }
            System.out.println("c" + current + "\n----------------------------------------");
            current.paintCurrent();
            //*
            try {
                //System.out.println("sleeping");
                Thread.sleep(500);
                //System.out.println("done sleeping");
            } catch(Exception e) {}
            //*/

        }

    }

}
