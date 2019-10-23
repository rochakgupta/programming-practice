package common;

public class GraphEdge {

    protected GraphNode src;

    protected GraphNode dest;

    GraphEdge(GraphNode src, GraphNode dest) {
        this.src = src;
        this.dest = dest;
    }

    protected GraphNode getSrc() {
        return src;
    }

    protected GraphNode getDest() {
        return dest;
    }
}
