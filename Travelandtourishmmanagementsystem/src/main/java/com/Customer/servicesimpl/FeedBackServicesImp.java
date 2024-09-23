package com.Customer.servicesimpl;

import com.Customer.Dao.FeedBackDao;
import com.Customer.daoimp.FeedBackDaoImp;
import com.Customer.entity.FeedBack;
import com.Customer.entity.Customer;
import com.Customer.services.FeedBackServices;

public class FeedBackServicesImp implements FeedBackServices {

    private FeedBackDao feedBackDao = new FeedBackDaoImp();
    
    @Override
    public Customer getCustomer(String customerID) {
        return feedBackDao.getCustomer(customerID);
    }

    @Override
    public FeedBack createFeedBack(FeedBack feedBack) {
        return feedBackDao.createFeedBack(feedBack);
    }
}
