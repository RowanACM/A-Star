package astar;

import gui.AStarWindow;
import gui.Tile;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by lapost48 on 9/23/2016.
 */
public class AStarMain {

    public static void main(String[] args) {

        AStarWindow w = new AStarWindow("A*", 15, 15);

        PriorityQueue<Path>  frontier = new PriorityQueue<>();
        ArrayList<Path> closed = new ArrayList<>();

        Tile startTile = w.tiles[10][10];
        Tile goalTile = w.tiles[4][4];
        Node goal = new Node(goalTile,null);

        frontier.add(new Path(startTile));

        boolean finished = false;
        while(!finished) {
            Path current = frontier.poll();
            if(current.getHead().equals(goal)) {
               finished = true;
            }
            else {
                frontier.remove(current);
                closed.add(current);

                ArrayList<Path> neighbors;// = new ArrayList<>();
                neighbors = current.getNeighbors(w);

                for(Path neighbor: neighbors) {
                    if(!closed.contains(neighbor)) {

                    //} else {
                        //int tentative = current.score() + neighbor.getHead().getCost(); //?
                        if(!frontier.contains(neighbor))
                            frontier.add(neighbor);
                       // else if(tentative >= )
                    }

                }

            }


        }
        /*
            while openSet is not empty
        current := the node in openSet having the lowest fScore[] value
        if current = goal
            return reconstruct_path(cameFrom, current)

        openSet.Remove(current)
        closedSet.Add(current)
        for each neighbor of current
            if neighbor in closedSet
                continue		// Ignore the neighbor which is already evaluated.
            // The distance from start to a neighbor
            tentative_gScore := gScore[current] + dist_between(current, neighbor)
            if neighbor not in openSet	// Discover a new node
                openSet.Add(neighbor)
            else if tentative_gScore >= gScore[neighbor]
                continue		// This is not a better path.

            // This path is the best until now. Record it!
            cameFrom[neighbor] := current
            gScore[neighbor] := tentative_gScore
            fScore[neighbor] := gScore[neighbor] + heuristic_cost_estimate(neighbor, goal)

    return failure

         */

    }

}
