package model;

public class BankAccount {
    private final int accountNumber;
    private double balance;
    private int customerId;

    public BankAccount(int accountNumber, double balance, int customerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountInformation(){
        return "accountNumber: " + accountNumber +"\n"
                + " balance: " + balance + "\n"
                + "customerId: " + customerId;
    }

    public double depositFund(double fund){
        setBalance(balance + fund);

        return balance;
    }

    public double withdraw(double fund){
        if(balance >= fund){
            setBalance(balance - fund);
        }

        return  balance;
    }

}