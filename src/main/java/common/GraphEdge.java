package common;

public class GraphEdge<T> {

    protected T src;

    protected T dest;

    GraphEdge(T src, T dest) {
        this.src = src;
        this.dest = dest;
    }

    protected T getSrc() {
        return src;
    }

    protected T getDest() {
        return dest;
    }
}
