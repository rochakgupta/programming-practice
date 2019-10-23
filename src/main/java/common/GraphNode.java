package common;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    private Integer data;

    private List<GraphEdge> neighbors;

    private GraphNode(Integer data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public Integer getData() {
        return data;
    }

    public List<GraphEdge> getNeighbors() {
        return neighbors;
    }

    private void addNeighbor(GraphEdge edge) {
        neighbors.add(edge);
    }
}
