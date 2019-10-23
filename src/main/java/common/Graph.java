package common;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<GraphNode> nodes;

    Graph() {
        nodes = new ArrayList<>();
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }
}
