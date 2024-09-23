package com.Customer.servicesimpl;

import com.Customer.services.BookingServices;
import com.Customer.entity.Booking;
import com.Customer.exception.BookingNotFoundException;
import com.Customer.services.*;
import com.Customer.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingServicesImp implements BookingServices {

    // Thread-safe map for bookings
    private TourPackageservices tourPackageServices;
    private Map<String, Booking> bookingDatabase = new ConcurrentHashMap<>();

    @Override
    public Booking createCustomerBooking(Booking booking) {
        if (booking == null || booking.getBookingId() == null) {
            throw new IllegalArgumentException("Booking and Booking ID cannot be null");
        }

        bookingDatabase.put(booking.getBookingId(), booking);
        return booking;
    }
    public TourPackage getTourPackage(String packageId) {
        // Implement logic to retrieve the TourPackage by ID
        return tourPackageServices.getTourPackage(packageId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookingDatabase.values());
    }

    @Override
    public Booking getBooking(String id) {
        if (id == null || !bookingDatabase.containsKey(id)) {
            throw new BookingNotFoundException("Booking ID is invalid or does not exist");
        }

        return bookingDatabase.get(id);
    }

    @Override
    public Booking updateBooking(String id, Booking booking) {
        if (id == null || booking == null || !bookingDatabase.containsKey(id)) {
            throw new BookingNotFoundException("Invalid Booking ID or Booking information");
        }

        bookingDatabase.put(id, booking); // Updates the booking in the map
        return booking;
    }

    @Override
    public String deleteBooking(String id) {
        if (id == null || !bookingDatabase.containsKey(id)) {
            return "Booking not found";
        }

        bookingDatabase.remove(id);
        return "Booking removed successfully";
    }

    @Override
    public List<Booking> getBookingsByCustomerId(String customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        List<Booking> bookings = new ArrayList<>();
        for (Booking booking : bookingDatabase.values()) {
            if (booking.getCustomer() != null && customerId.equals(booking.getCustomer().getId())) {
                bookings.add(booking);
            }
        }

        return bookings;
    }

    @Override
    public List<Booking> getBookingsByTravelPackageId(String travelPackageId) {
        if (travelPackageId == null) {
            throw new IllegalArgumentException("Travel Package ID cannot be null");
        }

        List<Booking> bookings = new ArrayList<>();
        for (Booking booking : bookingDatabase.values()) {
            if (booking.getTourPackage() != null && travelPackageId.equals(booking.getTourPackage().getpackageId())) {
                bookings.add(booking);
            }
        }


        return bookings;
    }
}
