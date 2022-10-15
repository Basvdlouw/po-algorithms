package graph.weighted.directed;

import java.util.ArrayList;
import java.util.List;

public class WeightedDirectedVertex {

    private String name;
    private List<WeightedDirectedEdge> edges;
    private double distance;
    private WeightedDirectedVertex previous;

    public WeightedDirectedVertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public void addEdge(WeightedDirectedEdge edge) {
        edges.add(edge);
    }

    public void reset() {
        distance = 0;
        previous = null;
    }

    public void print() {
        for (WeightedDirectedEdge edge : edges) {
            System.out.println(name + " -> " + edge.getDestination().getName() + " with a weight of " + edge.getWeight());
        }
    }

    public String getName() {
        return name;
    }

    public List<WeightedDirectedEdge> getEdges() {
        return edges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public WeightedDirectedVertex getPrevious() {
        return previous;
    }

    public void setPrevious(WeightedDirectedVertex previous) {
        this.previous = previous;
    }
}