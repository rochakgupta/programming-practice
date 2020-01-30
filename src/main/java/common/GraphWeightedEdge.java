package common;

public class GraphWeightedEdge<T, W> extends GraphEdge<T> {

    private W weight;

    GraphWeightedEdge(T src, T dest, W weight) {
        super(src, dest);
        this.weight = weight;
    }

    public W getWeight() {
        return weight;
    }
}
