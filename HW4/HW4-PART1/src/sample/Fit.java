package sample;

/**
 *  Fit State
 */
public class Fit implements State {

    /**
     *  student
     */
    Student s;

    /**
     * Constructor
     * @param s
     * student
     */
    public Fit(Student s){
        this.s = s;
    }

    /**
     * overrided toStrimg
     * @return
     * string
     */
    @Override
    public String toString() {
        return "Fit";
    }

    /**
     *  Overrided Method
     */

    @Override
    public void hardwork() {
        System.out.println("-Perseverance and Hardworking...");
        System.out.println("Changing state to Graduate");
        s.SetState(s.getGraduate());
    }
    /**
     *  Overrided Method
     */
    @Override
    public void exercise() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void buyGtx1080() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void cheating() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void outTillDate() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void sleep() {
        throw new UnsupportedOperationException();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void coffeeAndWork() {
        throw new UnsupportedOperationException();
    }

}
