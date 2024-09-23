package com.Customer.servicesimpl;

import java.util.List;
import java.util.logging.Logger;

import com.Customer.services.CustomerServices;
import com.Customer.entity.Customer;
import com.Customer.Dao.CustomerDao;
import com.Customer.daoimp.CustomerDaoImp;

public class CustomerServicesImp implements CustomerServices {

    // Data access object for Customer
    private CustomerDao customerDao = new CustomerDaoImp();

    private static final Logger LOGGER = Logger.getLogger(CustomerServicesImp.class.getName());

    // Create a new customer
    @Override
    public Customer createCustomer(Customer customer) {
        validateCustomer(customer);
        try {
            Customer createdCustomer = customerDao.createCustomer(customer);
            LOGGER.info("Customer created successfully with ID: " + customer.getId());
            return createdCustomer;
        } catch (Exception e) {
            LOGGER.severe("Error during customer creation: " + e.getMessage());
            throw new RuntimeException("Failed to create customer", e);
        }
    }
   
    public void createCustomer(String customerId) {
        System.out.println("Creating customer with ID: " + customerId); // Debug statement
        validateCustomer(customerId);
        // logic to create customer
    }

    
    public void createCustomer(String customerId, String customerName) {
        try {
            validateCustomer(customerId);
            // Continue with creating the customer...
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            // Handle the exception (e.g., notify the user, log the error)
        }
    }

    // Get a list of all customers
    @Override
    public List<Customer> getAllCustomers() {
        try {
            return customerDao.getAllCustomers();
        } catch (Exception e) {
            LOGGER.severe("Failed to retrieve customers: " + e.getMessage());
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

    // Retrieve a customer by ID
    @Override
    public Customer getCustomer(String id) {
        if (id == null || id.isEmpty()) {
            LOGGER.warning("Invalid Customer ID.");
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }

        try {
            return customerDao.getCustomerById(id);
        } catch (Exception e) {
            LOGGER.severe("Failed to retrieve customer with ID: " + id);
            throw new RuntimeException("Error retrieving customer", e);
        }
    }

    // Update an existing customer by ID
    @Override
    public Customer updateCustomer(String id, Customer customer) {
        validateCustomer(customer);

        try {
            Customer existingCustomer = customerDao.getCustomerById(id);
            if (existingCustomer == null) {
                LOGGER.warning("Customer not found with ID: " + id);
                throw new IllegalArgumentException("Customer not found with ID: " + id);
            }

            customerDao.updateCustomer(id, customer);
            LOGGER.info("Customer updated successfully with ID: " + id);
            return customer;
        } catch (Exception e) {
            LOGGER.severe("Failed to update customer with ID: " + id);
            throw new RuntimeException("Error updating customer", e);
        }
    }

    // Delete a customer by ID
    @Override
    public String deleteCustomer(String id) {
        if (id == null || id.isEmpty()) {
            LOGGER.warning("Invalid Customer ID.");
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }

        try {
            customerDao.deleteCustomer(id);
            LOGGER.info("Customer removed successfully with ID: " + id);
            return "Customer removed successfully";
        } catch (Exception e) {
            LOGGER.severe("Failed to delete customer with ID: " + id);
            throw new RuntimeException("Error deleting customer", e);
        }
    }

    public void validateCustomer(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        // additional validation logic
    }

    private void validateCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId().isEmpty()) {
            LOGGER.warning("Invalid Customer ID.");
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
    }
    
}
