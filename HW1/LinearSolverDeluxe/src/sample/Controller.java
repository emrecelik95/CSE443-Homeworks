package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


/**
 *
 * This class manages UI objects, receive some data and manages to solve Linear Systems.
 */

public class Controller {

    /**
     * UI object that takes unknown size of linear system as input.
     */
    @FXML private TextField unknownsizeText;

    /**
     * UI object that keeps method names as dropdown list.
     */
    @FXML private ChoiceBox<String> methodchoicebox;

    /**
     *  UI object that contains TextFields that is planned to take linear equations.
     */
    @FXML private VBox leSystemsVbox;

    /**
     *  UI text that contains solution of system.
     */
    @FXML private Text solutiontext;

    /**
     *  Split character that is used for splitting text data to array.
     */
    private final String splitCH = " ";


    /**
     *  Linear System Solver object that contains linear system
     *  and solving methods.
     */
    LinearSolver linearSolver;

    /**
     *  FXML method that is called by the system
     *  when application is started running.
     *  It makes some object creations and initializations.
     */
    @FXML
    private void initialize() {
        linearSolver = new LinearSolver();

        methodchoicebox.getItems().add("Gaussian Elimination");
        methodchoicebox.getItems().add("Matrix Inversion");

        methodchoicebox.setValue("Matrix Inversion");

        unknownsizeText.setText("3");
        RefreshLinearTextfields();


        unknownsizeText.textProperty().addListener(observable -> OnUnknownSizeChanged());

        ObservableList<Node> children = leSystemsVbox.getChildren();

        ((TextField)children.get(0)).setText("10 -1 0 9");
        ((TextField)children.get(1)).setText("-1 10 -2 7");
        ((TextField)children.get(2)).setText("0 -2 10 6");

    }


    /**
     * When clicked solve button, this method is invoked.
     * It takes UI data and manages linearsolver object
     * to solve the system. And then prints the result
     * or error to the UI text;
     *
     * @param event
     * parameter that is needed to interact UI objects
     */
    public void OnPressedSolve(ActionEvent event){
        try {
            linearSolver.setLeSystemMatrixLeft(GetLeftMatrixFromTextfields(splitCH));
            linearSolver.setLeSystemMatrixRight(GetRightMatrixFromTextfields(splitCH));
            ILinearSolutionMethod method = GetSolutionMethodFromChoiceBox();
            if(method != null)
                linearSolver.setSolutionMethod(method);

            double[] solution = linearSolver.SolveLinearSystem();
            if(solution != null)
                PrintSolutionToText(solution);
            else
                solutiontext.setText("The system has no solution!");

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * It prints the solution to text as desired format.
     * @param solution
     */
    private void PrintSolutionToText(double[] solution){
        String result = "";

        for(int i = 0; i < solution.length; i++)
            result += "x" + i + ": " + solution[i] + "\n";

        solutiontext.setText(result);
    }

    /**
     * Gets left matrix from text fields and then returns it.
     *
     * @param splitCH
     * Split character to split row into double array.
     * @return
     * @throws Exception
     * Exception occurs when data format is not proper.
     */
    private double[][] GetLeftMatrixFromTextfields(String splitCH)throws Exception {
        int count = GetUnknownSizeFromText();

        ObservableList<Node> children = leSystemsVbox.getChildren();

        double[][] matrix = new double[count][count];
        for (int i = 0; i < count; i++) {
            TextField textEqu = (TextField)children.get(i);

            String[] equCoeffs = textEqu.getText().split(splitCH);

            for(int j = 0; j < count; j++) {
                double coef;
                try {
                    coef = Double.parseDouble(equCoeffs[j]);
                }catch (Exception e){
                    solutiontext.setText("Number format is not right!");
                    throw new Exception("Number format is not right!");
                }

                matrix[i][j] = coef;
            }
        }

        return matrix;
    }


    /**
     * Gets right matrix from text fields and the returns it.
     *
     * @param splitCH
     * Split character to split row into double array.
     * @return
     * @throws Exception
     * Exception occurs when data format is not proper.
     */
    private double[] GetRightMatrixFromTextfields(String splitCH)throws Exception {
        int count = GetUnknownSizeFromText();

        ObservableList<Node> children = leSystemsVbox.getChildren();

        double[] matrix = new double[count];
        for (int i = 0; i < count ; i++) {
            TextField textEqu = (TextField)children.get(i);
            String[] equCoeffs = textEqu.getText().split(splitCH);

            double coef;
            try {
                coef = Double.parseDouble(equCoeffs[count]);
            }catch (Exception e) {
                throw new Exception("Number format is not right!");
            }

            matrix[i] = coef;
        }

        return matrix;
    }

    /**
     *  It is invoked when unknown size text is changed.
     *  It calls a function that generates linear system text fields all over.
     */
    public void OnUnknownSizeChanged(){
        RefreshLinearTextfields();
    }

    /**
     * Gets the unknown size as integer from text.
     * @return
     */
    private int GetUnknownSizeFromText(){
        int count = 0;
        try {
            count = Integer.parseInt(unknownsizeText.getText());
        }catch (Exception e){ }

        return count;
    }

    /**
     *  Clears all the text fields and generates new textfields
     *  using unknownSize.
     */
    public void RefreshLinearTextfields(){
        leSystemsVbox.getChildren().clear();

        int count = GetUnknownSizeFromText();
        for(int i = 0; i < count; i++)
            leSystemsVbox.getChildren().add(new TextField());

    }

    /**
     * Gets method from choice box and returns ILinearSolverMethod method object.
     * @return
     */
    private ILinearSolutionMethod GetSolutionMethodFromChoiceBox(){
        if(methodchoicebox.getValue().equals("Gaussian Elimination"))
            return new GaussianElimination();
        else if(methodchoicebox.getValue().equals("Matrix Inversion"))
            return new MatrixInversion();
        else
            return null;
    }

}
