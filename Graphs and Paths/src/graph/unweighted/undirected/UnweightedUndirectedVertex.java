package graph.unweighted.undirected;

import java.util.ArrayList;
import java.util.List;

public class UnweightedUndirectedVertex {

    private String name;
    private List<UnweightedUndirectedEdge> edges;
    private int distance;
    private UnweightedUndirectedVertex previous;

    public UnweightedUndirectedVertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(UnweightedUndirectedEdge edge) {
        edges.add(edge);
    }

    public void reset() {
        distance = 0;
        previous = null;
    }

    public void print() {
        for (UnweightedUndirectedEdge edge : edges) {
            System.out.println(name + " <-> " + edge.getDestination().getName());
        }
    }

    public String getName() {
        return name;
    }

    public List<UnweightedUndirectedEdge> getEdges() {
        return edges;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public UnweightedUndirectedVertex getPrevious() {
        return previous;
    }

    public void setPrevious(UnweightedUndirectedVertex previous) {
        this.previous = previous;
    }
}