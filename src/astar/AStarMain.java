package astar;

import gui.AStarWindow;
import gui.Popup;

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

        Popup.create();
       // while(true) {
         //   if(!AStarWindow.waiting) {
         //       System.out.println("finished waiting");
         //       break;
        //    }
        //}
        try {
            Thread.sleep(5000);     //temporary, must make a decision before 5 seconds is over.
        } catch(Exception e) {}     //defaults to A*

        Path current = new Path(AStarWindow.getInstance().getTile(AStarWindow.startLoc), AStarWindow.startLoc);
        frontier.add(current);

        boolean finished = false;
        while(!finished) {
            current = frontier.poll();


            int[] currLoc = current.getHead().getLocation();
            if(currLoc[0] == AStarWindow.goalLoc[0] && currLoc[1] == AStarWindow.goalLoc[1]) {
                finished = true;
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
                Thread.sleep(500);
            } catch(Exception e) {}
            //*/

        }

    }

}
