package graph.weighted.undirected;

import graph.Path;

import java.util.List;

public class WeightedUndirectedPath implements Path {

    private List<WeightedUndirectedVertex> vertices;
    private double weight;

    public WeightedUndirectedPath(List<WeightedUndirectedVertex> vertices, double weight) {
        this.vertices = vertices;
        this.weight = weight;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("From ");
        sb.append(vertices.get(0).getName());
        sb.append(" to ");
        sb.append(vertices.get(vertices.size() - 1).getName());
        sb.append(" has a weight of ");
        sb.append(weight);
        sb.append(" : ");

        for (WeightedUndirectedVertex vertex : vertices) {
            sb.append(vertex.getName());
            sb.append(" -> ");
        }

        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.toString());
    }
}