package graph.weighted.directed;

import graph.Path;

import java.util.List;

public class WeightedDirectedPath implements Path {

    private List<WeightedDirectedVertex> vertices;
    private double weight;

    public WeightedDirectedPath(List<WeightedDirectedVertex> vertices, double weight) {
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

        for (WeightedDirectedVertex vertex : vertices) {
            sb.append(vertex.getName());
            sb.append(" -> ");
        }

        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.toString());
    }
}