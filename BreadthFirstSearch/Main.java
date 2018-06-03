package BreadthFirstSearch;

public class Main {

    public static void main(String[] args) {

        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);
        Vertex vertex6 = new Vertex(6);
        Vertex vertex7 = new Vertex(7);

        vertex1.addNeighbourVertex(vertex4);
        vertex1.addNeighbourVertex(vertex5);
        vertex4.addNeighbourVertex(vertex2);
        vertex5.addNeighbourVertex(vertex3);
        vertex5.addNeighbourVertex(vertex6);
        vertex6.addNeighbourVertex(vertex7);

        BreadthFirstSearch traverseGraph = new BreadthFirstSearch();
        traverseGraph.breadthFirstSearch(vertex1);
    }
}
