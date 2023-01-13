package com.example.jpa.service;

import com.example.jpa.repository.CustomerRepository;
import com.example.jpa.repository.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Customer updateNameById(Long id, Customer customer) {
        Customer custToBeUpdated = findById(id);
        custToBeUpdated.setName(customer.getName());
        custToBeUpdated.setActive(customer.isActive());
        custToBeUpdated.setAge(customer.getAge());
        custToBeUpdated.setHeightInCm(customer.getHeightInCm());
        return repository.save(custToBeUpdated);
    }
    public void deleteById(Long id){
        findById(id);
        repository.deleteById(id);
    }
    public void deleteAll(){
        System.out.println("deleting all:");
        repository.deleteAll();
    }
}
