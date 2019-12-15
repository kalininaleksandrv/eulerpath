package main.java.com.github.kalininaleksandrv.eulerpath;

import java.util.Arrays;
import java.util.Objects;

public class Edge {

    public Edge(Integer vertexa, Integer vertexb) {
        this.vertexa = vertexa;
        this.vertexb = vertexb;
        this.edgearray[0] = vertexa;
        this.edgearray[1] = vertexb;
        this.edgearrayrev[0] = vertexb;
        this.edgearrayrev[1] = vertexa;
    }

    private Integer vertexa;
    private Integer vertexb;
    Integer[] edgearray = new Integer[2];
    Integer[] edgearrayrev = new Integer[2];

    boolean isSymmetrical;
    boolean isVisited = false;

    private Integer[] getEdge(){
        return edgearray;
    }

    private Integer[] getEdgeRev(){
        return edgearrayrev;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "vertexa=" + vertexa +
                ", vertexb=" + vertexb +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(vertexa, edge.vertexa) &&
                Objects.equals(vertexb, edge.vertexb) &&
                Arrays.equals(edgearray, edge.edgearray) &&
                Arrays.equals(edgearrayrev, edge.edgearrayrev);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(vertexa, vertexb);
        result = 31 * result + Arrays.hashCode(edgearray);
        result = 31 * result + Arrays.hashCode(edgearrayrev);
        return result;
    }

    public void checkForSymetrical() {
        isSymmetrical = vertexa.equals(vertexb);
    }

    public boolean isSymmetrical() {
        return isSymmetrical;
    }

    public Integer getVertexa() {
        return vertexa;
    }

    public Integer getVertexb() {
        return vertexb;
    }

    public boolean isVisited() {
        return isVisited;
    }
}
