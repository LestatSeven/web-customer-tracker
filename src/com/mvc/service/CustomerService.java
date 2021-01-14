package com.mvc.service;

import com.mvc.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);
}
