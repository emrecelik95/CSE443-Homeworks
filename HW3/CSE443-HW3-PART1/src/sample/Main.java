package sample;

public class Main {

    public static void main(String[] args) {

        TurboPayment turboPayment = new ConcreteTurboPayment();
        System.out.println("- Turbo Payment Object -");
        turboPayment.payInTurbo("01", 255.99f, "Gümüşhane", "9");
        System.out.println();

        System.out.println("- Modern Payment Object -");
        ModernPayment modernPayment = new ConcreteModernPayment();
        modernPayment.pay("02", 100.0f, "İstanbul", "12");
        System.out.println();

        System.out.println("- Adaptor Object for paying Modern In Turbo -");
        TurboPayment payment = new ModernPaymentAdaptor(modernPayment);
        payment.payInTurbo("02", 100.0f, "İstanbul", "12");

    }
}
