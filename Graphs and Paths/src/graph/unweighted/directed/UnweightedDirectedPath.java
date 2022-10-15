package graph.unweighted.directed;

import graph.Path;

import java.util.List;

public class UnweightedDirectedPath implements Path {

    private List<UnweightedDirectedVertex> vertices;
    private int steps;

    public UnweightedDirectedPath(List<UnweightedDirectedVertex> vertices, int steps) {
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

        for (UnweightedDirectedVertex vertex : vertices) {
            sb.append(vertex.getName());
            sb.append(" -> ");
        }

        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.toString());
    }
}