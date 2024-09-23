package com.Customer.services;

import com.Customer.entity.Booking;
import java.util.List;
import com.Customer.entity.*;

public interface BookingServices {
    Booking createCustomerBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBooking(String id);
    TourPackage getTourPackage(String packageId);
    Booking updateBooking(String id, Booking booking);
    String deleteBooking(String id);
    List<Booking> getBookingsByCustomerId(String customerId);
    List<Booking> getBookingsByTravelPackageId(String travelPackageId);
}
