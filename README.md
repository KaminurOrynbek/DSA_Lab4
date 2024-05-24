# Weighted Graph Implementation
Assignment 4 for Algorithms and Data Structures

### `Vertex<V>`
- **Fields:**
  - `data`: Represents the data associated with the vertex.
  - `adjacentVertices`: Represents a map of adjacent vertices along with their weights.

- **Methods:**
  - `getData()`: Returns the data associated with the vertex.
  - `setData(V data)`: Sets the data associated with the vertex.
  - `getAdjacentVertices()`: Returns the map of adjacent vertices with their weights.
  - `setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices)`: Sets the map of adjacent vertices.
  - `equals(Object o)`: Overrides the equals method to compare vertices based on their data.
  - `hashCode()`: Overrides the hashCode method to generate a hash code based on the vertex data.
  - `toString()`: Overrides the toString method to provide a string representation of the vertex.

### `Edge<Vertex>`
- **Fields:**
  - `source`: Represents the source vertex of the edge.
  - `dest`: Represents the destination vertex of the edge.
  - `weight`: Represents the weight associated with the edge.

- **Methods:**
  - `getSource()`: Returns the source vertex of the edge.
  - `setSource(Vertex source)`: Sets the source vertex of the edge.
  - `getDest()`: Returns the destination vertex of the edge.
  - `setDest(Vertex dest)`: Sets the destination vertex of the edge.
  - `getWeight()`: Returns the weight associated with the edge.
  - `setWeight(Double weight)`: Sets the weight of the edge.
  - `equals(Object o)`: Overrides the equals method to compare edges based on their source and destination vertices.

### `WeightedGraph<Vertex>`
- **Fields:**
  - `undirected`: Indicates whether the graph is undirected.
  - `map`: Represents a map of vertices along with their adjacent edges.

- **Methods:**
  - `addVertex(Vertex v)`: Adds a vertex to the graph.
  - `addEdge(Vertex source, Vertex dest, double weight)`: Adds a weighted edge between two vertices.
  - `getVerticesCount()`: Returns the number of vertices in the graph.
  - `getEdgesCount()`: Returns the number of edges in the graph.
  - `hasVertex(Vertex v)`: Checks if the graph contains a given vertex.
  - `hasEdge(Vertex source, Vertex dest)`: Checks if the graph contains an edge between two vertices.
  - `adjacencyList(Vertex v)`: Returns the list of adjacent vertices for a given vertex.
  - `getEdges(Vertex v)`: Returns the list of edges incident to a given vertex.

# Graph Search Implementation

This class provides a generic class `Search` for performing graph searches, including marking visited vertices and retrieving paths.

## Class Overview

### `Search<Vertex>`
- **Fields:**
  - `marked`: Set to store visited vertices during the search process.
  - `edgeTo`: Map to store edges leading to each vertex during the search.
  - `source`: Source vertex used as the starting point for the search.

- **Constructor:**
  - `Search(Vertex source)`: Initializes the search with a given source vertex. It initializes the `marked` set and `edgeTo` map.

- **Methods:**
  - `hasPathTo(Vertex v)`: Checks if there is a path from the source vertex to a specified vertex `v`. Returns `true` if the vertex `v` is marked (visited), indicating the presence of a path.
  - `pathTo(Vertex v)`: Retrieves the path from the source vertex to a specified vertex `v`, if it exists. Returns an iterable collection representing the path. If there is no path, returns `null`.

 # Breadth-First Search Implementation

This Java class `BreadthFirstSearch` extends the generic `Search` class and provides functionality for performing breadth-first search (BFS) traversal on a graph.

## Class Overview

### `BreadthFirstSearch<Vertex>`
- **Constructor:**
  - `BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source)`: Initializes the BFS search with a given graph and source vertex. It calls the `bfs` method to perform the BFS traversal.

- **Methods:**
  - `bfs(MyGraph<Vertex> graph, Vertex current)`: Private method to perform BFS traversal starting from the given source vertex `current`.
    - `graph`: The graph on which BFS traversal is performed.
    - `current`: The source vertex for BFS traversal.
    - **Algorithm Steps:**
      1. Mark the current vertex as visited.
      2. Create a queue for BFS traversal.
      3. Enqueue the current vertex into the queue.
      4. Repeat until the queue is empty:
         - Dequeue a vertex from the queue.
         - Visit all adjacent vertices of the dequeued vertex.
         - If an adjacent vertex has not been visited:
           - Mark it as visited.
           - Record the edge leading to the adjacent vertex.
           - Enqueue the adjacent vertex for further traversal.

# Depth-First Search Implementation

This Java class `DepthFirstSearch` extends the generic `Search` class and provides functionality for performing depth-first search (DFS) traversal on a graph.

## Class Overview

### `DepthFirstSearch<Vertex>`
- **Constructor:**
  - `DepthFirstSearch(MyGraph<Vertex> graph, Vertex source)`: Initializes the DFS search with a given graph and source vertex. It calls the `dfs` method to perform the DFS traversal.

- **Methods:**
  - `dfs(MyGraph<Vertex> graph, Vertex current)`: Private method to perform DFS traversal starting from the given source vertex `current`.
    - `graph`: The graph on which DFS traversal is performed.
    - `current`: The source vertex for DFS traversal.
    - **Algorithm Steps:**
      1. Mark the current vertex as visited.
      2. Visit all adjacent vertices of the current vertex.
      3. For each adjacent vertex that has not been visited:
         - Record the edge leading to the adjacent vertex.
         - Recursively visit the adjacent vertex.
# Dijkstra's Algorithm Implementation

This Java class `DijkstraSearch` extends the generic `Search` class and provides functionality for finding shortest paths in a weighted graph using Dijkstra's algorithm.

## Class Overview

### `DijkstraSearch<Vertex>`
- **Fields:**
  - `unsettledNodes`: Set to store unsettled (unvisited) nodes during Dijkstra's algorithm.
  - `distances`: Map to store the shortest distances from the source vertex to each vertex.
  - `graph`: Reference to the weighted graph on which Dijkstra's algorithm is applied.

- **Constructor:**
  - `DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source)`: Initializes the Dijkstra search with a given weighted graph and source vertex. It performs Dijkstra's algorithm to find shortest paths.

- **Methods:**
  - `dijkstra()`: Private method to perform Dijkstra's algorithm for finding shortest paths.
    - **Algorithm Steps:**
      1. Initialize distances: Set the distance of the source vertex to 0 and add it to the set of unsettled nodes.
      2. Repeat until there are no unsettled nodes:
         - Get the vertex with the minimum distance among unsettled nodes.
         - Mark the vertex as visited and remove it from the set of unsettled nodes.
         - Update the distances to its neighbors if shorter paths are found.
  - `getDistance(Vertex node, Vertex target)`: Private method to get the distance between two vertices in the graph.
  - `getVertexWithMinimumWeight(Set<Vertex> vertices)`: Private method to get the vertex with the minimum distance among a set of vertices.
  - `getShortestDistance(Vertex destination)`: Private method to get the shortest distance to a destination vertex.

# Main Class

This Java class `Main` serves as the entry point for the application. It demonstrates the usage of different graph search algorithms by creating instances of various search classes and performing searches on sample graphs.

## Class Overview

### `Main`
- **Main Method:**
  - `main(String[] args)`: The main method where program execution begins.
    - Creates a weighted graph and fills it with edges and weights using the `fillWithWeights` method.
    - Performs Dijkstra's algorithm search using the `DijkstraSearch` class on the weighted graph from "Tokyo" to "Ichikawa" and prints the path.
    - Creates an unweighted graph and fills it with edges using the `fillWithoutWeights` method.
    - Performs depth-first search (DFS) using the `DepthFirstSearch` class on the unweighted graph from "Tokyo" to "Ichikawa" and prints the path.
    - Performs breadth-first search (BFS) using the `BreadthFirstSearch` class on the unweighted graph from "Tokyo" to "Ichikawa" and prints the path.

- **Helper Methods:**
  - `fillWithoutWeights(MyGraph<String> graph)`: Fills an unweighted graph with sample edges.
  - `fillWithWeights(WeightedGraph<String> graph)`: Fills a weighted graph with sample edges and weights.
  - `outputPath(Search<String> search, String key)`: Prints the path obtained from a search algorithm.
