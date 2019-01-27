package sample;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 *  RMI Server
 */
public class Server extends GraphOP {

    /**
     * RMI registry
     */
    private Registry registry;
    /**
     *  rmi object
     */
    GraphOP obj;

    /**
     *  Starts rmi server
     */
    public void StartServer(){
        try{
            obj = new GraphOP();

            registry = LocateRegistry.createRegistry(8888);

            IGraphOP stub = (IGraphOP) UnicastRemoteObject.exportObject(obj, 0);

            registry.bind("GraphServices", stub);

            System.err.println("Server ready");
            Controller.instance.logTxt.appendText("Server Ready\n");

        } catch (Exception e){
            System.err.println("Server exception : " + e.toString());
            e.printStackTrace();
        }
    }

    /**
     *  stops rmi server
     */
    public void StopServer(){
        try {
            registry.unbind("GraphServices");
            UnicastRemoteObject.unexportObject(obj, true);
        } catch (Exception e)
        {
            System.out.println("Exception in server : " + e.toString());
            e.printStackTrace();
        }
    }

}
