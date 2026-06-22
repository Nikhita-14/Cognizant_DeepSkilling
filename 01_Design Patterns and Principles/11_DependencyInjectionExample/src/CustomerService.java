public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void showCustomerDetails(int id) {
        String details = customerRepository.findCustomerById(id);
        System.out.println("Service Fetch Result: " + details);
    }
}