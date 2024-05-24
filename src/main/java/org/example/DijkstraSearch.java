package org.example;

import java.util.*;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes; // Set of unsettled (unvisited) nodes
    private final Map<Vertex, Double> distances; // Map to store shortest distances from source
    private final WeightedGraph<Vertex> graph; // Reference to the weighted graph

    // Constructor for Dijkstra's algorithm
    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source) {
        super(source);
        unsettledNodes = new HashSet<>(); // Initialize the set of unsettled nodes
        distances = new HashMap<>(); // Initialize the map for distances
        this.graph = graph; // Initialize the reference to the weighted graph

        dijkstra(); // Perform Dijkstra's algorithm
    }

    // Dijkstra's algorithm for finding shortest paths
    public void dijkstra() {
        distances.put(source, 0D); // Set the distance of the source vertex to 0
        unsettledNodes.add(source); // Add the source vertex to the set of unsettled nodes

        // Continue until there are unsettled nodes
        while (!unsettledNodes.isEmpty()) {
            // Get the vertex with the minimum distance among unsettled nodes
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode); // Mark the current node as visited
            unsettledNodes.remove(currentNode); // Remove the current node from the set of unsettled nodes

            // Iterate over neighbors of the current node
            for (Vertex neighbor : graph.adjacencyList(currentNode)) {
                // Calculate the new distance to the neighbor through the current node
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                // Update the shortest distance to the neighbor if a shorter path is found
                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance); // Update the shortest distance
                    edgeTo.put(neighbor, currentNode); // Record the edge leading to the neighbor
                    unsettledNodes.add(neighbor); // Add the neighbor to the set of unsettled nodes
                }
            }
        }
    }

    // Get the distance between two vertices in the graph
    private double getDistance(Vertex node, Vertex target) {
        for (Edge<Vertex> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight(); // Return the weight of the edge to the target vertex
        }

        throw new RuntimeException("Edge not found!"); // Throw an exception if the edge is not found
    }

    // Get the vertex with the minimum distance among a set of vertices
    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex; // Update the minimum vertex if the current vertex has a shorter distance
            }
        }
        return minimum; // Return the vertex with the minimum distance
    }

    // Get the shortest distance to a destination vertex
    private double getShortestDistance(Vertex destination) {
        Double d = distances.get(destination); // Get the distance from the map
        return (d == null ? Double.MAX_VALUE : d); // Return the distance or maximum value if not found
    }
}
