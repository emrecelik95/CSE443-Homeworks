package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

/**
 *  Controller class for UI.
 */
public class Controller {

    /**
     *  plane choices
     */
    @FXML
    ChoiceBox<String> planeBox;

    /**
     * market choices
     */
    @FXML
    ChoiceBox<String> marketBox;

    /**
     *  text to print the results
     */
    @FXML
    Text resultText;

    /**
     *  planestore to create planes
     */
    PlaneStore planeStore;

    /**
     *  FXML initialization method
     *  initializes market and plane choices
     */
    public void initialize(){

        marketBox.getItems().add("Domestic");
        marketBox.getItems().add("Eurasia");
        marketBox.getItems().add("Other");
        marketBox.setValue("Domestic");

        planeBox.getItems().add("TPX 100");
        planeBox.getItems().add("TPX 200");
        planeBox.getItems().add("TPX 300");

        planeBox.setValue("TPX 100");

    }

    /**
     *  invoked when user pressed order button
     */
    public void OnPressedOrder(){

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        planeStore = GetPlaneStoreFromMarketBox();
        planeStore.orderPlane(planeBox.getValue());

        resultText.setText(out.toString());

    }

    /**
     * gets a new plane using market choice box value
     * @return
     * PlaneStore object
     */
    private PlaneStore GetPlaneStoreFromMarketBox(){
        if(marketBox.getValue().equals("Domestic"))
            return new DomesticPlaneStore();
        else if(marketBox.getValue().equals("Eurasia"))
            return new EurasiaPlaneStore();
        else if(marketBox.getValue().equals("Other"))
            return new OtherPlaneStore();
        else return null;
    }

}
