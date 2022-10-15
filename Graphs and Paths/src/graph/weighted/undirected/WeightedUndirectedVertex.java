package graph.weighted.undirected;

import java.util.ArrayList;
import java.util.List;

public class WeightedUndirectedVertex {

    private String name;
    private List<WeightedUndirectedEdge> edges;
    private double distance;
    private WeightedUndirectedVertex previous;

    public WeightedUndirectedVertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(WeightedUndirectedEdge edge) {
        edges.add(edge);
    }

    public void reset() {
        distance = 0;
        previous = null;
    }

    public void print() {
        for (WeightedUndirectedEdge edge : edges) {
            System.out.println(name + " <-> " + edge.getDestination().getName() + " with a weight of " + edge.getWeight());
        }
    }

    public String getName() {
        return name;
    }

    public List<WeightedUndirectedEdge> getEdges() {
        return edges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public WeightedUndirectedVertex getPrevious() {
        return previous;
    }

    public void setPrevious(WeightedUndirectedVertex previous) {
        this.previous = previous;
    }
}