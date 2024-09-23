package com.Customer.daoimp;


import java.util.List;
import org.hibernate.Session;
import com.Customer.Dao.CustomerDao;
import com.Customer.entity.Customer;
import com.Customer.entity.Booking;
import com.Customer.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class CustomerDaoImp implements CustomerDao  {
	
	@Override
    public Booking createCustomerBooking(Booking booking) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(booking);
            session.getTransaction().commit();
            return booking;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	 @Override
	    public Customer getCustomerById(String customerId) {
	        try (Session session = HibernateUtil.getSession()) {
	            return session.get(Customer.class, customerId); // Fetching customer by ID
	        } catch (HibernateException e) {
	            System.out.println(e);
	        }
	        return null;
	    }


    @Override
    public Customer createCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Customer getCustomer(String customerId) {
	    try (Session session = HibernateUtil.getSession()) {
	        return session.get(Customer.class, customerId);
	    } catch (HibernateException e) {
	        System.out.println(e);
	    }
	    return null;
	}

	
	@Override
	public List<Booking> getBookingDetailsByTravelPackageId(String travelPackageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateCustomer(String customerID, Customer updatedCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(String customerID) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSession()) {
	        transaction = session.beginTransaction();
	        Customer customer = session.get(Customer.class, customerID);
	        if (customer != null) {
	            session.delete(customer);
	            transaction.commit();
	            return "Customer deleted";
	        } else {
	            return "Customer not found";
	        }
	    } catch (HibernateException e) {
	        if (transaction != null) transaction.rollback();
	        System.out.println(e);
	    }
	    return "Error occurred";
	}


    // Other methods
}
