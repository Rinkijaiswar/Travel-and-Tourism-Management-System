package com.Customer.servicesimpl;

import com.Customer.entity.Booking;
import com.Customer.entity.TourPackage;
import com.Customer.services.TourPackageservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TourPackageservicesImp implements TourPackageservices {

    private Map<String, TourPackage> tourPackageDatabase = new HashMap<>();

    @Override
    public TourPackage createTourPackage(TourPackage tourPackage) {
        if (tourPackage != null && tourPackage.getpackageId() != null) {
            tourPackageDatabase.put(tourPackage.getpackageId(), tourPackage);
            return tourPackage;
        }
        return null;
    }

    @Override
    public List<TourPackage> getAllTourPackages() {
        return new ArrayList<>(tourPackageDatabase.values());
    }

    @Override
    public TourPackage getTourPackage(String id) {
        return tourPackageDatabase.get(id);
    }

    @Override
    public TourPackage updateTourPackage(String id, TourPackage tourPackage) {
        if (tourPackageDatabase.containsKey(id)) {
            tourPackageDatabase.put(id, tourPackage);
            return tourPackage;
        }
        return null;
    }

    @Override
    public String deleteTourPackage(String packageid) {
        if (tourPackageDatabase.containsKey(packageid)) {
            tourPackageDatabase.remove(packageid);
            return "Tour package removed successfully";
        }
        return "Tour package not found";
    }

    @Override
    public List<Booking> getBookingsByTourPackageId(String tourPackageId) {
        // Placeholder implementation
        // You need to implement the logic to retrieve bookings based on tourPackageId
        // This could involve another service or DAO to fetch the bookings related to the package
        return new ArrayList<>();
    }
}
