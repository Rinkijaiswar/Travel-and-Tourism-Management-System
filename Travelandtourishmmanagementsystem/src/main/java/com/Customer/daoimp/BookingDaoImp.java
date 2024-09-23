package com.Customer.daoimp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Customer.Dao.BookingDao;
import com.Customer.entity.Booking;
import com.Customer.util.HibernateUtil;

public class BookingDaoImp implements BookingDao {

    @Override
    public Booking createBooking(Booking booking) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(booking);
            transaction.commit();
            return booking;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Booking getBooking(String bookingId) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Booking.class, bookingId);
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteBooking(String bookingId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Booking booking = session.get(Booking.class, bookingId);
            if (booking != null) {
                session.delete(booking);
                transaction.commit();
                return "Booking deleted";
            } else {
                return "Booking not found";
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e);
        }
        return "Error occurred";
    }
}
