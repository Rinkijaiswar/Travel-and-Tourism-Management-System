package com.Customer;

import com.Customer.entity.Customer;
import com.Customer.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        // Obtain a Hibernate SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // Create a new Customer with correct data types
        Customer customer1 = new Customer("C113", "101", "Oliver", "Henry", "Male", "oliver@gmail.com", "6742906745");

        Transaction transaction = null;
        
        try (Session session = factory.openSession()) {
            // Begin transaction
            transaction = session.beginTransaction();

            try {
                // Save customer to the database
                session.save(customer1);
                transaction.commit();
                System.out.println("Customer saved successfully.");
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                    System.out.println("Transaction rolled back.");
                }
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error opening session: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();  // Close the SessionFactory
        }
    }
}
