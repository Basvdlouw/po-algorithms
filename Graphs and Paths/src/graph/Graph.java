package graph;

public abstract class Graph {

    protected final int INFINITY = -1;

    public abstract Path getShortestPath(String s, String f);

    public abstract boolean isConnected();

    public abstract void print();
}