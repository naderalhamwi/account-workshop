package model;

import data.AccountNumberGenerator;
import data.CustomerIdGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void constructObject() {
        //Arrange
        int id = 0;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        id = CustomerIdGenerator.nextCustomerId();
        Customer customer = new Customer(id, firstName, lastName, email);

        //Assert
        assertEquals(id, customer.getId());
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(email, customer.getEmail());
        assertEquals(accountNumber, customer.getAccountNumber());
    }

    @Test
    void getId() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);

        //Assert
        assertEquals(id, customer.getId());
    }

    @Test
    void getFirstName() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);

        //Assert
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    void setFirstName() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        String expectedFirstName = "a_first_name";

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);
        customer.setFirstName(expectedFirstName);

        //Assert
        assertEquals(expectedFirstName, customer.getFirstName());
    }

    @Test
    void getLastName() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);

        //Assert
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    void setLastName() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        String expectedLastName = "a_last_name";

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);
        customer.setFirstName(expectedLastName);

        //Assert
        assertEquals(expectedLastName, customer.getFirstName());
    }

    @Test
    void getEmail() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);

        //Assert
        assertEquals(email, customer.getEmail());
    }

    @Test
    void setEmail() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        String expectedEmail = "new-email";

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);
        customer.setEmail(expectedEmail);

        //Assert
        assertEquals(expectedEmail, customer.getEmail());
    }

    @Test
    void getAccountNumber() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);

        //Assert
        assertEquals(accountNumber, customer.getAccountNumber());
    }

    @Test
    void setAccountNumber() {
        //Arrange
        int id = 1;
        String firstName = "Simon";
        String lastName = "Elbrink";
        String email = "se@mail.com";
        int accountNumber = 0;

        //Act
        Customer customer = new Customer(id, firstName, lastName, email);
        accountNumber = AccountNumberGenerator.nextAccountNumber();
        customer.setAccountNumber(accountNumber);

        //Assert
        assertEquals(accountNumber, customer.getAccountNumber());
    }

    @Test
    void getSummary() {

    }
}