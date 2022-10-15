import graph.Graph;
import graph.unweighted.directed.UnweightedDirectedGraph;
import graph.unweighted.undirected.UnweightedUndirectedGraph;
import graph.weighted.directed.WeightedDirectedGraph;
import graph.weighted.undirected.WeightedUndirectedGraph;

public class Main {

    public static void main(String[] args) {
        String[][] unweightedSchema = {
                {"V0", "V1"},
                {"V0", "V3"},
                {"V1", "V3"},
                {"V1", "V4"},
                {"V2", "V0"},
                {"V2", "V5"},
                {"V3", "V2"},
                {"V3", "V4"},
                {"V3", "V5"},
                {"V3", "V6"},
                {"V4", "V6"},
                {"V6", "V5"}
        };

        String[][] weightedSchema = {
                {"V0", "V1", "2"},
                {"V0", "V3", "1"},
                {"V1", "V3", "3"},
                {"V1", "V4", "10"},
                {"V2", "V0", "4"},
                {"V2", "V5", "5"},
                {"V3", "V2", "2"},
                {"V3", "V4", "2"},
                {"V3", "V5", "8"},
                {"V3", "V6", "4"},
                {"V4", "V6", "6"},
                {"V6", "V5", "1"}
        };

        Graph unweightedDirectedGraph = new UnweightedDirectedGraph(unweightedSchema);
        unweightedDirectedGraph.print();
        System.out.println("Is connected: " + unweightedDirectedGraph.isConnected());
        unweightedDirectedGraph.getShortestPath("V2", "V4").print();

        System.out.println();

        Graph unweightedUndirectedGraph = new UnweightedUndirectedGraph(unweightedSchema);
        unweightedUndirectedGraph.print();
        System.out.println("Is connected: " + unweightedUndirectedGraph.isConnected());
        unweightedUndirectedGraph.getShortestPath("V2", "V4").print();

        System.out.println();

        Graph weightedDirectedGraph = new WeightedDirectedGraph(weightedSchema);
        weightedDirectedGraph.print();
        System.out.println("Is connected: " + weightedDirectedGraph.isConnected());
        weightedDirectedGraph.getShortestPath("V0", "V5").print();

        System.out.println();

        Graph weightedUndirectedGraph = new WeightedUndirectedGraph(weightedSchema);
        weightedUndirectedGraph.print();
        System.out.println("Is connected: " + weightedUndirectedGraph.isConnected());
        weightedUndirectedGraph.getShortestPath("V0", "V5").print();
    }
}