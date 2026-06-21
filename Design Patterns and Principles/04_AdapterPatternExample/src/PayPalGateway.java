public class PayPalGateway {
    // PayPal uses its own method name and prints its own message
    public void sendPayment(double amountInUSD) {
        System.out.println("Processing payment of $" + amountInUSD + " via PayPal.");
    }
}
