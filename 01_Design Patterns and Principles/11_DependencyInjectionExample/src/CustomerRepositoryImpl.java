public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        if (id == 42) {
            return "D Nikhita (ID: 42)";
        }
        return "Customer not found";
    }
}