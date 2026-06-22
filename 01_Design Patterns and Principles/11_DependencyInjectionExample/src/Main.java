public class Main {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("--- Testing Dependency Injection ---");
        service.showCustomerDetails(42);
        service.showCustomerDetails(99);
    }
}