package graph.unweighted.directed;

import java.util.ArrayList;
import java.util.List;

public class UnweightedDirectedVertex {

    private String name;
    private List<UnweightedDirectedEdge> edges;
    private int distance;
    private UnweightedDirectedVertex previous;

    public UnweightedDirectedVertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(UnweightedDirectedEdge edge) {
        edges.add(edge);
    }

    public void reset() {
        distance = 0;
        previous = null;
    }

    public void print() {
        for (UnweightedDirectedEdge edge : edges) {
            System.out.println(name + " -> " + edge.getDestination().getName());
        }
    }

    public String getName() {
        return name;
    }

    public List<UnweightedDirectedEdge> getEdges() {
        return edges;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public UnweightedDirectedVertex getPrevious() {
        return previous;
    }

    public void setPrevious(UnweightedDirectedVertex previous) {
        this.previous = previous;
    }
}