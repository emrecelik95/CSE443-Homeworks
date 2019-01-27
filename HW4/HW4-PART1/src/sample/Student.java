package sample;

/**
 *  Keeps and handles all states;
 */
public class Student implements State{

    private State ready;
    private State fit;
    private State graduate;
    private State axe;
    private State needSleep;
    private State chronic;

    private State state;

    public Student(){
        ready = new Ready(this);
        fit = new Fit(this);
        graduate = new Graduate(this);
        axe = new Axe(this);
        needSleep = new NeedSleep(this);
        chronic = new ChronicIlness(this);

        SetState(ready);
    }


    public void SetState(State state){
        this.state = state;
        System.out.println("Current State : " + state);
    }

    /**
     *  Overrided Method
     */
    @Override
    public void hardwork() {
        state.hardwork();
    }

    /**
     *  Overrided Method
     */
    @Override
    public void exercise() {
        state.exercise();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void buyGtx1080() {
        state.buyGtx1080();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void cheating() {
        state.cheating();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void outTillDate() {
        state.outTillDate();
    }

    public State getReady() {
        return ready;
    }

    public State getFit() {
        return fit;
    }

    public State getGraduate() {
        return graduate;
    }

    public State getAxe() {
        return axe;
    }

    public State getNeedSleep() {
        return needSleep;
    }

    public State getChronic() {
        return chronic;
    }

    public State getState() {
        return state;
    }
    /**
     *  Overrided Method
     */
    @Override
    public void sleep() {
        state.sleep();
    }
    /**
     *  Overrided Method
     */
    @Override
    public void coffeeAndWork() {
        state.coffeeAndWork();
    }
}
