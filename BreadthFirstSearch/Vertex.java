package BreadthFirstSearch;

import java.util.ArrayList;

public class Vertex {

    /*
        Every vertex object contains data variable (which we will use to identify a vertex when we print it out),
        isVisited variable (so we know if we visited it when traversing graph),
        and a list of neighbours of every vertex.
     */
    private boolean isVisited = false;
    private int data;
    private ArrayList<Vertex> listOfNeighbours;

    public Vertex(int data){
        this.data = data;
        listOfNeighbours = new ArrayList<>();
    }

    public boolean isVisted(){
        return isVisited;
    }

    public void setVisited(){
        isVisited = true;
    }

    public void addNeighbourVertex(Vertex vertex){
        listOfNeighbours.add(vertex);
    }

    public ArrayList<Vertex> getListOfNeighbours(){
        return listOfNeighbours;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
