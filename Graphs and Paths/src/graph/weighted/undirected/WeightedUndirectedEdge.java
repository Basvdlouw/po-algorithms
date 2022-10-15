package graph.weighted.undirected;

public class WeightedUndirectedEdge {

    private WeightedUndirectedVertex destination;
    private double weight;

    public WeightedUndirectedEdge(WeightedUndirectedVertex destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public WeightedUndirectedVertex getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}