package data;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private List<Customer> customers = new ArrayList<>();
    private List<String> customerEmail = new ArrayList<>();

    public void createCustomer(String firstName, String lastName, String email){

        int id = CustomerIdGenerator.nextCustomerId() ;
        int accountNumber = AccountNumberGenerator.nextAccountNumber();

        Customer customer = new Customer(id, firstName, lastName, email);
        customer.setAccountNumber(accountNumber);

        if(emailIsUnique(email)){
            customer.setEmail(email);
            customerEmail.add(email);
        }

        customers.add(customer);
    }

     public boolean emailIsUnique(String email){
         if(customerEmail.contains(email)){
            return false;
         }

         return  true;
     }

     public Customer searchById(int customerId){
         for (Customer customer : customers) {
             if(customerId == customer.getId()){
                 return customer;
             }
         }

         return null;
     }

    public boolean customerIsRemoved(int customerId){
        for (Customer customer : customers) {
            if(customerId == customer.getId()){
                customers.remove(customer);
                return true;
            }
        }

        return false;
    }
}
