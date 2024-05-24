package org.example;

import java.util.*;

public class Search<Vertex> {
    protected Set<Vertex> marked; // Set to store visited vertices
    protected Map<Vertex, Vertex> edgeTo; // Map to store edges leading to each vertex
    protected final Vertex source; // Source vertex for the search

    // Constructor initializes the search with a source vertex
    public Search(Vertex source) {
        this.source = source; // Set the source vertex
        marked = new HashSet<>(); // Initialize the set of marked vertices
        edgeTo = new HashMap<>(); // Initialize the map of edges
    }

    // Check if there is a path to a specific vertex
    public boolean hasPathTo(Vertex v) {
        return marked.contains(v); // Return true if the vertex is marked (visited)
    }

    // Get the path to a specific vertex (if it exists)
    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null; // If there is no path, return null

        LinkedList<Vertex> ls = new LinkedList<>(); // Create a linked list to store the path
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i); // Add vertices to the list (in reverse order)
        }

        ls.push(source); // Add the source vertex to complete the path

        return ls; // Return the path
    }
}
