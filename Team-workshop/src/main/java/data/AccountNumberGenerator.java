package data;

public class AccountNumberGenerator {
    private static int accountNumber = 0;

    public static int nextAccountNumber(){

        return ++accountNumber;
    }

    public static void resetId(){

        accountNumber = 0;
    }
}