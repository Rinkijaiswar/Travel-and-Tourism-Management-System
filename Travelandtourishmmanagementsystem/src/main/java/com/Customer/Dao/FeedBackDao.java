package com.Customer.Dao;

import com.Customer.entity.FeedBack;
import com.Customer.entity.Customer;

public interface FeedBackDao {

    Customer getCustomer(String customerID);
    FeedBack createFeedBack(FeedBack feedBack);

}
