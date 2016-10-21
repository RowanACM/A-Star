package astar;

import gui.AStarWindow;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by lapost48 & Sean Mulhall on 9/23/2016.
 */
public class AStarMain {

    public static void main(String[] args) {

        AStarWindow w = new AStarWindow("A*", 15, 15);

        PriorityQueue<Path>  frontier = new PriorityQueue<>();
        ArrayList<Path> closed = new ArrayList<>();

        boolean finished = false;
        while(frontier.size() != 0) {
            Path current = frontier.poll();

            if (current.head.getCost() == end){
                return current;
            }
            
            frontier.remove(current);
            closed.add(current);
            current.paintClosed();

            for (://foreach neighbor of current
                 ) {
                
            }

            //TODO: EVERYTHING ELSE

        }

    }

}
