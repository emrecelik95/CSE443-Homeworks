package sample;


import java.util.*;

/**
 *  Graph Implementation
 */
public class Graph implements IGraph {

    /**
     *  all vertices
     */
    private Set<Vertex> vertices;
    /**
     *  all edges
     */
    private Set<Edge> edges;
    /**
     *  adjacency list
     */
    private Map<Vertex, Set<Edge>> adj;

    /**
     *  graph is directed or not
     */
    private boolean directed = true;

    /** Constructor
     *
     * @param directed
     * directed or not
     */
    public Graph(boolean directed){
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adj = new HashMap<>();

        this.directed = directed;
    }

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
    public boolean insertEdge(Object source, Object dest, float weight){
        return insertEdge(new Edge(new Vertex(source), new Vertex(dest), weight));
    }

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
    public boolean removeEdge(Object source, Object dest, float weight){
        return removeEdge(new Edge(new Vertex(source), new Vertex(dest), weight));
    }

    /**
     * add a vertex
     * @param v
     * vertex
     * @return
     * added or not
     */
    public boolean addVertex(Object v){
        return addVertex(v);
    }

    /**
     * remove a vertex
     * @param v
     * vertex
     * @return
     * removed or not
     */
    public boolean removeVertex(Object v){
        return removeVertex(v);
    }

    /**
     * getter
     * @return
     * adjacency list
     */
    public Map<Vertex, Set<Edge>> getAdjList(){
        return adj;
    }

    /**
     * getter
     * @return
     * edges
     */
    public Set<Edge> getEdges(){
        return edges;
    }

    /**
     * getter
     * @return
     * vertices
     */
    public Set<Vertex> getVertices(){
        return vertices;
    }

    /**
     * add a vertex
     * @param v
     * vertex
     * @return
     * added or not
     */
    private boolean addVertex(Vertex v){
        return vertices.add(v);
    }

    /**
     * remove a vertex
     * @param v
     * vertex
     * @return
     * removed or not
     */
    private boolean removeVertex(Vertex v) {
        if(!vertices.remove(v))
            return false;

        return vertices.remove(v);
    }

    /**
     * insert an edge
     * @param edge
     * edge
     * @return
     * inserted or not
     */
    public boolean insertEdge(Edge edge){
        if(!edges.add(edge))
            return false;

        adj.putIfAbsent(edge.getV1(), new HashSet<>());
        adj.putIfAbsent(edge.getV2(), new HashSet<>());

        adj.get(edge.getV1()).add(edge);

        vertices.add(edge.getV1());
        vertices.add(edge.getV2());

        if(!directed) {
            adj.get(edge.getV2()).add(edge);
        }

        return true;
    }

    /**
     * remove an edge
     * @param edge
     * edge
     * @return
     * removed or not
     */
    public boolean removeEdge(Edge edge){
        if(!edges.remove(edge))
            return false;

        Set<Edge> list = adj.get(edge.getV1());
        if(list != null)
            list.remove(edge);

        return true;
    }

}

