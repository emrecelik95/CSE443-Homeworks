package sample;

/**
 *  Matrix Inversion method to solve linear systems.
 */
public class MatrixInversion implements ILinearSolutionMethod {

    /**
     * Interface method. Takes left and right matrices as input.
     * Returns the solution array.
     * @param A
     * left matrix
     * @param B
     * right matrix
     * @return
     * Null if the system has no solution.
     *
     */

    @Override
    public double[] Solve(double[][] A, double[] B) {

        double[][] rightSide = new double[B.length][1];
        for (int i = 0; i < B.length; i++)
            rightSide[i][0] = B[i];

        double[][] tmp = CopyMatrix(A);

        double[][] inverse = InverseMatrix(tmp);
        if (inverse == null) {
            return null;
        }

        double[][] mult = MultiplyMatrices(inverse, rightSide);

        double[] result = new double[B.length];
        for (int i = 0; i < B.length; i++)
            result[i] = mult[i][0];

        return result;
    }

    /**
     * Takes a matrix and returns it inverse.
     * @param A
     * Matrix
     * @return
     * Null if its determinant is zero or NaN.
     */
    public double[][] InverseMatrix(double[][] A) {

        double det = Determinant(A);
        if (det == 0 || Double.isNaN(det)) {
            System.out.println("Determinant is zero or NaN. No Solution!");
            return null;
        }


        int n = A.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;

        UpperTriangle(A, index);

        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[index[j]][k] -= A[index[j]][i] * b[index[i]][k];

        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / A[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= A[index[j]][k] * x[k][i];
                }
                x[j][i] /= A[index[j]][j];
            }
        }
        return x;

    }

    /**
     *
     * @param m
     * Matrix to be multiplied.
     * @param factor
     * Multiplier
     * @return
     * Matrix
     */
    double[][] MultiplyMatrix(double[][] m, double factor){
        for(int i = 0 ; i < m.length ; ++i)
            for(int j = 0 ; j < m[0].length ; ++j)
                m[i][j] *= factor;

        return m;
    }


    /**
     * Transforms a matrix to an upper triangular matrix.
     *
     * @param m
     * Matrix
     * @param ind
     * Index array
     *
     */
    public void UpperTriangle(double m[][], int ind[]) {
        int n = ind.length;
        int z = 0;
        double x[] = new double[n];

        for (int i = 0; i < n; ++i)
            ind[i] = i;

        for (int i = 0; i < n; ++i) {
            double a = 0;
            for (int j = 0; j < n; ++j) {
                double b = Math.abs(m[i][j]);
                if (b > a) a = b;
            }
            x[i] = a;
        }


        for (int j = 0; j < n - 1; ++j) {
            double p1 = 0;
            for (int i = j; i < n; ++i) {
                double p0 = Math.abs(m[ind[i]][j]) / x[ind[i]];
                if (p0 > p1) {
                    p1 = p0;
                    z = i;
                }
            }

            int temp = ind[j];
            ind[j] = ind[z];
            ind[z] = temp;

            for (int i = j + 1; i < n; ++i) {
                m[ind[i]][j] = m[ind[i]][j] / m[ind[j]][j];
                for (int k = j + 1; k < n; ++k)
                    m[ind[i]][k] -= m[ind[j]][k] * m[ind[i]][j];
            }
        }
    }


    /**
     * Multiplies two matrices and then returns the result.
     *
     * @param A
     * First Matrix
     * @param B
     * Second Matrix
     * @return
     * Multiplication Matrix.
     */
    public double[][] MultiplyMatrices(double[][] A, double[][] B){

        int a = A.length;
        int x = B.length;
        int b = B[0].length;

        double sum = 0;

        double[][] multiply = new double[a][b];

        for(int i = 0; i < a; i++)
        {
            for(int j = 0; j < b; j++)
            {
                for(int k = 0; k < x; k++)
                {
                    sum = sum + A[i][k]*B[k][j];
                }

                multiply[i][j] = sum;
                sum = 0;
            }
        }

        return multiply;
    }

    /**
     * Copies a matrix and returns it.
     * @param m
     * Matrix
     * @return
     * Copied Matrix.
     */
    public double[][] CopyMatrix(double[][] m){
        double[][] tmp = new double[m.length][m[0].length];
        for(int i = 0; i < m.length; i++)
            for(int j = 0; j < m[0].length; j++)
                tmp[i][j] = m[i][j];

        return tmp;
    }

    /**
     * Calculates determinant of a matrix.
     *
     * @param m
     * Matrix
     * @return
     * Determinant Of m.
     */
    public double Determinant(double[][] m){

        double det;
        double ratio;

        int r = m.length;
        int c = m[0].length;

        double[][] tmp = CopyMatrix(m);

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(j>i){
                    ratio = tmp[j][i]/tmp[i][i];

                    for(int k = 0; k < r; k++)
                        tmp[j][k] -= ratio * tmp[i][k];
                }
            }
        }

        det = 1;

        for(int i = 0; i < r; i++)
            det *= tmp[i][i];

        return det;

    }



    /*
    private void PrintMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.print(m[i][j] + " ");

            System.out.println();
        }
    }

    */
    /*
    public double[][] Transpose(double[][] m) {

        int r = m.length;
        int c = m[0].length;
        double[][] t = new double[r][c];

        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                t[j][i] = m[i][j];

        return t;
    }

    public double[][] CoFactor(double[][] m){

        double deter;
        int c = m.length;
        int r = m[0].length;
        int i1, j1;

        double co[][] = new double[c][r];
        double[][] result = new double[c][r];

        for (int j=0;j<r;j++) {
            for (int i=0;i<c;i++) {

                i1 = 0;
                for (int ii=0;ii<r;ii++) {
                    if (ii == i)
                        continue;
                    j1 = 0;
                    for (int jj=0;jj<c;jj++) {
                        if (jj == j)
                            continue;

                        co[i1][j1] = m[ii][jj];
                        j1++;
                    }
                    i1++;
                }

                deter = Determinant(co);

                result[i][j] = Math.pow(-1.0, i + j + 2.0) * deter;
            }
        }

        return co;
    }

    public double[][] InverseMatrix(double[][] A) {


        int r = A.length;
        int c = A[0].length;
        double[][] temp = CopyMatrix(A);


        double[][] inverse = CoFactor(temp);

        double[][] transpose = Transpose(inverse);

        for(int i = 0 ; i < r ; i++)
            for(int j = 0 ; j < c ; j++)
                inverse[i][j] = transpose[i][j];

        inverse = MultiplyMatrix(inverse, 1/Determinant(temp));
        return inverse;

    }

    */

}
