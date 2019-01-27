package sample;

import java.io.Serializable;
import java.util.Objects;

/**
 *  Simple Vertex Class
 */
public class Vertex implements Serializable {

    /**
     *  general item
     */
    private Object v;

    /**
     *  Constructor
     * @param v
     * vertex data
     */
    public Vertex(Object v){
        this.v = v;
    }

    /**
     * overrided equals
     * @param o
     * other vertex
     * @return
     * equal or not
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Vertex))
            return false;

        if(o == this)
            return true;

        return this.v.equals(((Vertex) o).v);
    }

    /**
     * overrided toString
     * @return
     * toString of v object
     */
    @Override
    public String toString() {
        return v.toString();
    }

    /**
     * getter
     * @return
     * vertex
     */
    public Object getV() {
        return v;
    }

    /**
     * setter
     * @param v
     * vertex
     */
    public void setV(Object v) {
        this.v = v;
    }

    /**
     * simple hashCode
     * @return
     * integer hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}