package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Controller of GUI
 */
public class Controller {

    /**
     * graph
     */
    private Graph g;

    /**
     * edge size text field
     */
    @FXML
    private TextField edgeSizeText;

    /**
     *  result text area
     */
    @FXML
    public TextArea resText;

    /**
     *  vertical layout aligner
     */
    @FXML
    private VBox vbox;

    /**
     *  credit text field
     */
    @FXML
    private TextField creditText;

    /**
     * credit of client
     */
    private int credit = 100;

    /**
     *  anchor pane of set credit button
     */
    @FXML
    private AnchorPane buttonAnchor;

    /**
     * FX initialize method
     */
    @FXML
    private void initialize(){
        edgeSizeText.setText("3");
        edgeSizeText.textProperty().addListener(observable -> OnEdgeSizeChanged());
        RefreshTextfields();

        ObservableList children = vbox.getChildren();
        ((TextField)children.get(0)).setText("0,1,1");
        ((TextField)children.get(1)).setText("0,2,2");
        ((TextField)children.get(2)).setText("1,2,3");

        GetEdgesToGraphFromGUI();
        creditText.setText("100");
    }

    /**
     *
     *  Creates graph using text area edges
     */
    private void GetEdgesToGraphFromGUI(){
        List<Edge> edges = new LinkedList<>();
        ObservableList children = vbox.getChildren();
        g = new Graph(true);
        for(Object n : children) {
            String text = ((TextField) n).getText();
            String[] t = text.split(",");
            int w = Integer.parseInt(t[2]);

            Edge edge =  new Edge(new Vertex(t[0]), new Vertex(t[1]), w);
            g.insertEdge(edge);
        }
    }


    /**
     *  initializes credit
     */
    @FXML private void SetCredit(){
        creditText.editableProperty().setValue(false);
        credit = TextToInt(creditText.getText());


        buttonAnchor.getChildren().clear();
    }

    /**
     *  Gets Minimum Spaning Tree from Server
     */
    @FXML
    private void GetMST(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        GetEdgesToGraphFromGUI();
        SetCredit();
        resText.clear();
        try {
            Set<Edge> edges = g.getEdges();
            Pair p = Client.instance.stub.getMST(g, credit);
            if(p == null){
                System.out.println("Credit is not enough!");
                resText.setText("Credit is not enough!");
                return;
            }
            Graph mst = (Graph)p.getValue();
            credit = (int)p.getKey();
            creditText.setText(String.format("%d",credit));

            Set<Edge> mstEdges = mst.getEdges();

            System.out.println("Minimum Spanning Tree with Edges : ");

            float sum = 0;
            for (Edge edge : mstEdges) {
                System.out.println(edge);
                sum += edge.getWeight();
            }
            System.out.println("Minimum Spanning Tree Weight Sum : " + sum + "\n");

            resText.appendText(out.toString());
        } catch (Exception e){
            System.err.println("Client exception: " + e.toString());
            resText.clear();
            resText.appendText("Client exception: " + e.toString() +  "\n");

            e.printStackTrace();
        }
    }

    /**
     * Gets Incredence Matrix from Server
     */
    @FXML
    private void GetIncMatrix(){
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        GetEdgesToGraphFromGUI();
        SetCredit();
        Set<Edge> edges = g.getEdges();

        resText.clear();

        try {
            Pair p = Client.instance.stub.getIncMatrix(g, credit);
            if(p == null){
                System.out.println("Credit is not enough!");
                resText.setText("Credit is not enough!");
                return;
            }
            Map<Vertex, Set<Pair<Edge, Integer>>> mat = (Map<Vertex, Set<Pair<Edge, Integer>>>)p.getValue();
            credit = (int)p.getKey();
            creditText.setText(String.format("%d",credit));

            Set<Vertex> vertices = mat.keySet();

            //resText.appendText("Incidence Matrix : \n");
            System.out.print("V/E\t\t");
            //resText.appendText("V/E\t\t");
            for (Edge e : edges) {
                System.out.print(e.toEdgeFormat() + "\t\t");
                //resText.appendText(e.toEdgeFormat() + "\t\t");
            }
            System.out.println();
            //resText.appendText("\n");

            for (Vertex v : vertices) {
                System.out.print(String.format("%s", v + "\t\t"));
                //resText.appendText(String.format("%s", v + "\t\t"));

                Set<Pair<Edge, Integer>> cols = mat.get(v);
                for (Pair<Edge, Integer> e : cols) {
                    System.out.print(e.getValue() + "\t\t");
                    //resText.appendText(e.getValue() + "\t\t");
                }
                System.out.println();
                //resText.appendText("\n");
            }
            resText.appendText(out.toString());
        } catch (Exception e){
            System.err.println("Client exception: " + e.toString());
            resText.clear();
            resText.appendText("Client exception: " + e.toString() +  "\n");
        }
    }

    /**
     *  String to Integer
     * @param text
     * string
     * @return
     * integer
     */
    private int TextToInt(String text){
        int count = 0;
        try {
            count = Integer.parseInt(text);
        }catch (Exception e){ }

        return count;
    }

    /**
     *  invoked when edge size text is changed
     */
    public void OnEdgeSizeChanged(){
        RefreshTextfields();
    }

    /**
     *  refreshes text fields of edges
     */
    public void RefreshTextfields(){
        vbox.getChildren().clear();
        int count = TextToInt(edgeSizeText.getText());

        for(int i = 0; i < count; i++)
            vbox.getChildren().add(new TextField());

    }


}
