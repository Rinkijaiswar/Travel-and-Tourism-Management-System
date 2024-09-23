package com.Customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private String customerid;
    
    private String tourpackageid;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;

    // No-argument constructor
    public Customer() {}

    // Constructor
    public Customer(String customerid,String tourpackageid, String firstName, String lastName, String gender, String email, String phoneNumber) {
        this.customerid = customerid;
        this.tourpackageid = tourpackageid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getId() {
        return customerid;
    }

    public void setId(String id) {
        this.customerid = customerid;
    }
    
    public String get() {
        return tourpackageid;
    }

    public void settourpackageid(String id) {
        this.tourpackageid = tourpackageid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Method to get the full name
    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Customer [customerid=" + customerid + ",tourpackageid = " + tourpackageid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }
}
