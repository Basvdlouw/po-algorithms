package graph.unweighted.undirected;

public class UnweightedUndirectedEdge {

    private UnweightedUndirectedVertex destination;

    public UnweightedUndirectedEdge(UnweightedUndirectedVertex destination) {
        this.destination = destination;
    }

    public UnweightedUndirectedVertex getDestination() {
        return destination;
    }
}