package common;

public class GraphWeightedEdge<W> extends GraphEdge {

    private W weight;

    GraphWeightedEdge(GraphNode src, GraphNode dest, W weight) {
        super(src, dest);
        this.weight = weight;
    }

    public W getWeight() {
        return weight;
    }
}
