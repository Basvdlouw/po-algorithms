package graph.weighted.directed;

import graph.Graph;
import graph.Path;

import java.util.*;

public class WeightedDirectedGraph extends Graph {

    private HashMap<String, WeightedDirectedVertex> vertices;

    public WeightedDirectedGraph(String[][] schema) {
        vertices = new HashMap<>();
        createGraph(schema);
    }

    private void createGraph(String[][] schema) {
        for (int i = 0; i < schema.length; i++) {
            WeightedDirectedVertex vertex;
            WeightedDirectedVertex destination;
            double weight = Double.parseDouble(schema[i][2]);

            if (vertices.get(schema[i][0]) == null) {
                vertex = new WeightedDirectedVertex(schema[i][0]);
                vertices.put(vertex.getName(), vertex);
            } else {
                vertex = vertices.get(schema[i][0]);
            }

            if (vertices.get(schema[i][1]) == null) {
                destination = new WeightedDirectedVertex(schema[i][1]);
                vertices.put(destination.getName(), destination);
            } else {
                destination = vertices.get(schema[i][1]);
            }

            WeightedDirectedEdge edge = new WeightedDirectedEdge(destination, weight);
            vertex.addEdge(edge);
        }
    }

    @Override
    public Path getShortestPath(String s, String f) {
        reset();
        WeightedDirectedVertex start = vertices.get(s);
        WeightedDirectedVertex finish = vertices.get(f);
        shortestPathsFromVertexToAllOthers(start);
        WeightedDirectedPath path = createShortestPath(start, finish);
        reset();
        return path;
    }

    private void shortestPathsFromVertexToAllOthers(WeightedDirectedVertex start) {
        for (WeightedDirectedVertex vertex : vertices.values()) {
            vertex.setDistance(INFINITY);
        }

        PriorityQueue<WeightedDirectedVertex> pq = new PriorityQueue<WeightedDirectedVertex>(vertices.size(), new Comparator<WeightedDirectedVertex>() {
            @Override
            public int compare(WeightedDirectedVertex v1, WeightedDirectedVertex v2) {
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
            WeightedDirectedVertex vertex = pq.poll();
            for (WeightedDirectedEdge edge : vertex.getEdges()) {
                WeightedDirectedVertex destination = edge.getDestination();
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

    private WeightedDirectedPath createShortestPath(WeightedDirectedVertex start, WeightedDirectedVertex finish) {
        double distance = finish.getDistance();

        List<WeightedDirectedVertex> reversePathList = new ArrayList<>();
        WeightedDirectedVertex vertex = finish;
        while (vertex.getPrevious() != null) {
            reversePathList.add(vertex);
            vertex = vertex.getPrevious();
        }
        reversePathList.add(start);

        List<WeightedDirectedVertex> pathList = new ArrayList<>();
        for (int i = reversePathList.size() - 1; i >= 0; i--) {
            pathList.add(reversePathList.get(i));
        }

        return new WeightedDirectedPath(pathList, distance);
    }

    private void reset() {
        for (WeightedDirectedVertex vertex : vertices.values()) {
            vertex.reset();
        }
    }

    @Override
    public boolean isConnected() {
        boolean connected = true;
        reset();

        Object[] ovts = vertices.values().toArray();
        WeightedDirectedVertex[] vts = new WeightedDirectedVertex[ovts.length];
        for (int i = 0; i < ovts.length; i++) {
            vts[i] = (WeightedDirectedVertex) ovts[1];
        }

        shortestPathsFromVertexToAllOthers(vts[0]);
        for (WeightedDirectedVertex vertex : vertices.values()) {
            if (vertex.getDistance() == INFINITY) {
                connected = false;
            }
        }

        reset();
        return connected;
    }

    @Override
    public void print() {
        System.out.println("Weighted directed Graph:");
        for (WeightedDirectedVertex vertex : vertices.values()) {
            vertex.print();
        }
    }
}