package com.thenxt.app.serviceimpl;

import com.thenxt.app.dto.CustomerRequestDTO;
import com.thenxt.app.entity.Customer;
import com.thenxt.app.exception.ResourceNotFoundException;
import com.thenxt.app.repository.CustomerRepository;
import com.thenxt.app.repository.OrderRepository;
import com.thenxt.app.service.CustomerService;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Customer addCustomer(CustomerRequestDTO requestDTO) {
        Customer customer = Customer.builder()
                .name(requestDTO.getName())
                .address(requestDTO.getAddress())
                .phone(requestDTO.getPhone())
                .email(requestDTO.getEmail())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer Not Exist whit id :" + id));
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);

    }
}
