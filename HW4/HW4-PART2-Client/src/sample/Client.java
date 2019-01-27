package sample;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {

    /**
     *  singleton
     */
    public static Client instance = new Client();

    /**
     *  rmi registry
     */
    private Registry registry;
    /**
     *
     *  Stub object.
     *  Other script uses this to make remote method invocation.
     */
    public IGraphOP stub;

    /**
     *  starts a connection to server
     * @throws RemoteException
     */
    public void StartClient() throws RemoteException {

        try {
            registry = LocateRegistry.getRegistry("localhost", 8888);
            stub = (IGraphOP) registry.lookup("GraphServices");

            System.out.println("Client Connected.");
            //Controller.instance.resText.setText("Client Connected.");
        }catch (Exception e){
            System.err.println("Client exception: " + e.toString());
            //Controller.instance.resText.setText("Cannot connect to server!\n" + e.toString());
            e.printStackTrace();
        }
    }

}
