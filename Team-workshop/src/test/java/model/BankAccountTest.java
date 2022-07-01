package model;

import data.AccountNumberGenerator;
import data.CustomerIdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getAccountNumber() {
        //Arrange
        int accNumber= 0;
        int expectedId = 1;

        //Act
        AccountNumberGenerator.resetId();
        accNumber = AccountNumberGenerator.nextAccountNumber();
        BankAccount bankAccount = new BankAccount(accNumber, 0, 1);

        //Assert
        assertEquals(accNumber, bankAccount.getAccountNumber());
    }

    @Test
    void getBalance() {
        //Arrange
        int accNumber = 0;
        double balance = 100;

        //Act
        AccountNumberGenerator.resetId();
        accNumber = AccountNumberGenerator.nextAccountNumber();
        BankAccount bankAccount = new BankAccount(accNumber, 100, 1);

        //Assert
        assertEquals(balance, bankAccount.getBalance());
    }

    @Test
    void getCustomerId() {
        //Arrange
        int accNumber= AccountNumberGenerator.nextAccountNumber();
        int expectedId = CustomerIdGenerator.nextCustomerId();

        //Act
        CustomerIdGenerator.resetId();
        Customer customer = new Customer(expectedId, "firstName", "lastName", "email@email.com");

        AccountNumberGenerator.resetId();
        BankAccount bankAccount = new BankAccount(accNumber, 0, 1);

        //Assert
        assertEquals(expectedId, bankAccount.getCustomerId());
    }

    @Test
    void depositFund() {
        //Arrange
        int accNumber = 0;
        double balance = 0;

        //Act
        AccountNumberGenerator.resetId();
        accNumber = AccountNumberGenerator.nextAccountNumber();
        BankAccount bankAccount = new BankAccount(accNumber, balance, 1);
        balance = bankAccount.depositFund(100);

        //Assert
        assertEquals(balance, bankAccount.getBalance());
    }

    @Test
    void withdraw() {
        //Arrange
        int accNumber = 0;
        double balance = 100;

        //Act
        AccountNumberGenerator.resetId();
        accNumber = AccountNumberGenerator.nextAccountNumber();
        BankAccount bankAccount = new BankAccount(accNumber, balance, 1);
        balance = bankAccount.withdraw(50);

        //Assert
        assertEquals(balance, bankAccount.getBalance());
    }
}