package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {

    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    // Perform Breadth-First Search starting from the given source vertex
    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current); // Mark the current vertex as visited

        // Create a queue for BFS traversal
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current); // Enqueue the current vertex

        // Continue BFS traversal until the queue is empty
        while (!queue.isEmpty()) {
            Vertex v = queue.remove(); // Dequeue a vertex from the queue

            // Visit all adjacent vertices of the dequeued vertex
            for (Vertex vertex : graph.adjacencyList(v)) {
                // If the adjacent vertex has not been visited yet
                if (!marked.contains(vertex)) {
                    marked.add(vertex); // Mark the adjacent vertex as visited
                    edgeTo.put(vertex, v); // Record the edge leading to the adjacent vertex
                    queue.add(vertex); // Enqueue the adjacent vertex for further traversal
                }
            }
        }
    }
}
