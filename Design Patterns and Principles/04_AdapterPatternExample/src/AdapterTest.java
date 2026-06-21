public class AdapterTest {
    public static void main(String[] args) {
        // 1. Set up the foreign vendor objects
        PayPalGateway legacyPayPal = new PayPalGateway();
        StripeGateway legacyStripe = new StripeGateway();

        // 2. Wrap them inside our adapters so they fit our system
        PaymentProcessor payPalProcessor = new PayPalAdapter(legacyPayPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(legacyStripe);

        // 3. Process payments uniformly using our standard 'processPayment' rule
        System.out.println("--- Executing Transactions ---");
        payPalProcessor.processPayment(150.50);
        stripeProcessor.processPayment(299.99);
    }
}
