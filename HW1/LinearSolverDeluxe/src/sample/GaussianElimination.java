package sample;

/**
 *
 *  Gaussian Elimination method to solve linear systems.
 */
public class GaussianElimination implements ILinearSolutionMethod {

    /**
     * Interface method. Takes left and right matrices as input.
     * Returns the solution array.
     * @param orgA
     * left matrix
     * @param B
     * right matrix
     * @return
     * Returns null if the system has no solution.
     *
     */
    @Override
    public double[] Solve(double[][] orgA, double[] B) {

        double[][] A = new double[orgA.length][orgA.length + 1];

        int x = A.length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++)
                A[i][j] = orgA[i][j];
        }

        for (int i = 0; i < x; i++)
            A[i][x] = B[i];

        double[] vars = new double[x];
        double[] pre = null;

        for (int i = 0; i < x; ++i)
            vars[i] = (double) 0;

        int iter = 1;
        double totalCur = 0;
        do{
            pre = new double[x];
            for(int i = 0; i < x; i++)
                pre[i] = vars[i];

            for(int i = 0 ; i < x ; ++i){
                double coef = A[i][i];
                totalCur = (double)0;
                for(int j = 0 ; j < x ; ++j){
                    if(j != i){
                        totalCur += A[i][j] * pre[j];
                    }
                }
                totalCur = (A[i][x] - totalCur) / coef;

                vars[i] = totalCur;
                if(Double.isNaN(totalCur)){
                    System.out.println("System has no solution!");
                    return null;
                }
                if(Double.isInfinite(totalCur)){
                    System.out.println("System has infinite solution!");
                    return null;
                }
            }

        }while(Norm(DiffOfVects(pre,vars)) / Norm(vars) >= 0.000001);

        return vars;
    }

    /**
     * Norm of the vector.
     * @param vect
     * Vector
     * @return
     * Norm of the vector.
     */
    public double Norm(double[] vect){
        double total = 0;
        for(int i = 0 ; i < vect.length ; ++i){
            total += Math.pow(vect[i], 2);
        }
        return Math.sqrt(total);
    }

    /**
     * Different vector of two vectors.
     * @param vect
     * Vector1
     * @param vect2
     * Vector2
     * @return
     * Difference Vector
     */
    public double[] DiffOfVects(double[] vect, double[] vect2){
        double[] res = new double[vect.length];
        for(int i = 0 ; i < vect.length ; ++i){
            res[i] = (vect2[i] - vect[i]);
        }
        return res;
    }


}