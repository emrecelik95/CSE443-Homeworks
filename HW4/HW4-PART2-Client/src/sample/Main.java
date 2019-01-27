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

    private Client client;

    /**
     * fx start method
     * @param primaryStage
     * stage
     * @throws Exception
     * exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("RMI Client");
        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.show();

        /**
         *  Starts connection to the server.
         */
        Client.instance.StartClient();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
