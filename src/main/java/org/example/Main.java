package org.example;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Tokyo");
        outputPath(djk, "Ichikawa");

        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Tokyo");
        outputPath(dfs, "Ichikawa");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "Tokyo");
        outputPath(bfs, "Ichikawa");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge("Tokyo", "Osaka");
        graph.addEdge("Yokohama", "Nagoya");
        graph.addEdge("Nagoya", "Kyoto");
        graph.addEdge("Tokyo", "Yokohama");
        graph.addEdge("Yokohama", "Osaka");
        graph.addEdge("Osaka", "Sapporo");
        graph.addEdge("Yokohama", "Ichikawa");
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Tokyo", "Osaka", 2.1);
        graph.addEdge("Yokohama", "Nagoya", 7.8);
        graph.addEdge("Nagoya", "Kyoto", 7.1);
        graph.addEdge("Tokyo", "Yokohama", 7.2);
        graph.addEdge("Yokohama", "Osaka", 3.9);
        graph.addEdge("Osaka", "Sapporo", 3.5);
        graph.addEdge("Yokohama", "Ichikawa", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}
