package sample;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 *  Graph Interface
 */
public interface IGraph extends Serializable {

    /**
     * insertes an edge
     * @param source
     * source vertex
     * @param dest
     * dest vertex
     * @param weight
     * weight
     * @return
     * inserted or not
     */
    public boolean insertEdge(Object source, Object dest, float weight);

    /**
     * remove an edge
     * @param source
     * source vertex
     * @param dest
     * dest vertex
     * @param weight
     * weight
     * @return
     * removed or not
     */
    public boolean removeEdge(Object source, Object dest, float weight);

    /**
     * add a vertex
     * @param v
     * vertex
     * @return
     * added or not
     */
    public boolean addVertex(Object v);

    /**
     * remove a vertex
     * @param v
     * vertex
     * @return
     * removed or not
     */
    public boolean removeVertex(Object v);

    /**
     * getter
     * @return
     * adjacency list
     */
    public Map<Vertex, Set<Edge>> getAdjList();

    /**
     * getter
     * @return
     * edges
     */
    public Set<Edge> getEdges();

    /**
     * getter
     * @return
     * vertices
     */
    public Set<Vertex> getVertices();
}
