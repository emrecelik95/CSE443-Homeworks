package sample;

/**
 *  Axe State
 */
public class Axe implements State {

    /**
     *  student
     */
    Student s;

    /**
     * Constructor
     * @param s
     * student
     */
    public Axe(Student s){
        this.s = s;
    }

    /**
     * overrided toStrimg
     * @return
     * string
     */
    @Override
    public String toString() {
        return "Axe";
    }

    // Overrided Methods
    /**
     *  Overrided Method
     */
    @Override
    public void hardwork() {
        throw new UnsupportedOperationException();
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
