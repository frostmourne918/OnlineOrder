package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.CustomerDao;
import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    //这里用到了Spring的Dependency Injection的Field Injection的方法
    //不需要再new class
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        customer.setEnabled(true);

        Cart cart = new Cart();
        customer.setCart(cart);

        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }
}
