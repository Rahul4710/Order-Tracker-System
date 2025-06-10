package com.thenxt.app.service;

import com.thenxt.app.dto.CustomerRequestDTO;
import com.thenxt.app.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(CustomerRequestDTO requestDTO);

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    void deleteCustomer(Long id);
}
