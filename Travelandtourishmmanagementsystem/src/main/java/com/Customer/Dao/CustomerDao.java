package com.Customer.Dao;

import com.Customer.entity.Customer;
import com.Customer.entity.Booking;
import java.util.List;

public interface CustomerDao {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Booking createCustomerBooking(Booking booking);
    Customer getCustomer(String customerID);
    List<Booking> getBookingDetailsByTravelPackageId(String travelPackageId);
    Customer updateCustomer(String customerID, Customer updatedCustomer);
    String deleteCustomer(String customerID);
    
    Customer getCustomerById(String customerId);

}
