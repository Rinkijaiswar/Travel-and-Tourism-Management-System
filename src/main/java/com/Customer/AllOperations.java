package com.Customer;

import java.util.List;
import java.util.Scanner;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Customer.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.Customer.util.DateUtils;
import com.Customer.entity.Booking;
import com.Customer.entity.Customer;
import com.Customer.entity.TourPackage;
import com.Customer.entity.Hotel;


import com.Customer.services.HotelServices;
import com.Customer.services.BookingServices;
import com.Customer.services.CustomerServices;
import com.Customer.services.TourPackageservices;

import com.Customer.servicesimpl.BookingServicesImp;
import com.Customer.servicesimpl.CustomerServicesImp;
import com.Customer.servicesimpl.TourPackageservicesImp;
import com.Customer.servicesimpl.HotelServicesImp;

import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import com.Customer.Dao.CustomerDao;
import com.Customer.daoimp.CustomerDaoImp;


public class AllOperations {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerServicesImp.class.getName());
    private CustomerServices customerServices = new CustomerServicesImp();
    private BookingServices bookingServices = new BookingServicesImp();
    private TourPackageservices travelPackageServices = new TourPackageservicesImp();
    private HotelServices hotelServices = new HotelServicesImp();
 // Declare and initialize tourPackageServices
    private TourPackageservices tourPackageServices = new TourPackageservicesImp();


    // Scanner is now static and used across the application
    private static Scanner sc = new Scanner(System.in);
    
    
    

    private Customer customerInputs() {
    	System.out.println("Enter CustomerId");
        String CustomerId = sc.nextLine();
        
        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phoneNumber = sc.nextLine();

        // Optional: Add the Tour Package ID if needed
        System.out.println("Enter Tour Package ID (if applicable):");
        String tourPackageId = sc.nextLine();

        return new Customer(null, firstName, lastName, gender, email, phoneNumber, tourPackageId); // Include Tour Package ID
    }

    public Customer createCustomer(Customer customer) {
        validateCustomer(customer);

        try {
            CustomerServices customerDao = null;
			Customer createdCustomer = customerDao.createCustomer(customer);
            LOGGER.info("Customer created successfully with ID: " + customer.getId());
            return createdCustomer;
        } catch (Exception e) {
            LOGGER.severe("Error during customer creation: " + e.getMessage());
            throw new RuntimeException("Failed to create customer", e);
        }
    }

    private void validateCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        
        if (customer.getId() == null || customer.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty.");
        }
        
        // Additional validation can be added here if needed
    }
   

    
   

    public Hotel hotelInputs() {
        System.out.println("Enter Hotel ID:");
        String hotelId = sc.nextLine();

        System.out.println("Enter Hotel Name:");
        String hotelName = sc.nextLine();

        System.out.println("Enter Price:");
        double price = sc.nextDouble();
        sc.nextLine(); // Consume newline

        System.out.println("Enter Address:");
        String address = sc.nextLine();

        System.out.println("Enter Contact Number:");
        String contactNumber = sc.nextLine();

        System.out.println("Enter City:");
        String city = sc.nextLine();

        return new Hotel(hotelId, hotelName, price, address, contactNumber, city);
    }

    
    
    
    public Customer updatedCustomerData(String existingCustomerId) {
        System.out.println("Updating Customer Data:");

        System.out.println("Enter tourpackageid:");
        String tourpackageid = sc.nextLine();

        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Phone Number:");
        String phoneNumber = sc.nextLine();

        // Return a new Customer object with the existing ID and updated information
        return new Customer(existingCustomerId,tourpackageid, firstName, lastName, gender, email, phoneNumber);
    }

    public interface CustomerDao {
        Customer createCustomer(Customer customer);
    }


    
    public void customerOperations() {
        while (true) {
            System.out.println("Press 1. Add Customer Details\nPress 2. Retrieve All Customer Data\n"
                    + "Press 3. Update Customer Data\nPress 4. Delete Customer Data\n"
                    + "Press 5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (input) {
                case 1:
                    Customer customer = customerInputs();
                    Customer createdCustomer = customerServices.createCustomer(customer); // Assuming createCustomer returns the created Customer
                    System.out.println("Customer has been added successfully: " + createdCustomer);
                    break;

                case 2:
                    List<Customer> customers = customerServices.getAllCustomers();
                    if (customers == null || customers.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        for (Customer c : customers) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Customer ID to update the information:");
                    String cId = sc.nextLine();
                    Customer existingCustomer = customerServices.getCustomer(cId);
                    if (existingCustomer != null) {
                        Customer updatedCustomer = updatedCustomerData(cId); // Pass existing ID
                        Customer updatedInfo = customerServices.updateCustomer(cId, updatedCustomer);
                        System.out.println("Customer Data has been updated successfully: " + updatedInfo);
                    } else {
                        System.out.println("Customer ID not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Customer ID to delete the information:");
                    String id = sc.nextLine();
                    String message = customerServices.deleteCustomer(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Exits the method, returning to the main menu

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
    
    public void updateBooking() {
        System.out.println("Enter Booking ID to update the information:");
        String bId = sc.nextLine();
        
        Booking existingBooking = bookingServices.getBooking(bId); // Fetch existing booking
        
        if (existingBooking != null) {
            System.out.println("Enter Travel Package ID (leave empty to keep current):");
            String packageId = sc.nextLine();
            
            // Use the current tour package if the input is empty
            if (packageId.isEmpty()) {
                packageId = existingBooking.getTourPackage().getpackageId(); // Make sure getPackageId() is correct
            }
            
            // Proceed to update the booking details
            // ...
        } else {
            System.out.println("Booking ID not found");
        }
    }

    
    private Booking updatedBookingData(Booking existingBooking) {
        System.out.println("Updating Booking Data:");

        System.out.println("Enter Booking ID (leave empty to keep current):");
        String bookingId = sc.nextLine();
        if (bookingId.isEmpty()) {
            bookingId = existingBooking.getBookingId();
        }

        System.out.println("Enter Customer ID (leave empty to keep current):");
        String customerId = sc.nextLine();
        if (customerId.isEmpty()) {
            customerId = existingBooking.getCustomer().getId();
        }

        System.out.println("Enter Travel Package ID (leave empty to keep current):");
        String packageId = sc.nextLine();
        if (packageId.isEmpty()) {
            packageId = existingBooking.getTourPackage().getpackageId(); // Ensure this method exists
        }

        System.out.println("Enter Booking Date (YYYY-MM-DD, leave empty to keep current):");
        String bookingDateStr = sc.nextLine();
        Date bookingDate = parseDate(bookingDateStr);
        if (bookingDate == null) {
            bookingDate = existingBooking.getBookingDate(); // Use the correct getter method
        }

        // Use TourPackageServices to retrieve the TourPackage
        TourPackage tourPackage = tourPackageServices.getTourPackage(packageId);
        if (tourPackage == null) {
            System.out.println("Tour Package not found. Keeping current package.");
            tourPackage = existingBooking.getTourPackage();
        }

        // Use BookingServices to retrieve the Customer
        Customer customer = customerServices.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found. Keeping current customer.");
            customer = existingBooking.getCustomer();
        }

        return new Booking(bookingId, bookingDate, tourPackage, customer);
    }

    private Date parseDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Strict date parsing
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }


    
    public void bookingOperations() {
        while (true) {
            System.out.println("Press 1. Add Booking Details\nPress 2. Retrieve All Booking Data\n"
                    + "Press 3. Update Booking Data\nPress 4. Delete Booking Data\n"
                    + "Press 5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (input) {
                case 1:
                    Booking booking = bookingInputs();
                    Booking savedBooking = bookingServices.createCustomerBooking(booking);
                    System.out.println("Booking Data has been saved successfully: " + savedBooking);
                    break;

                case 2:
                    List<Booking> bookings = bookingServices.getAllBookings();
                    if (bookings == null || bookings.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        for (Booking b : bookings) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Booking ID to update the information:");
                    String bId = sc.nextLine();
                    Booking existingBooking = bookingServices.getBooking(bId);
                    if (existingBooking != null) {
                        Booking updatedBooking = updatedBookingData(existingBooking);
                        Booking updatedInfo = bookingServices.updateBooking(bId, updatedBooking);
                        System.out.println("Booking Data has been updated successfully: " + updatedInfo);
                    } else {
                        System.out.println("Booking ID not found");
                    }
                    break;


                case 4:
                    System.out.println("Enter Booking ID to delete the information:");
                    String id = sc.nextLine();
                    String message = bookingServices.deleteBooking(id);
                    System.out.println(message);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }


    public Booking bookingInputs() {
        System.out.println("Enter Booking ID:");
        String bookingId = sc.nextLine();

        System.out.println("Enter Customer ID:");
        String customerId = sc.nextLine();

        System.out.println("Enter Travel Package ID:");
        String packageId = sc.nextLine();

        System.out.println("Enter Booking Date (YYYY-MM-DD):");
        String bookingDateStr = sc.nextLine();

        Date bookingDate = Booking.parseDate(bookingDateStr); // Call the static method
        if (bookingDate == null) {
            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            return null;
        }

        Customer customer = customerServices.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return null;
        }

        TourPackage travelPackage = tourPackageServices.getTourPackage(packageId);
        if (travelPackage == null) {
            System.out.println("Tour Package not found.");
            return null;
        }

        return new Booking(bookingId, bookingDate, travelPackage, customer);
    }
    
    
    
    public void tourPackageOperations() {
        while (true) {
            System.out.println("Press 1. Add Tour Package\nPress 2. Retrieve All Tour Packages\n"
                    + "Press 3. Update Tour Package\nPress 4. Delete Tour Package\n"
                    + "Press 5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (input) {
                case 3:
                    System.out.println("Enter Tour Package ID to update the information:");
                    String packageId = sc.nextLine();
                    TourPackage existingPackage = tourPackageServices.getTourPackage(packageId);
                    if (existingPackage != null) {
                        TourPackage updatedPackage = tourPackageInputs(); // Reuse the inputs method to update
                        TourPackage updatedInfo = tourPackageServices.updateTourPackage(packageId, updatedPackage);
                        System.out.println("Tour Package has been updated successfully: " + updatedInfo);
                    } else {
                        System.out.println("Tour Package ID not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Tour Package ID to delete the information:");
                    String id = sc.nextLine();
                    String message = tourPackageServices.deleteTourPackage(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Exits the method, returning to the main menu

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    
    // Helper method to collect TourPackage inputs
    private TourPackage tourPackageInputs() {
        System.out.println("Enter Tour Package ID:");
        String id = sc.nextLine();

        System.out.println("Enter Customer ID:");
        String customerid = sc.nextLine();
        
        System.out.println("Enter Tour Package Name:");
        String name = sc.nextLine();

        System.out.println("Enter Tour Package Description:");
        String description = sc.nextLine();

        System.out.println("Enter Tour Package Price:");
        double price = 0.0;
        boolean validPrice = false;

        while (!validPrice) {
            try {
                price = sc.nextDouble();
                sc.nextLine(); // Consume newline
                validPrice = true; // Price entered successfully
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number for the price.");
                sc.nextLine(); // Consume invalid input
            }
        }

        return new TourPackage(id, customerid, name, description, price); // Match the constructor
    }

    
    
    public void hotelOperations() {
        while (true) {
            System.out.println("Press 1. Add Hotel Details\nPress 2. Retrieve All Hotel Data\n"
                    + "Press 3. Update Hotel Data\nPress 4. Delete Hotel Data\n"
                    + "Press 5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (input) {
                case 1:
                    Hotel hotel = hotelInputs();
                    Hotel savedHotel = hotelServices.createHotel(hotel);
                    System.out.println("Hotel Data has been saved successfully: " + savedHotel);
                    break;

                case 2:
                    List<Hotel> hotels = hotelServices.getAllHotels();
                    if (hotels == null || hotels.isEmpty()) {
                        System.out.println("No hotels found.");
                    } else {
                        for (Hotel h : hotels) {
                            System.out.println(h);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Hotel ID to update the information:");
                    String hotelId = sc.nextLine();
                    Hotel existingHotel = hotelServices.getHotel(hotelId);
                    if (existingHotel != null) {
                        Hotel updatedHotel = hotelInputs(); // Reuse inputs method to update the hotel
                        Hotel updatedInfo = hotelServices.updateHotel(hotelId, updatedHotel);
                        System.out.println("Hotel Data has been updated successfully: " + updatedInfo);
                    } else {
                        System.out.println("Hotel ID not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Hotel ID to delete the information:");
                    String id = sc.nextLine();
                    String message = hotelServices.deleteHotel(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Exit to the main menu

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }



    public void mainOps() {
        while (true) {
            System.out.println("Main Operations Menu:");
            System.out.println("1. Customer Operations");
            System.out.println("2. Booking Operations");
            System.out.println("3. Travel Package Operations");
            System.out.println("4. Hotel Operations");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    customerOperations();
                    break;
                case 2:
                    bookingOperations();
                    break;
                case 3:
                    tourPackageOperations();
                    break;
                case 4:
                    hotelOperations();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        AllOperations ops = new AllOperations();
        ops.mainOps(); // Run the main operations
        sc.close();    // Close Scanner after the operations end
    }
}


