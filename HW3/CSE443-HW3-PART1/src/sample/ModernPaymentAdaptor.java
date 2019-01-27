package sample;

/**
 *  Modern Payment Adaptor Class that implements TurboPayment
 *  and holds a modernPayment object to make payment in payInTurbo method.
 */
public class ModernPaymentAdaptor implements TurboPayment{

    protected ModernPayment modernPayment;

    public ModernPaymentAdaptor(ModernPayment modernPayment){
        this.modernPayment = modernPayment;
    }

    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return modernPayment.pay(turboCardNo, turboAmount, destinationTurboOfCourse, installmentsButInTurbo);
    }
}
