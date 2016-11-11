package astar;

import gui.AStarWindow;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class AStarMain {

    public static void main(String[] args) {

		int[] winSize = AStarWindow.getTilesSize();
        Node.ROW_LIMIT = winSize[0];
        Node.COL_LIMIT = winSize[1];

        PriorityQueue<Path>  frontier = new PriorityQueue<>();
        ArrayList<Path> closed = new ArrayList<>();
        int[] startLocation = {0, 0};
        int[] endLocation = AStarWindow.getRandLocation();

        Path current = new Path(AStarWindow.getInstance().getTile(startLocation), startLocation);

        //set start tile and end tile before
        //moving into this loop so we have a clear goal


        boolean finished = false;
        while(!finished) {

            current = frontier.pull();

            if (current.head.getLocation() == endLocation)
            {
                finished = true;
            }

            frontier.remove(current);
            closed.add(current);

            for()


            for(Path p: closed)
                p.paintClosed();
            for(Path p: frontier)
                p.paintFrontier();
            current.paintCurrent();
            try {
                Thread.sleep(500);
            } catch(Exception e) {}
        }

    }

}
