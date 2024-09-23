package com.Customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import java.util.Date;

@Entity
public class PaymentProcessor {
    @Id
    private String id;

    @Column(length = 10)
    private String paymentId;

    @Column(nullable = false)
    private double amount;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(length = 20, nullable = false)
    private String paymentMethod;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "TourPackageID", nullable = false)
    private TourPackage tourPackage;

    // Default constructor
    public PaymentProcessor() {}

    // Parameterized constructor
    public PaymentProcessor(String id, String paymentId, double amount, Date paymentDate, String paymentMethod, Customer customer, TourPackage travelPackage) {
        this.id = id;
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.customer = customer;
        this.tourPackage = travelPackage;
    }

    // Getters and Setters
    // ...

    @Override
    public String toString() {
        return "PaymentProcessor [id=" + id + ", paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + paymentDate
                + ", paymentMethod=" + paymentMethod + ", customer=" + customer + ", travelPackage=" + tourPackage + "]";
    }
}
