package com.Customer.services;

import com.Customer.entity.TourPackage;
import com.Customer.entity.Booking;
import java.util.List;

public interface TourPackageservices {

    // Create a new tour package
    TourPackage createTourPackage(TourPackage tourPackage);
    

    // Retrieve all tour packages
    List<TourPackage> getAllTourPackages();

    // Retrieve a tour package by its ID
    TourPackage getTourPackage(String packageId);

    // Update an existing tour package
    TourPackage updateTourPackage(String packageId, TourPackage tourPackage);

    // Delete a tour package by its ID
    String deleteTourPackage(String packageId);

    // Retrieve bookings by tour package ID
    
    List<Booking> getBookingsByTourPackageId(String packageId);
}
