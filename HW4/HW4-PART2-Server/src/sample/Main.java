package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  Main Class of Application
 */
public class Main extends Application {

    /**
     *  RMI Server Object
     */
    private Server server;

    /**
     * FX start
     * @param primaryStage
     * fx stuff
     * @throws Exception
     * exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("RMI Server");
        primaryStage.setScene(new Scene(root, 1024, 500));
        primaryStage.show();

        server = new Server();
        server.StartServer();
    }

    /**
     * quiting app
     */
    @Override
    public void stop(){
        server.StopServer();
    }

    /**
     * main method
     * @param args
     * argumants
     */
    public static void main(String[] args) {
        launch(args);
    }
}
