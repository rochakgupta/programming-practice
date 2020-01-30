package common;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

    private T data;

    private List<GraphEdge<T>> neighbors;

    private GraphNode(T data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<GraphEdge<T>> getNeighbors() {
        return neighbors;
    }

    private void addNeighbor(GraphEdge<T> edge) {
        neighbors.add(edge);
    }
}
