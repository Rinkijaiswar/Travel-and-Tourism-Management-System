package com.Customer.services;

import java.util.List;

import com.Customer.entity.Hotel;
import com.Customer.entity.Booking;

public interface HotelServices {
    // Create a new hotel
    Hotel createHotel(Hotel hotel);
    
    // Retrieve a hotel by its ID
    Hotel getHotel(String hotelId);
    
    // Retrieve all hotels
    List<Hotel> getAllHotels();
    
    // Update an existing hotel
    Hotel updateHotel(String hotelId, Hotel updatedHotel);
    
    // Delete a hotel by its ID
    String deleteHotel(String hotelId);
    
    // Retrieve all bookings associated with a hotel ID
    List<Booking> getBookingsByHotelId(String hotelId);
}
