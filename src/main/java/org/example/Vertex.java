package org.example;

import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex() {
    }

    public Vertex(V data, Map<Vertex<V>, Double> adjacentVertices) {
        this.data = data;
        this.adjacentVertices = adjacentVertices;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    // Overriding equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    // Overriding hashCode method
    @Override
    public int hashCode() {
        int result = 17; // Start with a non-zero constant
        result = 31 * result + (data == null ? 0 : data.hashCode());
        return result;
    }

    // Overriding toString method for better readability
    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                '}';
    }


}
