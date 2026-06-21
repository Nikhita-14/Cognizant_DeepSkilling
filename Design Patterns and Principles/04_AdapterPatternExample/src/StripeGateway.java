public class StripeGateway {
    // Stripe uses another entirely different method name
    public void captureCharge(double totalAmount) {
        System.out.println("Capturing charge of $" + totalAmount + " via Stripe.");
    }
}
