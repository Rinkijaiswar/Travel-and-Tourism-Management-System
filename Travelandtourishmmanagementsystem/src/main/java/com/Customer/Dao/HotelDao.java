package com.Customer.Dao;

import com.Customer.entity.Hotel;
import com.Customer.entity.Booking;

import java.util.List;

public interface HotelDao {
    Hotel createHotel(Hotel hotel);
    Hotel getHotel(String hotelId);
    List<Hotel> getAllHotels(); // Method should exist
    Hotel updateHotel(String hotelId, Hotel updatedHotel); // Method should exist
    String deleteHotel(String hotelId); // Method should exist
    List<Booking> getBookingsByHotelId(String hotelId); // Method should exist
}
