package sample;

import javafx.util.Pair;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Set;

/**
 *  Remote Object Interface
 */
public interface IGraphOP extends Remote {

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
    public Pair<Integer, Graph> getMST(IGraph g, int credit) throws RemoteException;

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
    public Pair<Integer, Map<Vertex, Set<Pair<Edge, Integer>>>> getIncMatrix(IGraph g, int credit) throws RemoteException;

}
