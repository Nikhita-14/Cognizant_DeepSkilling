public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println("--- Scenario 1: Paying with Credit Card ---");
        context.setPaymentStrategy(new CreditCardPayment("Dittakavi Nikhita", "1234-5678-9876-5432"));
        context.executePayment(250.75);

        System.out.println("\n--- Scenario 2: Switching to PayPal ---");
        context.setPaymentStrategy(new PayPalPayment("dittakavinikhita@example.com"));
        context.executePayment(45.50);
    }
}