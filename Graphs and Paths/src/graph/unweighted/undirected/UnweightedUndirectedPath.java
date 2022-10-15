package graph.unweighted.undirected;

import graph.Path;

import java.util.List;

public class UnweightedUndirectedPath implements Path {

    private List<UnweightedUndirectedVertex> vertices;
    private int steps;

    public UnweightedUndirectedPath(List<UnweightedUndirectedVertex> vertices, int steps) {
        this.vertices = vertices;
        this.steps = steps;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("From ");
        sb.append(vertices.get(0).getName());
        sb.append(" to ");
        sb.append(vertices.get(vertices.size() - 1).getName());
        sb.append(" takes ");
        sb.append(steps);
        sb.append(" steps: ");

        for (UnweightedUndirectedVertex vertex : vertices) {
            sb.append(vertex.getName());
            sb.append(" -> ");
        }

        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.toString());
    }
}