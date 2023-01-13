package com.example.jpa.service;

import com.example.jpa.repository.CustomerRepository;
import com.example.jpa.repository.model.Customer;
import org.springframework.data.domain.*;
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

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public void deleteAll() {
        System.out.println("deleting all:");
        repository.deleteAll();
    }

    public List<Customer> findAllByOrderByHeightInCmDesc() {
        return repository.findAllByOrderByHeightInCmDesc();
    }

    public List<Customer> findByActive(Boolean isActive) {
        return repository.findByActive(isActive);
    }

    public List<Customer> findFirst2ByName(String name) {
        return repository.findFirst2ByName(name);
    }

    public List<Customer> findByNameIn(List<String> name) {
        return repository.findByNameIn(name);
    }

    public List<Customer> findByNames(String name1, String name2) {
        return repository.findByNames(name1, name2);
    }

    public List<Customer> findAllByPage(int pageNumber, int pageSize) {
        final Page<Customer> customersPage = repository.findAll(PageRequest.of(pageNumber, pageSize));
        return customersPage.getContent();
    }
}
