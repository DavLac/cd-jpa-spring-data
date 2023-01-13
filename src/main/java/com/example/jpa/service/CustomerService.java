package com.example.jpa.service;

import com.example.jpa.repository.CustomerRepository;
import com.example.jpa.repository.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<Customer> findAllByPage(int pageNumber, int pageSize) {
        final Page<Customer> customersPage = repository.findAll(PageRequest.of(pageNumber, pageSize));
        return customersPage.getContent();
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

    @Transactional
    public void everybodyGetOlder() {
        List<Customer> customers = findAll();

        int failingCounter = 0;
        for (Customer customer : customers) {
            if (failingCounter == 2) {
                throw new RuntimeException("nope");
            }
            customer.setAge(customer.getAge() + 1);
            repository.save(customer);
            failingCounter++;
        }
    }

    public void deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
