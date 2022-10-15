package graph.weighted.undirected;

import graph.Graph;
import graph.Path;

import java.util.*;

public class WeightedUndirectedGraph extends Graph {

    private HashMap<String, WeightedUndirectedVertex> vertices;

    public WeightedUndirectedGraph(String[][] schema) {
        vertices = new HashMap<>();
        createGraph(schema);
    }

    private void createGraph(String[][] schema) {
        for (int i = 0; i < schema.length; i++) {
            WeightedUndirectedVertex vertex1;
            WeightedUndirectedVertex vertex2;
            double weight = Double.parseDouble(schema[i][2]);

            if (vertices.get(schema[i][0]) == null) {
                vertex1 = new WeightedUndirectedVertex(schema[i][0]);
                vertices.put(vertex1.getName(), vertex1);
            } else {
                vertex1 = vertices.get(schema[i][0]);
            }

            if (vertices.get(schema[i][1]) == null) {
                vertex2 = new WeightedUndirectedVertex(schema[i][1]);
                vertices.put(vertex2.getName(), vertex2);
            } else {
                vertex2 = vertices.get(schema[i][1]);
            }

            WeightedUndirectedEdge edge1 = new WeightedUndirectedEdge(vertex2, weight);
            WeightedUndirectedEdge edge2 = new WeightedUndirectedEdge(vertex1, weight);
            vertex1.addEdge(edge1);
            vertex2.addEdge(edge2);
        }
    }

    @Override
    public Path getShortestPath(String s, String f) {
        reset();
        WeightedUndirectedVertex start = vertices.get(s);
        WeightedUndirectedVertex finish = vertices.get(f);
        shortestPathsFromVertexToAllOthers(start);
        WeightedUndirectedPath path = createShortestPath(start, finish);
        reset();
        return path;
    }

    private void shortestPathsFromVertexToAllOthers(WeightedUndirectedVertex start) {
        for (WeightedUndirectedVertex vertex : vertices.values()) {
            vertex.setDistance(INFINITY);
        }

        PriorityQueue<WeightedUndirectedVertex> pq = new PriorityQueue<WeightedUndirectedVertex>(vertices.size(), new Comparator<WeightedUndirectedVertex>() {
            @Override
            public int compare(WeightedUndirectedVertex v1, WeightedUndirectedVertex v2) {
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
            WeightedUndirectedVertex vertex = pq.poll();
            for (WeightedUndirectedEdge edge : vertex.getEdges()) {
                WeightedUndirectedVertex destination = edge.getDestination();
                if (destination.getDistance() == INFINITY) {
                    destination.setDistance(vertex.getDistance() + edge.getWeight());
                    destination.setPrevious(vertex);
                    pq.add(destination);
                } else if (vertex.getDistance() + edge.getWeight() < destination.getDistance()) {
                    destination.setDistance(vertex.getDistance() + edge.getWeight());
                    destination.setPrevious(vertex);
                }
            }
        }
    }

    private WeightedUndirectedPath createShortestPath(WeightedUndirectedVertex start, WeightedUndirectedVertex finish) {
        double distance = finish.getDistance();

        List<WeightedUndirectedVertex> reversePathList = new ArrayList<>();
        WeightedUndirectedVertex vertex = finish;
        while (vertex.getPrevious() != null) {
            reversePathList.add(vertex);
            vertex = vertex.getPrevious();
        }
        reversePathList.add(start);

        List<WeightedUndirectedVertex> pathList = new ArrayList<>();
        for (int i = reversePathList.size() - 1; i >= 0; i--) {
            pathList.add(reversePathList.get(i));
        }

        return new WeightedUndirectedPath(pathList, distance);
    }

    private void reset() {
        for (WeightedUndirectedVertex vertex : vertices.values()) {
            vertex.reset();
        }
    }

    @Override
    public boolean isConnected() {
        boolean connected = true;
        reset();

        Object[] ovts = vertices.values().toArray();
        WeightedUndirectedVertex[] vts = new WeightedUndirectedVertex[ovts.length];
        for (int i = 0; i < ovts.length; i++) {
            vts[i] = (WeightedUndirectedVertex) ovts[1];
        }

        shortestPathsFromVertexToAllOthers(vts[0]);
        for (WeightedUndirectedVertex vertex : vertices.values()) {
            if (vertex.getDistance() == INFINITY) {
                connected = false;
            }
        }

        reset();
        return connected;
    }

    @Override
    public void print() {
        System.out.println("Weighted undirected Graph:");
        for (WeightedUndirectedVertex vertex : vertices.values()) {
            vertex.print();
        }
    }
}