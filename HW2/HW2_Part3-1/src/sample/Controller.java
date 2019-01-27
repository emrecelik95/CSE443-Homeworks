package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

/**
 *  UI Controller Class
 */
public class Controller {

    /**
     *  choicebox that contains the choice of plane model
     */
    @FXML
    ChoiceBox<String> planeBox;

    /**
     *  the text to print the result
     */
    @FXML
    Text resultText;

    /**
     *  PlaneFactory to create planes
     */
    PlaneFactory planeFactory = new PlaneFactory();

    /**
     *  FXML initialization method
     *  initializes some choice box items
     *  so that user can choose
     */
    public void initialize(){

        planeBox.getItems().add("TPX 100");
        planeBox.getItems().add("TPX 200");
        planeBox.getItems().add("TPX 300");

        planeBox.setValue("TPX 100");

    }

    /**
     *  This method is called whenever
     *  order button is pressed.
     *  Reads output stream and prints it to
     *  result text in UI. This is used because
     *  plane simulation uses out stream to
     *  log events.
     */
    public void OnPressedOrder(){

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        planeFactory.createPlane(planeBox.getValue());

        resultText.setText(out.toString());

    }


}
