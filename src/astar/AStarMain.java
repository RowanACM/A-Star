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
        int[] goalLoc= {4,4};
        int[] startLoc = {10,10};
        Node goal = new Node(goalLoc, goalTile,null);

        frontier.add(new Path(startTile, startLoc));

        boolean finished = false;
        while(!finished) {
            current = frontier.poll();


            if(current.getHead().equals(goal)) {
               finished = true;
            }
            else {
                closed.add(current);

                ArrayList<Path> neighbors = current.getNeighbors();

                for(Path neighbor: neighbors) {
                    if(!closed.contains(neighbor) && !frontier.contains(neighbor)) {
                        frontier.add(neighbor);
                        current.paintFrontier();
                    }

                }

            }

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
