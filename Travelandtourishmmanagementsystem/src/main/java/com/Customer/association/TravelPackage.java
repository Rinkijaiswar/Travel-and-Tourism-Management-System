package com.Customer.association;

import javax.persistence.*;

@Entity
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    private String gold;
    private String silver;
    private String bronze;

    // Default constructor
    public TravelPackage() {
    }

    // Parameterized constructor
    public TravelPackage(String gold, String silver, String bronze) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    // Getters and setters
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getBronze() {
        return bronze;
    }

    public void setBronze(String bronze) {
        this.bronze = bronze;
    }

    // toString method
    @Override
    public String toString() {
        return "TravelPackage{" +
                "packageId=" + packageId +
                ", gold='" + gold + '\'' +
                ", silver='" + silver + '\'' +
                ", bronze='" + bronze + '\'' +
                '}';
    }
}
