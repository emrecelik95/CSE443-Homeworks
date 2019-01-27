package sample;

/**
 *
 *  An interface of solution methods that is used in linear systems.
 */
public interface ILinearSolutionMethod {

    /**
     * General solve method. Takes left and right matrices.
     * And returns the solution array.
     * @param linearMatrixLeft
     * Left Matrix
     * @param linearMatrixRight
     * Right Matrix
     * @return
     * Solution array or null if it has no solution.
     */
    public double[] Solve(double[][] linearMatrixLeft, double[] linearMatrixRight);

}
