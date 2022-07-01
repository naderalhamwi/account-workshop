package data;

import model.BankAccount;
import model.Customer;

import java.util.Arrays;

public class BankAccountDAO {

    public BankAccount createBankAccount(int accountNumber, double balance, int customerId){
        BankAccount bankAccount = new BankAccount(accountNumber, balance, customerId);

        return bankAccount;
    }

}

