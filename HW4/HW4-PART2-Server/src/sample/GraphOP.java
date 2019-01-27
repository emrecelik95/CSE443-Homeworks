package sample;

import javafx.util.Pair;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *  Remote Object Implementation
 */
public class GraphOP implements IGraphOP {

    /**
     *  credit amount
     */
    private int amount = 20;

    /**
     * getter
     * @return
     * amount
     */
    synchronized public int getAmount(){
        return amount;
    }

    /**
     * Minimum Spanning Tree Service
     * @param g
     * graph
     * @param credit
     * credit of client
     * @return
     * credit left and service result
     * @throws RemoteException
     * exceptipn
     */
    @Override
    public synchronized Pair<Integer,Graph> getMST(IGraph g, int credit) throws RemoteException {
        if(credit < amount){
            return null;
        }
        double sTime = System.nanoTime();

        String clientID;
        try {
            clientID = RemoteServer.getClientHost();
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException();
        }


        System.out.println("Client Connected : " + clientID);
        Controller.instance.logTxt.appendText("Client Connected : " + clientID + "\n");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date) + " - Minimum Spanning Tree Method is working... - ID : " + clientID);
        Controller.instance.logTxt.appendText(formatter.format(date) + " - Minimum Spanning Tree Method is working... - ID : " + clientID +"\n");


        Map<Vertex, Set<Edge>> map = g.getAdjList();
        Set<Edge> edges = g.getEdges();
        Set<Vertex> vs = map.keySet();
        List<Edge> sorted = SortEdges(edges);
        Graph mst = GetMST(sorted);

        double eTime = System.nanoTime();
        System.out.println("Completed in " + (eTime - sTime) + " ns - ID : " + clientID);
        Controller.instance.logTxt.appendText("Completed in " + (eTime - sTime) + " ns - ID : " + clientID + "\n");

        return new Pair<>(credit - amount,mst);
    }

    /**
     * Incidence Matrix Service
     * @param g
     * graph
     * @param credit
     * credit of client
     * @return
     * credit left and service result
     * @throws RemoteException
     * exception
     */
    @Override
    public synchronized Pair<Integer, Map<Vertex, Set<Pair<Edge, Integer>>>> getIncMatrix(IGraph g, int credit) throws RemoteException{
        if(credit < amount){
            return null;
        }
        double sTime = System.nanoTime();

        String clientID;
        try {
            clientID = RemoteServer.getClientHost();
        } catch (Exception e){
            e.printStackTrace();
            throw new RemoteException();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        System.out.println("Client Connected : " + clientID);
        Controller.instance.logTxt.appendText("Client Connected : " + clientID + "\n");

        System.out.println(formatter.format(date) + " - Incidence Matrix Method is working... - ID : " + clientID);
        Controller.instance.logTxt.appendText(formatter.format(date) + " - Incidence Matrix Method is working... - ID : " + clientID + "\n");

        Map<Vertex, Set<Edge>> map = g.getAdjList();
        Set<Vertex> vertices = map.keySet();
        Set<Edge> edges = g.getEdges();

        Map<Vertex, Set<Pair<Edge, Integer>>> res = new HashMap<>();

        for(Vertex v : vertices)
        {
            res.put(v, new LinkedHashSet<>());
            for(Edge e : edges) {
                int x = 0;
                if(e.getV1().equals(v))
                    x = 1;
                else if(e.getV2().equals(v))
                    x = -1;

                res.get(v).add(new Pair<>(e, x));
            }
        }

        double eTime = System.nanoTime();
        System.out.println("Completed in " + (eTime - sTime) + " ns - ID : " + clientID);
        Controller.instance.logTxt.appendText("Completed in " + (eTime - sTime) + " ns - ID : " + clientID + "\n");

        return new Pair<>(credit - amount, res);
    }

    /**
     * sorts edges using weights
     * @param edges
     * edges
     * @return
     * list of sorted edges
     */
    public List<Edge> SortEdges(Set<Edge> edges){
        List<Edge> res = new ArrayList<>();
        for(Edge tmp : edges)
            res.add((Edge) tmp.clone());

        for(int i = 0; i < res.size() - 1; i++) {
            Edge e1 = res.get(i);
            for(int j = i + 1; j < res.size(); j++) {
                Edge e2 = res.get(j);
                if (e1.getWeight() > e2.getWeight()) {
                    Edge tmp = (Edge) e2.clone();
                    e2 = (Edge) e1.clone();
                    e1 = tmp;
                }
                res.set(i, e1);
                res.set(j, e2);
            }

        }
        return res;
    }

    /**
     * get minimum spanning tree
     * @param edges
     * edges
     * @return
     * graph
     */
    public  Graph GetMST(List<Edge> edges){
        Graph g = new Graph(true);

        for(Edge e : edges)
            g.insertEdge(e);

        int vSize = g.getAdjList().keySet().size();
        g = new Graph(true);
        int eSize = 0;
        for(int i = 0; i < edges.size() && eSize < vSize - 1 ; i++) {
            g.insertEdge(edges.get(i));
            eSize++;
            if(IsGraphCyclic(g)) {
                g.removeEdge(edges.get(i));

                eSize--;
            }
        }
        return g;
    }

    /**
     *   tells if graph is cyclic or not (uses bfs)
      */
    public boolean IsGraphCyclic(Graph g){
        Map<Vertex, Integer> counts = new HashMap<>();
        Queue<Vertex> q = new LinkedList<>();
        // traversed vertex count
        int trVertexCount = 0;

        Map<Vertex, Set<Edge>> adjList = g.getAdjList();
        Set<Vertex> vertices = adjList.keySet();

        // initialize counts of all vertices with 1
        for(Vertex v : vertices)
            counts.put(v, 0);

        // count the adjacencies of vertex
        for(Vertex v : vertices) {
            for (Edge e : adjList.get(v)) {
                int val = counts.get(e.getV2());
                counts.put(e.getV2(), val + 1);
            }
        }

        // initialize queue for bfs(only vertices that has 0 count
        for(Vertex v : vertices){
            if(counts.get(v) == 0) {
                ((LinkedList<Vertex>) q).push(v);
            }
        }

        // traverse untill the queue to be empty
        while(!q.isEmpty()){
            trVertexCount++;
            Vertex v = ((LinkedList<Vertex>) q).pop();
            for(Edge e : adjList.get(v)) {
                int val = counts.get(e.getV2());
                counts.put(e.getV2(), val - 1);
                // if count of adj is 0, push it to the queue
                if (val - 1 == 0)
                    ((LinkedList<Vertex>) q).push(e.getV2());
            }
        }

        return trVertexCount != vertices.size();
    }

}
