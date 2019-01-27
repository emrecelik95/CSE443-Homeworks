package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *  Abstract class for transform classes
 */
public abstract class TransformNumbers {

    /**
     *  input file name
     */
    protected String inputFile;
    /**
     *  output file name
     */
    protected String outputFile;
    /**
     *  number count
     */
    protected int N;


    /**
     * Constructor
     * @param inputFile
     * input file name
     * @param outputFile
     * output file name
     * @param numberCount
     * number count
     */
    public TransformNumbers(String inputFile, String outputFile, int numberCount){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.N = numberCount;
    }

    /**
     *  Transform method calls template methods
     */
    public void Transform(){
        System.out.println("Input Data : ");
        ReadNumbersFromFile(inputFile, N);
        TransformNumbers();
        System.out.println("Output Data : ");
        WriteOutputsToFile(outputFile, N);
        RespondUser();
    }

    /**
     * Reads numbers form file
     * @param filename
     * file name
     * @param N
     * number count
     */
    protected abstract void ReadNumbersFromFile(String filename, int N);

    /**
     *  Tranforms Numbers
     */
    protected abstract void TransformNumbers();

    /**
     * Writes output to file
     * @param outputFile
     * output file name
     * @param N
     * number count
     */
    protected abstract void WriteOutputsToFile(String outputFile, int N);

    protected abstract void RespondUser();

    /**
     * Writes string to output file
     * @param out
     * output data
     */
    protected void WriteToFile(String out){
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(out);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
