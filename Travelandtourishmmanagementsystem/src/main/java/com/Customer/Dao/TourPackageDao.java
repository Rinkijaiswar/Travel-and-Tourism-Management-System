package com.Customer.Dao;

import com.Customer.entity.TourPackage;
import java.util.List;

public interface TourPackageDao {

    // Create a new tour package
    TourPackage createTourPackage(TourPackage tourPackage);

    // Retrieve a tour package by its ID
    TourPackage getTourPackage(String packageID);

    // Retrieve all tour packages
    List<TourPackage> getAllTourPackages();

    // Update an existing tour package
    TourPackage updateTourPackage(String packageID, TourPackage updatedTourPackage);

    // Delete a tour package by its ID
    String deleteTourPackage(String packageID);
}
