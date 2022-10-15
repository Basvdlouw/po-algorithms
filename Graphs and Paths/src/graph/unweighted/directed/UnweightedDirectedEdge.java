package graph.unweighted.directed;

public class UnweightedDirectedEdge {

    private UnweightedDirectedVertex destination;

    public UnweightedDirectedEdge(UnweightedDirectedVertex destination) {
        this.destination = destination;
    }

    public UnweightedDirectedVertex getDestination() {
        return destination;
    }
}