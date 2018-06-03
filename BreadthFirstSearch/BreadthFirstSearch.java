package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    /*
        breadthFirstSearch method takes single parameter @param startVertex and prints out vertices
        in the order they were visited. We are going to use FIFO(first in first out) data structure
        called queue to achieve level by level traversal  of the graph.

     */
    public void breadthFirstSearch(Vertex startVertex){

        Queue<Vertex> queue = new LinkedList<>();

        queue.add(startVertex);
        startVertex.setVisited();

        while (!queue.isEmpty()){

            Vertex current = queue.poll();
            System.out.print(current);

            for(Vertex vertex : current.getListOfNeighbours()){
                if(!vertex.isVisted()){
                    queue.add(vertex);
                    vertex.setVisited();
                }
            }
        }
    }
}
