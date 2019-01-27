package sample;

/**
 *  Concrete Turbo Payment Class
 */
public class ConcreteTurboPayment implements TurboPayment {

    /**
     * Overriding method.
     * @param turboCardNo
     * Card no
     * @param turboAmount
     * payment amount
     * @param destinationTurboOfCourse
     * destination
     * @param installmentsButInTurbo
     * installments
     * @return
     * amount
     */
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {

        System.out.println("Paying with Turbo Payment...");
        System.out.println("Card No : " + turboCardNo);
        System.out.println("Destination : " + destinationTurboOfCourse);
        System.out.println("Installments : " + installmentsButInTurbo);
        System.out.println("Paying is done!");

        return (int)turboAmount;
    }

}
