package com.Customer;

import com.Customer.entity.Booking;
import com.Customer.entity.Hotel;
import com.Customer.services.BookingServices;
import com.Customer.servicesimpl.BookingServicesImp;
import com.Customer.servicesimpl.CustomerServicesImp;
import com.Customer.servicesimpl.TourPackageservicesImp;
import com.Customer.servicesimpl.HotelServicesImp;

import java.util.List;
import java.util.Scanner;

import org.slf4j.LoggerFactory;


public class MainOperation {

    private static Scanner sc = new Scanner(System.in);
    

    // Instantiate services
    private static CustomerServicesImp customerServices = new CustomerServicesImp();
    private static BookingServicesImp bookingServices = new BookingServicesImp();
    private static TourPackageservicesImp travelPackageServices = new TourPackageservicesImp();
    private static HotelServicesImp hotelServices = new HotelServicesImp();

    // Create an instance of AllOperations
    private static AllOperations allOps = new AllOperations();

    public static void mainOps() {
        while (true) {
            System.out.println("WELCOME To TOURS AND TRAVEL MANAGEMENT SYSTEM");

            System.out.println("Press 1. Customer Operations");
            System.out.println("Press 2. Booking Operations");
            System.out.println("Press 3. Travel Package Operations");
            System.out.println("Press 4. Hotel Operations");
            System.out.println("Press 5. Get Bookings by Travel Package");
            System.out.println("Press 6. Quit");

            int input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (input) {
                case 1:
                    CustomerOperations();
                    break;

                case 2:
                    BookingOperations();
                    break;

                case 3:
                    TourPackageOperations();
                    break;

                case 4:
                    HotelOperations();
                    break;

                case 5:
                    List<Booking> bookings = getBookingsByTravelPackage();
                    if (bookings.isEmpty()) {
                        System.out.println("No bookings found for the given travel package.");
                    } else {
                        for (Booking b : bookings) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
    	
        mainOps();
      
    }

    private static void CustomerOperations() {
        allOps.customerOperations(); // Using instance of AllOperations
    }

    private static void BookingOperations() {
        allOps.bookingOperations(); // Using instance of AllOperations
    }

    private static void createBooking() {
        Booking booking = allOps.bookingInputs(); // Collect inputs for booking
        Booking savedBooking = bookingServices.createCustomerBooking(booking);

        if (savedBooking != null) {
            System.out.println("Booking created successfully: " + savedBooking);
        } else {
            System.out.println("Error in booking process.");
        }
    }

    private static void TourPackageOperations() {
        allOps.tourPackageOperations(); // Using instance of AllOperations
    }

    private static void HotelOperations() {
        while (true) {
            System.out.println("Hotel Operations:");
            System.out.println("1. Add Hotel");
            System.out.println("2. Retrieve All Hotels");
            System.out.println("3. Update Hotel");
            System.out.println("4. Delete Hotel");
            System.out.println("5. Back to Main Menu");

            int input = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (input) {
                case 1:
                    Hotel hotel = allOps.hotelInputs(); // Collect inputs for hotel
                    Hotel savedHotel = hotelServices.createHotel(hotel);
                    System.out.println("Hotel added successfully: " + savedHotel);
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
                    System.out.println("Enter Hotel ID to update:");
                    String hId = sc.nextLine();
                    Hotel existingHotel = hotelServices.getHotel(hId);
                    if (existingHotel != null) {
                        Hotel updatedHotel = allOps.hotelInputs(); // Reuse inputs method
                        Hotel updatedInfo = hotelServices.updateHotel(hId, updatedHotel);
                        System.out.println("Hotel updated successfully: " + updatedInfo);
                    } else {
                        System.out.println("Hotel ID not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Hotel ID to delete:");
                    String id = sc.nextLine();
                    String message = hotelServices.deleteHotel(id);
                    System.out.println(message);
                    break;

                case 5:
                    return; // Back to the main menu

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static List<Booking> getBookingsByTravelPackage() {
        System.out.println("Enter Travel Package ID:");
        String travelPackageId = sc.nextLine();
        return bookingServices.getBookingsByTravelPackageId(travelPackageId);
    }
}
