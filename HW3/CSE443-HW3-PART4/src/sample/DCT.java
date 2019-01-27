package sample;

import java.io.BufferedReader;

import java.io.FileReader;

/**
 *  Discrete Cosine Transform
 */
public class DCT extends TransformNumbers{

    /**
     *  real numbers
     */
    double[] reals;
    /**
     * output numbers
     */
    double[] outs;

    /**
     * Constructor
     * @param inputFile
     * input file name
     * @param outputFile
     * output file name
     * @param N
     * number count
     */
    public DCT(String inputFile, String outputFile, int N){
        super(inputFile, outputFile, N);
        reals = new double[N];
        outs = new double[N];
    }

    /**
     * Reads numbers from file as real numbers and prints them.
     * Each line has a real number
     * @param filename
     * file name
     * @param N
     * number count
     */
    @Override
    protected void ReadNumbersFromFile(String filename, int N) {
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(filename);
            reader = new BufferedReader(fileReader);
            String line;

            int i = 0;

            while((line = reader.readLine()) != null)
            {
                reals[i] = Double.parseDouble(line);

                System.out.println(reals[i]);
                ++i;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {

            try {

                if (reader != null) {
                    reader.close();
                }

                if (fileReader != null)
                    fileReader.close();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }
    }

    /**
     *  Transforms numbers using DCT formula
     *  and stores out in outs variable
     */
    @Override
    protected void TransformNumbers() {
        for(int k = 0; k < N; k++){
            double x = 0;
            for(int n = 0; n < N; n++){
                double a = (Math.PI / N) * (n + 1/2)*k;
                x += reals[n] * Math.cos(a);
            }
            outs[k] = x;
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
            out += "x" + i + " : " + (float)outs[i] + "\n";

        System.out.println(out);
        WriteToFile(out);
    }

    @Override
    protected void RespondUser() {
        return;
    }
}
