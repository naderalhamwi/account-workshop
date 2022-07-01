package data;

import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {

    @Test
    void createCustomer() {
        //Arrange
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.createCustomer(firstName, lastName, email);

        Customer expectedCustumer = customerDAO.getCustomers().get(0);

        //Assert
        assertEquals(email, expectedCustumer.getEmail());
        assertEquals(lastName, expectedCustumer.getLastName());
        assertEquals(firstName, expectedCustumer.getFirstName());
        assertEquals(accountNumber, expectedCustumer.getAccountNumber());
    }

    @Test
    void emailIsUnique() {
        //Arrange
        List<String> customerEmail = new ArrayList<>();

        //Act
        customerEmail.add("emailA@email.com");
        customerEmail.add("emailB@email.com");
        customerEmail.add("emailC@email.com");
        customerEmail.add("emailD@email.com");
        customerEmail.add("emailE@email.com");

        //Assert
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setCustomerEmail(customerEmail);

        boolean elailValidation = customerDAO.emailIsUnique("emailC@email.com");

        //Assert
        assertFalse(elailValidation);
    }

    @Test
    void emailNotUnique() {
        //Arrange
        List<String> customerEmail = new ArrayList<>();

        //Act
        customerEmail.add("emailA@email.com");
        customerEmail.add("emailB@email.com");
        customerEmail.add("emailC@email.com");
        customerEmail.add("emailD@email.com");
        customerEmail.add("emailE@email.com");

        //Assert
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setCustomerEmail(customerEmail);

        boolean elailValidation = customerDAO.emailIsUnique("emailF@email.com");

        //Assert
        assertTrue(elailValidation);
    }

    @Test
    void should_Return_A_Customer_With_A_Given_Id() {
        //Arrange
        Customer customer1 = new Customer(CustomerIdGenerator.nextCustomerId(), "Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer(CustomerIdGenerator.nextCustomerId(), "Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer(CustomerIdGenerator.nextCustomerId(), "Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.getCustomers().add(customer1);
        customerDAO.getCustomers().add(customer2);
        customerDAO.getCustomers().add(customer3);

        Customer expectedCustomer = customerDAO.searchById(customer3.getId());

        // Assert
        assertEquals(customer3, expectedCustomer);
    }

    @Test
    void should_Return_Null_With_A__Id() {
        //Arrange
        Customer customer1 = new Customer(CustomerIdGenerator.nextCustomerId(), "Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer(CustomerIdGenerator.nextCustomerId(), "Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer(CustomerIdGenerator.nextCustomerId(), "Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.getCustomers().add(customer1);
        customerDAO.getCustomers().add(customer2);
        customerDAO.getCustomers().add(customer3);

        Customer expectedCustomer = customerDAO.searchById(10);

        // Assert
        assertEquals(expectedCustomer, null);
    }

    @Test
    void customerIsRemoved() {
        //Arrange
        Customer customer1 = new Customer(CustomerIdGenerator.nextCustomerId(), "Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer(CustomerIdGenerator.nextCustomerId(), "Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer(CustomerIdGenerator.nextCustomerId(), "Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.getCustomers().add(customer1);
        customerDAO.getCustomers().add(customer2);
        customerDAO.getCustomers().add(customer3);

        boolean custumerRemodved = customerDAO.customerIsRemoved(customer2.getId());

        // Assert
        assertTrue(custumerRemodved);
    }

    @Test
    void customerIsNotRemoved() {
        //Arrange
        Customer customer1 = new Customer(CustomerIdGenerator.nextCustomerId(), "Odi", "Sombathkamria", "odi@gmail.com");
        Customer customer2 = new Customer(CustomerIdGenerator.nextCustomerId(), "Nader", "Alhamwi", "nader@gmail.com");
        Customer customer3 = new Customer(CustomerIdGenerator.nextCustomerId(), "Christopher", "Svensson", "christopher@gmail.com");

        //Act
        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.getCustomers().add(customer1);
        customerDAO.getCustomers().add(customer2);
        customerDAO.getCustomers().add(customer3);

        boolean custumerNotRemodved = customerDAO.customerIsRemoved(100);

        // Assert
        assertFalse(custumerNotRemodved);
    }
}