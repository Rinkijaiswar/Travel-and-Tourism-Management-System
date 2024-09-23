package com.Customer.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {

    public static void main(String[] args) {
        // Create Hibernate SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(TravelAdmin.class)
                .addAnnotatedClass(TravelPackage.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.openSession();

        // Begin transaction
        Transaction tx = session.beginTransaction();

        try {
            // Create a TravelPackage object
            TravelPackage travelPackage1 = new TravelPackage("Gold Package", "Silver Package", "Bronze Package");

            // Create a TravelAdmin object with embedded TravelPackage
            TravelAdmin admin1 = new TravelAdmin("A111", "Dhruv", 70000, travelPackage1);

            // Save the TravelAdmin object (and the embedded TravelPackage will be saved automatically)
            session.save(admin1);

            // Commit transaction
            tx.commit();
            System.out.println("TravelAdmin and TravelPackage saved successfully!");

        } catch (Exception e) {
            // Rollback transaction if there's an exception
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close session and session factory
            session.close();
            factory.close();
        }
    }
}
