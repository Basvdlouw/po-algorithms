package graph.unweighted.directed;

import graph.Graph;
import graph.Path;

import java.util.*;

public class UnweightedDirectedGraph extends Graph {

    private HashMap<String, UnweightedDirectedVertex> vertices;

    public UnweightedDirectedGraph(String[][] schema) {
        vertices = new HashMap<>();
        createGraph(schema);
    }

    private void createGraph(String[][] schema) {
        for (int i = 0; i < schema.length; i++) {
            UnweightedDirectedVertex vertex;
            UnweightedDirectedVertex destination;

            if (vertices.get(schema[i][0]) == null) {
                vertex = new UnweightedDirectedVertex(schema[i][0]);
                vertices.put(vertex.getName(), vertex);
            } else {
                vertex = vertices.get(schema[i][0]);
            }

            if (vertices.get(schema[i][1]) == null) {
                destination = new UnweightedDirectedVertex(schema[i][1]);
                vertices.put(destination.getName(), destination);
            } else {
                destination = vertices.get(schema[i][1]);
            }

            UnweightedDirectedEdge edge = new UnweightedDirectedEdge(destination);
            vertex.addEdge(edge);
        }
    }

    @Override
    public Path getShortestPath(String s, String f) {
        reset();
        UnweightedDirectedVertex start = vertices.get(s);
        UnweightedDirectedVertex finish = vertices.get(f);
        shortestPathsFromVertexToAllOthers(start);
        UnweightedDirectedPath path = createShortestPath(start, finish);
        reset();
        return path;
    }

    private void shortestPathsFromVertexToAllOthers(UnweightedDirectedVertex start) {
        for (UnweightedDirectedVertex vertex : vertices.values()) {
            vertex.setDistance(INFINITY);
        }

        PriorityQueue<UnweightedDirectedVertex> pq = new PriorityQueue<UnweightedDirectedVertex>(vertices.size(), new Comparator<UnweightedDirectedVertex>() {
            @Override
            public int compare(UnweightedDirectedVertex v1, UnweightedDirectedVertex v2) {
                if (v1.getDistance() < v2.getDistance()) {
                    return -1;
                } else if (v1.getDistance() > v2.getDistance()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        pq.add(start);
        start.setDistance(0);

        while (!pq.isEmpty()) {
            UnweightedDirectedVertex vertex = pq.poll();
            for (UnweightedDirectedEdge edge : vertex.getEdges()) {
                UnweightedDirectedVertex destination = edge.getDestination();
                if (destination.getDistance() == INFINITY) {
                    destination.setDistance(vertex.getDistance() + 1);
                    destination.setPrevious(vertex);
                    pq.add(destination);
                }
            }
        }
    }

    private UnweightedDirectedPath createShortestPath(UnweightedDirectedVertex start, UnweightedDirectedVertex finish) {
        int steps = finish.getDistance();

        List<UnweightedDirectedVertex> reversePathList = new ArrayList<>();
        UnweightedDirectedVertex vertex = finish;
        while (vertex.getPrevious() != null) {
            reversePathList.add(vertex);
            vertex = vertex.getPrevious();
        }
        reversePathList.add(start);

        List<UnweightedDirectedVertex> pathList = new ArrayList<>();
        for (int i = reversePathList.size() - 1; i >= 0; i--) {
            pathList.add(reversePathList.get(i));
        }

        return new UnweightedDirectedPath(pathList, steps);
    }

    private void reset() {
        for (UnweightedDirectedVertex vertex : vertices.values()) {
            vertex.reset();
        }
    }

    @Override
    public boolean isConnected() {
        boolean connected = true;
        reset();

        Object[] ovts = vertices.values().toArray();
        UnweightedDirectedVertex[] vts = new UnweightedDirectedVertex[ovts.length];
        for (int i = 0; i < ovts.length; i++) {
            vts[i] = (UnweightedDirectedVertex) ovts[1];
        }

        shortestPathsFromVertexToAllOthers(vts[0]);
        for (UnweightedDirectedVertex vertex : vertices.values()) {
            if (vertex.getDistance() == INFINITY) {
                connected = false;
            }
        }

        reset();
        return connected;
    }

    @Override
    public void print() {
        System.out.println("Unweighted directed Graph:");
        for (UnweightedDirectedVertex vertex : vertices.values()) {
            vertex.print();
        }
    }
}