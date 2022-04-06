package com.suninvirgo.customer;


import java.util.List;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    List<Customer> getCustomers();
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomers(String searchName);
}
