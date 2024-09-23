package com.Customer.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

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
            // Create TravelPackage objects
            TravelPackage travelPackage1 = new TravelPackage("Gold Package", "Silver Package", "Bronze Package");
            

            // Create TravelAdmin objects
            TravelAdmin adm1 = new TravelAdmin("A111", "Dhruv", 67000, travelPackage1);
            TravelAdmin adm2 = new TravelAdmin("E112", "Guru", 80000, travelPackage1);

            // Save TravelAdmin objects (and the embedded TravelPackage will be saved automatically due to CascadeType.ALL)
            session.save(adm1);
            session.save(adm2);

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
