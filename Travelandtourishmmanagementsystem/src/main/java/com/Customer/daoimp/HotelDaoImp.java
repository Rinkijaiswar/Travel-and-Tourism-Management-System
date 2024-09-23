package com.Customer.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Customer.Dao.HotelDao;
import com.Customer.entity.Booking;
import com.Customer.entity.Hotel;
import com.Customer.util.HibernateUtil;

public class HotelDaoImp implements HotelDao {

    @Override
    public Hotel createHotel(Hotel hotel) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(hotel);
            session.getTransaction().commit();
            return hotel;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Hotel getHotel(String hotelID) {
        try (Session session = HibernateUtil.getSession()) {
            Hotel hotel = session.get(Hotel.class, hotelID);
            return hotel;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel updateHotel(String hotelId, Hotel updatedHotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteHotel(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> getBookingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
}
