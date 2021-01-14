package com.mvc.dao;

import com.mvc.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);
}
