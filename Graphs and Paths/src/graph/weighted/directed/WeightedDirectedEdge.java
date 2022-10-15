package graph.weighted.directed;

public class WeightedDirectedEdge {

    private WeightedDirectedVertex destination;
    private double weight;

    public WeightedDirectedEdge(WeightedDirectedVertex destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public WeightedDirectedVertex getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}