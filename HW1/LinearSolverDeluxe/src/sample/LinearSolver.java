package sample;


/**
 *
 *  A Linear Solver Class that is used for solving
 *  Linear Equation Systems
 */
public class LinearSolver {

    /**
     * LinearSolutionMethod for solving the system.
     */
    private ILinearSolutionMethod solutionMethod;

    /**
     *  Left matrix.
     */
    private double[][] leSystemMatrixLeft;

    /**
     *  Right Matrix.
     */
    private double[] leSystemMatrixRight;

    /**
     * Right Matrix Setter.
     * @param matrix
     * Right Matrix
     */
    public boolean setLeSystemMatrixRight(double[] matrix) {

        if(matrix != null){
            leSystemMatrixRight = matrix;
            return true;
        }
        else
            return false;
    }

    /**
     * Solution Method Setter.
     * @param solutionMethod
     * New Solution Method.
     */
    public void setSolutionMethod(ILinearSolutionMethod solutionMethod) {
        this.solutionMethod = solutionMethod;
    }

    /**
     * Left Matrix Setter.
     * @param matrix
     * Matrix
     * @return
     * True if matrix is not null.
     */
    public boolean setLeSystemMatrixLeft(double[][] matrix){
        if(matrix != null){
            leSystemMatrixLeft = matrix;
            return true;
        }
        else
            return false;

    }


    /**
     * Public Solver Method.
     * Returns null if the solution method is null.
     * @return
     * Solution Array.
     */
    public double[] SolveLinearSystem(){
        if(solutionMethod == null)
            return null;

        return solutionMethod.Solve(leSystemMatrixLeft, leSystemMatrixRight);
    }

}
