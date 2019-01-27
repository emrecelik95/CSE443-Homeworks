package sample;

/**
 *  NeedSleep State
 */
public class NeedSleep implements State {

    Student s;

    public NeedSleep(Student s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "Needing Sleep";
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
        System.out.println("-Sleeping...");
        System.out.println("Changing state to Ready");
        s.SetState(s.getReady());
    }
    /**
     *  Overrided Method
     */
    @Override
    public void coffeeAndWork() {
        System.out.println("-Drinking coffee and working...");
        System.out.println("Changing state to Chronic Ilnesss");
        s.SetState(s.getChronic());
    }

}
