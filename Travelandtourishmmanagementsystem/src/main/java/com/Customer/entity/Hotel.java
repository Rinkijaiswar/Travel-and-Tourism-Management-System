package com.Customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Hotel {

    @Id
    @Column(name = "HotelId")
    private String id; // Primary key

    @Column(length = 100)
    private String name;

    @Column
    private double price;

    @Column(length = 255)
    private String address;

    @Column(length = 15)
    private String contactNumber;

    @Column(length = 50)
    private String city;

    // No-argument constructor
    public Hotel() {}

    // Parameterized constructor
    public Hotel(String id, String name, double price, String address, String contactNumber, String city) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
        this.contactNumber = contactNumber;
        this.city = city;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", price=" + price + ", address=" + address 
                + ", contactNumber=" + contactNumber + ", city=" + city + "]";
    }
}
