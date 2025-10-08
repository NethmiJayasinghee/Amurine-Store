package controller.Customer;

import model.Customer;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String customer);
    Customer getCustomer(String id);
    List<Customer> getAll();
}
