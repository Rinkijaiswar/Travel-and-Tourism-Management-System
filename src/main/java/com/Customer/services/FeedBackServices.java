// FeedBackServices.java
package com.Customer.services;

import com.Customer.entity.FeedBack;
import com.Customer.entity.Customer;

public interface FeedBackServices {
    Customer getCustomer(String customerID);
    FeedBack createFeedBack(FeedBack feedBack);
}
