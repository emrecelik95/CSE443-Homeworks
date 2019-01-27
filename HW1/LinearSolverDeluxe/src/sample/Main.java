package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  Main class of application.
 */
public class Main extends Application {

    /**
     *  Linear Solver FXML File Name.
     */
    private final String fxmlFile = "linearsolver.fxml";


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        primaryStage.setTitle("Linear Solver Deluxe");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }
}
