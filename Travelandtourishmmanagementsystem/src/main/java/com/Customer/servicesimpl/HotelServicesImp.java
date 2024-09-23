package com.Customer.servicesimpl;

import com.Customer.Dao.HotelDao;
import com.Customer.daoimp.HotelDaoImp;
import com.Customer.entity.Hotel;
import com.Customer.entity.Booking;
import com.Customer.services.HotelServices;

import java.util.List;

public class HotelServicesImp implements HotelServices {

    private HotelDao hotelDao = new HotelDaoImp();

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelDao.createHotel(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelDao.getHotel(hotelId);
    }

    @Override
    public List<Hotel> getAllHotels() {
        // Ensure that this method exists in HotelDao and HotelDaoImp
        return hotelDao.getAllHotels();
    }

    @Override
    public Hotel updateHotel(String hotelId, Hotel updatedHotel) {
        // Ensure that this method exists in HotelDao and HotelDaoImp
        return hotelDao.updateHotel(hotelId, updatedHotel);
    }

    @Override
    public String deleteHotel(String hotelId) {
        // Ensure that this method exists in HotelDao and HotelDaoImp
        return hotelDao.deleteHotel(hotelId);
    }

    @Override
    public List<Booking> getBookingsByHotelId(String hotelId) {
        // Ensure that this method exists in HotelDao and HotelDaoImp
        return hotelDao.getBookingsByHotelId(hotelId);
    }
}
