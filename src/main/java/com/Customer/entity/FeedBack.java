package com.Customer.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    @Column(length = 20)
    private String instructorName;

    @Column(length = 100)
    private String feedback;

    @Temporal(TemporalType.DATE)
    private Date feedbackDate = new Date();

    // One customer can give many feedbacks
    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FeedBack(String instructorName, String feedback, Customer customer) {
        super();
        this.instructorName = instructorName;
        this.feedback = feedback;
        this.customer = customer;
    }

    public FeedBack() {
        super();
    }

    @Override
    public String toString() {
        return "Feedback [feedbackId=" + feedbackId + ", instructorName=" + instructorName + ", feedback=" + feedback
                + ", feedbackDate=" + feedbackDate + ", customer=" + customer + "]";
    }
}
