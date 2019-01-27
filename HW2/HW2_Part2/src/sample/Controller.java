package sample;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;


/**
 *  UI Controller
 */
public class Controller {

    /**
     *  Suit choice box
     */
    @FXML
    ComboBox<String> suitComboBox;
    /**
     * the text to print the result
     */
    @FXML
    Text resultText;
    /**
     *  Suit Accessory
     */
    @FXML
    CheckBox flamethrowerBox;
    /**
     * accessory count to be added
     */
    @FXML
    ComboBox<Integer> flameCount;

    /**
     *  Suit Accessory
     */
    @FXML
    CheckBox autoRifleBox;
    /**
     * accessory count to be added
     */
    @FXML
    ComboBox<Integer> rifleCount;
    /**
     *  Suit Accessory
     */
    @FXML
    CheckBox rocketLauncherBox;
    /**
     * accessory count to be added
     */
    @FXML
    ComboBox<Integer> rocketCount;
    /**
     *  Suit Accessory
     */
    @FXML
    CheckBox laserBox;
    /**
     * accessory count to be added
     */
    @FXML
    ComboBox<Integer> laserCount;

    /**
     *  UI initialize method
     *  Declares UıI items so that
     *  user can recognize and choose
     */
    public void initialize(){

        suitComboBox.getItems().add("Dec");
        suitComboBox.getItems().add("Ora");
        suitComboBox.getItems().add("Tor");

        suitComboBox.setValue("Dec");

        addCountChoices(flameCount, 11);
        flameCount.setValue(1);
        addCountChoices(rifleCount, 11);
        rifleCount.setValue(1);
        addCountChoices(rocketCount, 11);
        rocketCount.setValue(1);
        addCountChoices(laserCount, 11);
        laserCount.setValue(1);
    }

    private void addCountChoices(ComboBox<Integer> comboBox, int size){

        for(int i = 1; i < size; i++)
            comboBox.getItems().add(i);
    }

    /**
     *  called when get button pressed
     */
    public void OnPressedGet(){

        ISuit suit = GetNewSuitFromComboBox();
        suit = DecorateSuitUsingCheckBoxes(suit);

        resultText.setText("Total Price : " + suit.getPrice() + "\n" + "Total Weight : " + suit.getWeigth());
    }

    /**
     *  Decorates suit using check box values
     * @param suit
     * Suit to be decorated
     * @return
     * decorated suit
     */
    public ISuit DecorateSuitUsingCheckBoxes(ISuit suit){

        if(flamethrowerBox.isSelected())
            for(int i = 0; i < flameCount.getValue(); i++)
                suit = new Flamethrower(suit);


        if(autoRifleBox.isSelected())
            for(int i = 0; i < rifleCount.getValue(); i++)
                suit = new AutoRifle(suit);

        if(rocketLauncherBox.isSelected())
            for(int i = 0; i < rocketCount.getValue(); i++)
                suit = new RocketLauncher(suit);

        if(laserBox.isSelected())
            for(int i = 0; i < laserCount.getValue(); i++)
                suit = new Laser(suit);

        return suit;

    }

    /**
     * Gets new suit from choices
     * @return
     * suit object
     */
    public ISuit GetNewSuitFromComboBox(){
        if(suitComboBox.getValue().equals("Dec"))
            return new DecSuit();
        else if(suitComboBox.getValue().equals("Ora"))
            return new OraSuit();
        else if(suitComboBox.getValue().equals("Tor"))
            return new TorSuit();
        else return null;
    }

}
