package graph.unweighted.undirected;

import graph.Graph;
import graph.Path;

import java.util.*;

public class UnweightedUndirectedGraph extends Graph {

    private HashMap<String, UnweightedUndirectedVertex> vertices;

    public UnweightedUndirectedGraph(String[][] schema) {
        vertices = new HashMap<>();
        createGraph(schema);
    }

    private void createGraph(String[][] schema) {
        for (int i = 0; i < schema.length; i++) {
            UnweightedUndirectedVertex vertex1;
            UnweightedUndirectedVertex vertex2;

            if (vertices.get(schema[i][0]) == null) {
                vertex1 = new UnweightedUndirectedVertex(schema[i][0]);
                vertices.put(vertex1.getName(), vertex1);
            } else {
                vertex1 = vertices.get(schema[i][0]);
            }

            if (vertices.get(schema[i][1]) == null) {
                vertex2 = new UnweightedUndirectedVertex(schema[i][1]);
                vertices.put(vertex2.getName(), vertex2);
            } else {
                vertex2 = vertices.get(schema[i][1]);
            }

            UnweightedUndirectedEdge edge1 = new UnweightedUndirectedEdge(vertex2);
            UnweightedUndirectedEdge edge2 = new UnweightedUndirectedEdge(vertex1);
            vertex1.addEdge(edge1);
            vertex2.addEdge(edge2);
        }
    }

    @Override
    public Path getShortestPath(String s, String f) {
        reset();
        UnweightedUndirectedVertex start = vertices.get(s);
        UnweightedUndirectedVertex finish = vertices.get(f);
        shortestPathsFromVertexToAllOthers(start);
        UnweightedUndirectedPath path = createShortestPath(start, finish);
        reset();
        return path;
    }

    private void shortestPathsFromVertexToAllOthers(UnweightedUndirectedVertex start) {
        for (UnweightedUndirectedVertex vertex : vertices.values()) {
            vertex.setDistance(INFINITY);
        }

        PriorityQueue<UnweightedUndirectedVertex> pq = new PriorityQueue<UnweightedUndirectedVertex>(vertices.size(), new Comparator<UnweightedUndirectedVertex>() {
            @Override
            public int compare(UnweightedUndirectedVertex v1, UnweightedUndirectedVertex v2) {
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
            UnweightedUndirectedVertex vertex = pq.poll();
            for (UnweightedUndirectedEdge edge : vertex.getEdges()) {
                UnweightedUndirectedVertex destination = edge.getDestination();
                if (destination.getDistance() == INFINITY) {
                    destination.setDistance(vertex.getDistance() + 1);
                    destination.setPrevious(vertex);
                    pq.add(destination);
                }
            }
        }
    }

    private UnweightedUndirectedPath createShortestPath(UnweightedUndirectedVertex start, UnweightedUndirectedVertex finish) {
        int steps = finish.getDistance();

        List<UnweightedUndirectedVertex> reversePathList = new ArrayList<>();
        UnweightedUndirectedVertex vertex = finish;
        while (vertex.getPrevious() != null) {
            reversePathList.add(vertex);
            vertex = vertex.getPrevious();
        }
        reversePathList.add(start);

        List<UnweightedUndirectedVertex> pathList = new ArrayList<>();
        for (int i = reversePathList.size() - 1; i >= 0; i--) {
            pathList.add(reversePathList.get(i));
        }

        return new UnweightedUndirectedPath(pathList, steps);
    }

    private void reset() {
        for (UnweightedUndirectedVertex vertex : vertices.values()) {
            vertex.reset();
        }
    }

    @Override
    public boolean isConnected() {
        boolean connected = true;
        reset();

        Object[] ovts = vertices.values().toArray();
        UnweightedUndirectedVertex[] vts = new UnweightedUndirectedVertex[ovts.length];
        for (int i = 0; i < ovts.length; i++) {
            vts[i] = (UnweightedUndirectedVertex) ovts[1];
        }

        shortestPathsFromVertexToAllOthers(vts[0]);
        for (UnweightedUndirectedVertex vertex : vertices.values()) {
            if (vertex.getDistance() == INFINITY) {
                connected = false;
            }
        }

        reset();
        return connected;
    }

    @Override
    public void print() {
        System.out.println("Unweighted undirected Graph:");
        for (UnweightedUndirectedVertex vertex : vertices.values()) {
            vertex.print();
        }
    }
}