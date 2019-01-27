package sample;

import java.io.Serializable;
import java.util.Objects;

/**
 *  Simple Edge Class
 */
public class Edge implements Serializable {

    /**
     *  source
     */
    private Vertex v1;
    /**
     *  destination
     */
    private Vertex v2;

    /**
     *  weight
     */
    private float weight = 1;

    /**
     * Constructor
     * @param v1
     * source
     * @param v2
     * destination
     * @param weight
     * weight
     */
    public Edge(Vertex v1, Vertex v2, float weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    /**
     * hashCode
     * @return
     * integer hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(v1,v2,weight);
    }

    /**
     * overrided toString
     * @return
     * edge as string
     */
    @Override
    public String toString() {
        return v1.toString() + " , " + v2.toString() + " : " + weight;
    }

    /**
     * Edge format with arrow
     * @return
     * s -> d
     */
    public String toEdgeFormat(){
        return v1.toString() + "->" + v2.toString();
    }

    /***
     * overrided clone
     * @return
     * clone of this object
     */
    @Override
    protected Object clone()  {
        return new Edge(v1, v2, weight);
    }

    /**
     * overrided equals
     * @param o
     * other
     * @return
     * equal or not
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Edge))
            return false;

        if(o == this)
            return true;

        Edge e = (Edge) o;
        return this.v1.equals(e.v1) && this.v2.equals(e.v2)
                && this.weight == e.weight;
    }

    /**
     * getter
     * @return
     * source vertex
     */
    public Vertex getV1() {
        return v1;
    }

    /**
     * setter
     * @param v1
     * source vertex
     */
    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    /**
     * getter
     * @return
     * dest
     */
    public Vertex getV2() {
        return v2;
    }

    /**
     * setter
     * @param v2
     * dest
     */
    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    /**
     * getter
     * @return
     *  weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * setter
     * @param weight
     * weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

}
