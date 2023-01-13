package com.example.jpa.service;

import com.example.jpa.repository.CustomerRepository;
import com.example.jpa.repository.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> findByNameIn(String name1, String name2) {
        return repository.findByNameIn(List.of(name1, name2));
    }

    public List<Customer> findAllOrderedByHeight() {
        return repository.findAllByOrderByHeightInCmDesc();
    }

    public List<Customer> findAllByActive(boolean active) {
        return repository.findAllByActive(active);
    }

    public List<Customer> findTop2ByName(String name) {
        return repository.findTop2ByName(name);
    }

    public List<Customer> findByNames(String name1, String name2) {
        return repository.findByNames(name1, name2);
    }

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Customer updateById(Long id, Customer customer) {
        Customer customerToUpdate = findById(id);

        customerToUpdate.setActive(customer.isActive());
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setHeightInCm(customer.getHeightInCm());

        return repository.save(customerToUpdate);
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
