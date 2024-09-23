package com.Customer.services;

import com.Customer.entity.Customer;
import java.util.List;

public interface CustomerServices {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer getCustomer(String id);
    Customer updateCustomer(String id, Customer customer);
    String deleteCustomer(String id);
}
