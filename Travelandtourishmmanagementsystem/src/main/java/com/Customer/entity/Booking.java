package com.Customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Booking {
    @Id
    private String bookingId;
    
    private Date bookingDate;
    
    @ManyToOne
    private TourPackage tourPackage;
    
    @ManyToOne
    private Customer customer;

    // No-argument constructor
    public Booking() {}

    // Constructor
    public Booking(String bookingId, Date bookingDate, TourPackage tourPackage, Customer customer) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.tourPackage = tourPackage;
        this.customer = customer;
    }

    // Getter and Setter for bookingId
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    
    // Getter and Setter for bookingDate
    public Date getBookingDate() {
        return bookingDate;
    }
    
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    // Getter and Setter for tourPackage
    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }
    
    // Getter and Setter for customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", tourPackage=" + tourPackage + ", customer=" + customer + "]";
    }
    
    // Static method to parse date from string
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
