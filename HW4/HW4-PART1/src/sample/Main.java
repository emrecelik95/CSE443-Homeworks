package sample;


/**
 *  Main Class Of Application
 */
public class Main {

    /**
     *  main method
     * @param args
     * argumants
     */
    public static void main(String[] args) {

        System.out.println("Student 1");
        Student st = new Student();
        st.exercise();
        st.hardwork();

        System.out.println("\nStudent 2");
        Student st2 = new Student();
        st2.buyGtx1080();

        System.out.println("\nStudent 3");
        Student st3 = new Student();
        st3.outTillDate();
        st3.coffeeAndWork();

        System.out.println("\nStudent 4");
        Student st4 = new Student();
        st4.cheating();

        System.out.println("\nStudent 5");
        Student st5 = new Student();
        st5.hardwork();

        System.out.println("\nStudent 6");
        Student st6 = new Student();
        st6.outTillDate();
        st6.sleep();

        return;
    }
}
