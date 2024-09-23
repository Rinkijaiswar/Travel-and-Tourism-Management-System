package com.Customer.daoimp;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.Customer.Dao.FeedBackDao;
import com.Customer.entity.FeedBack;
import com.Customer.entity.Customer;
import com.Customer.util.HibernateUtil;

public class FeedBackDaoImp implements FeedBackDao{

	@Override
	public Customer getCustomer(String customerID) {
	try(Session session=HibernateUtil.getSession()) {
			
		Customer customer=session.get(Customer.class, customerID);
			return customer;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public FeedBack createFeedBack(FeedBack feedBack) {
		
		try(Session session=HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(feedBack);
			session.getTransaction().commit();
			return feedBack;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}



}
