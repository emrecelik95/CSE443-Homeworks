package sample;
/**
 *  Ready State
 */
public class Ready implements State{

    Student s;

    public Ready(Student s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "Ready";
    }
    /**
     *  Overrided Method
     */
    @Override
    public void hardwork() {
        System.out.println("-Hardworking perseverance...");
        System.out.println("Changing state to Graduate");
        s.SetState(s.getGraduate());

    }
    /**
     *  Overrided Method
     */
    @Override
    public void exercise() {
        System.out.println("-Exercising...");
        System.out.println("Changing state to Fit");
        s.SetState(s.getFit());

    }
    /**
     *  Overrided Method
     */
    @Override
    public void buyGtx1080() {
        System.out.println("Buying a GTX1080...");
        System.out.println("Changing state to Axe");
        s.SetState(s.getAxe());
    }
    /**
     *  Overrided Method
     */
    @Override
    public void cheating() {
        System.out.println("Cheating...");
        System.out.println("Changing state to Axe");
        s.SetState(s.getAxe());
    }
    /**
     *  Overrided Method
     */
    @Override
    public void outTillDate() {
        System.out.println("-Staying out till late...");
        System.out.println("Changing state to Needing Sleep");
        s.SetState(s.getNeedSleep());
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
