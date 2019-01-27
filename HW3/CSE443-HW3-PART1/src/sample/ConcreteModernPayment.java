package sample;


/**
 * Concerete modern payment class that implements ModernPayment interface
 */
public class ConcreteModernPayment  implements ModernPayment {

    /**
     * overriding method
     * @param cardNo
     * card no
     * @param amount
     * payment amount
     * @param destination
     * destination
     * @param installments
     * installments
     * @return
     * amount
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {

        System.out.println("Paying with Modern Payment...");
        System.out.println("Card No : " + cardNo);
        System.out.println("Destination : " + destination);
        System.out.println("Installments : " + installments);
        System.out.println("Paying is done!");

        return (int)amount;
    }
}
