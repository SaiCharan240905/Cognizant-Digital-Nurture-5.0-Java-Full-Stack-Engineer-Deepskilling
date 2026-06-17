// --------------------------------------------------
// Customer Model Class
// --------------------------------------------------
class Customer {

    private int customerId;
    private String customerName;

    public Customer(
            int customerId,
            String customerName) {

        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {

        return "Customer ID : " + customerId +
               ", Customer Name : " + customerName;
    }
}

// --------------------------------------------------
// Repository Interface
// --------------------------------------------------
interface CustomerRepository {

    Customer findCustomerById(int customerId);
}

// --------------------------------------------------
// Concrete Repository Implementation
// --------------------------------------------------
class CustomerRepositoryImpl
        implements CustomerRepository {

    @Override
    public Customer findCustomerById(
            int customerId) {

        // Simulated Database Records

        if (customerId == 101) {

            return new Customer(
                    101,
                    "Sai Charan");
        }

        if (customerId == 102) {

            return new Customer(
                    102,
                    "Rahul Kumar");
        }

        if (customerId == 103) {

            return new Customer(
                    103,
                    "Priya Sharma");
        }

        return null;
    }
}

// --------------------------------------------------
// Service Class
// --------------------------------------------------
class CustomerService {

    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(
            CustomerRepository repository) {

        this.repository = repository;
    }

    public Customer getCustomer(
            int customerId) {

        return repository.findCustomerById(
                customerId);
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class DependencyInjectionExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Dependency Injection Demo =====\n");

        // Create Repository Object
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        // Inject Repository into Service
        CustomerService service =
                new CustomerService(repository);

        // Search Customer
        int customerId = 101;

        Customer customer =
                service.getCustomer(customerId);

        if (customer != null) {

            System.out.println(
                    "Customer Found:");

            System.out.println(customer);
        }
        else {

            System.out.println(
                    "Customer Not Found.");
        }
    }
}