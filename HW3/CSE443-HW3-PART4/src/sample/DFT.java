package sample;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 *  Discrete Fourier Transform
 */
public class DFT extends TransformNumbers {

    /**
     *  real number parts of inputs
     */
    double[] inpReals;
    /**
     *  imaginer parts of inputs
     */
    double[] inpImgs;

    /**
     *  real number parts of outputs
     */
    double[] outReals;
    /**
     *  imaginer parts of outputs
     */
    double[] outImgs;

    /**
     *  user choice for printing elapsed time
     */
    protected boolean userChoice;

    /**
     *  start time
     */
    long start;

    /**
     * Constructor
     * @param inputFile
     * input file name
     * @param outputFile
     * output file name
     * @param N
     * number count
     */
    public DFT(String inputFile, String outputFile, int N){
        super(inputFile, outputFile, N);
        inpReals = new double[N];
        inpImgs = new double[N];
        outReals = new double[N];
        outImgs = new double[N];
    }

    public DFT(String inputFile, String outputFile, int N, boolean userChoice){

        super(inputFile, outputFile, N);
        inpReals = new double[N];
        inpImgs = new double[N];
        outReals = new double[N];
        outImgs = new double[N];
        this.userChoice = userChoice;

        start = System.currentTimeMillis();
    }

    /**
     * Reads numbers from file as real numbers and prints them.
     * Each line has a complex number(real part is before comma, imagine part is after comma)
     * @param filename
     * file name
     * @param N
     * number count
     */
    @Override
    protected void ReadNumbersFromFile(String filename, int N) {
        start = System.currentTimeMillis();

        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(filename);
            reader = new BufferedReader(fileReader);
            String line;

            int i = 0;

            while((line = reader.readLine()) != null)
            {
                String[] x = line.split(",");
                inpReals[i] = Double.parseDouble(x[0]);
                inpImgs[i] = Double.parseDouble(x[1]);

                System.out.println(inpReals[i] + " , " + inpImgs[i]);
                ++i;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {

            try {

                if (reader != null)
                    reader.close();

                if (fileReader != null)
                    fileReader.close();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }
    }

    /**
     *  Transforms numbers using DFT formula
     *  and stores out in outs variable
     */
    @Override
    protected void TransformNumbers() {

        for(int k = 0; k < N; k++){
            double real = 0;
            double img = 0;
            for(int j = 0; j < N; j++){
                double a = 2 * Math.PI * j * k / N;
                real += inpReals[j] * Math.cos(a) + inpImgs[j] * Math.sin(a);
                img += -inpReals[j] * Math.sin(a) + inpImgs[j] * Math.cos(a);
            }
            outReals[k] = real;
            outImgs[k] = img;
        }
    }

    /**
     * Writes output to file
     * @param outputFile
     * output file name
     * @param N
     * number count
     */
    @Override
    protected void WriteOutputsToFile(String outputFile, int N) {
        String out = "";
        for(int i = 0; i < N; i++)
            out += "x" + i + " : " + (float)outReals[i] + " + " + (float)outImgs[i] + "i\n";

        System.out.println(out);
        WriteToFile(out);
    }

    /**
     *  Print elasped time if user wants
     */
    @Override
    protected void RespondUser() {
        if(userChoice){
            System.out.println("Elapsed Time In DFT : " + (System.currentTimeMillis() - start) + "ms \n ");
        }
    }
}
