package org.example;

public class DepthFirstSearch<Vertex> extends Search<Vertex> {

    // Constructor for Depth-First Search
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source); // Start DFS from the source vertex
    }

    // Depth-First Search traversal method
    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current); // Mark the current vertex as visited

        // Visit all adjacent vertices of the current vertex
        for (Vertex v : graph.adjacencyList(current)) {
            // If the adjacent vertex has not been visited yet
            if (!marked.contains(v)) {
                edgeTo.put(v, current); // Record the edge leading to the adjacent vertex
                dfs(graph, v); // Recursively visit the adjacent vertex
            }
        }
    }
}
