package com.Customer.Dao;


import com.Customer.entity.Booking;

public interface BookingDao {
	
	Booking createBooking(Booking booking);
    Booking getBooking(String bookingId);
    String deleteBooking(String bookingId);

    

}
