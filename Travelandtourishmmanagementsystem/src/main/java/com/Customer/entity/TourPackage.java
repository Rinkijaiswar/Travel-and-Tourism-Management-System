package com.Customer.entity;

public class TourPackage {
    private String packageid;
    private String customerId; // Assuming you meant to associate with a customer
    private String name;
    private String description;
    private double price;

    // Constructor
    public TourPackage(String packageid, String customerId, String name, String description, double price) {
        this.packageid = packageid;
        this.customerId = customerId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public String getpackageId() { return packageid; }
    public void setId(String packageid) { this.packageid = packageid; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "TourPackage [packageid=" + packageid + ", customerId=" + customerId + ", name=" + name + ", description=" + description + ", price=" + price + "]";
    }
}
