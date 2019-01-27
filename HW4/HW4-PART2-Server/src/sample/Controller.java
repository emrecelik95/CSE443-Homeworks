package sample;

import javafx.fxml.FXML;

import javafx.scene.control.TextArea;

/**
 *  Controller of GUI
 */
public class Controller {

    /**
     * singleton
     */
    public static Controller instance;

    /**
     *  Log TextArea
     */
    @FXML
    public TextArea logTxt;

    /**
     * FXML initialize method
     */
    @FXML
    void initialize() {
        instance = this;
    }

}
