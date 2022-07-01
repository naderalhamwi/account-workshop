package data;

import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    ArrayList<Customer> customers = new ArrayList<>();

    @BeforeEach
    void createCustomers(){
        Customer customer1 = new Customer(CustomerIdGenerator.nextCustomerId(), "Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer(CustomerIdGenerator.nextCustomerId(), "Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer(CustomerIdGenerator.nextCustomerId(), "Christopher", "Svensson", "christopher@gmail.com");

        customer1.setAccountNumber(AccountNumberGenerator.nextAccountNumber());
        customer2.setAccountNumber(AccountNumberGenerator.nextAccountNumber());
        customer3.setAccountNumber(AccountNumberGenerator.nextAccountNumber());

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    @Test
    void createCustomer() {
    }

    @Test
    void emailIsUnique() {
    }

    @Test
    void searchById() {
    }

    @Test
    void customerIsRemoved() {
    }
}