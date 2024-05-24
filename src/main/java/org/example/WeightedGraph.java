package org.example;

import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected; // Flag indicating if the graph is undirected
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>(); // Map to store vertices and their adjacent edges

    // Constructor to create a weighted graph (default: undirected)
    public WeightedGraph() {
        this(true); // Call the constructor with the default parameter
    }

    // Constructor to create a weighted graph with specified directionality
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected; // Set the directionality of the graph
    }

    // Add a vertex to the graph
    public void addVertex(Vertex v) {
        if (hasVertex(v)) // If the vertex already exists, return
            return;

        map.put(v, new LinkedList<>()); // Add the vertex to the map with an empty list of edges
    }

    // Add a weighted edge between two vertices
    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source)) // If the source vertex doesn't exist, add it
            addVertex(source);

        if (!hasVertex(dest)) // If the destination vertex doesn't exist, add it
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest)) // Reject parallel edges and self-loops
            return;

        map.get(source).add(new Edge<>(source, dest, weight)); // Add the edge from source to destination

        if (undirected) // If the graph is undirected, add the reverse edge as well
            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    // Get the number of vertices in the graph
    public int getVerticesCount() {
        return map.size();
    }

    // Get the number of edges in the graph
    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected) // If the graph is undirected, divide the count by 2
            count /= 2;

        return count;
    }

    // Check if the graph contains a vertex
    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    // Check if the graph contains an edge between two vertices
    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) // If the source vertex doesn't exist, return false
            return false;

        return map.get(source).contains(new Edge<>(source, dest)); // Check if the edge exists in the list of edges
    }

    // Get the adjacency list of a vertex (list of adjacent vertices)
    public List<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) // If the vertex doesn't exist, return null
            return null;

        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : map.get(v)) {
            vertices.add(e.getDest()); // Add the destination vertex of each edge to the list
        }

        return vertices; // Return the adjacency list
    }

    // Get the list of edges incident to a vertex
    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        if (!hasVertex(v)) // If the vertex doesn't exist, return null
            return null;

        return map.get(v); // Return the list of edges associated with the vertex
    }
}
