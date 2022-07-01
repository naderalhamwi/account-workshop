package data;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private List<Customer> customers = new ArrayList<>();
    private List<String> customerEmail = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<String> getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(List<String> customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Customer createCustomer(String firstName, String lastName, String email){

        int id = CustomerIdGenerator.nextCustomerId() ;

        Customer customer = new Customer(id, firstName, lastName, email);

        if(emailIsUnique(email)){
            customer.setEmail(email);
            customerEmail.add(email);
        }
        else{
            customer.setEmail("email is not set");
        }

        customers.add(customer);

        return customer;
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
