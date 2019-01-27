package sample;
/**
 *  Graduate State
 */
public class Graduate implements State {

    Student s;

    public Graduate(Student s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "Graduate";
    }

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
