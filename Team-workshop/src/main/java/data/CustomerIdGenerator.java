package data;

public class CustomerIdGenerator {
    private static int id = 0;

    public static int nextCustomerId(){
        return ++id;
    }

    public static void resetId(){
        id = 0;
    }
}