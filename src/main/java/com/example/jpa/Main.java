package com.example.jpa;

import com.example.jpa.repository.model.Customer;
import com.example.jpa.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {

    private final CustomerService customerService;

    public Main(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void run() {
        System.out.println("===========================");
        System.out.println("Create 5 customers");
        List<Customer> customers = List.of(
                new Customer("Bob", true, 18, 170),
                new Customer("Paul", true, 21, 175),
                new Customer("John", false, 25, 180),
                new Customer("John", false, 27, 187),
                new Customer("John", true, 28, 188),
                new Customer("John", false, 26, 181),
                new Customer("Marc", false, 31, 185)
        );
        customers.forEach(customerService::create);

        System.out.println("===========================");
        System.out.println("Names are Paul and John IN");
        customerService.findByNameIn("Paul", "John").forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Names are Paul and John @QUERY");
        customerService.findByNames("Paul", "John").forEach(System.out::println);

        /*System.out.println("===========================");
        System.out.println("Find all ordered by height");
        customerService.findAllOrderedByHeight().forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Find all by active");
        customerService.findAllByActive(true).forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Find all top 2 by name = John");
        customerService.findTop2ByName("John").forEach(System.out::println);

        var cust = customerService.create(new Customer("Luigi", true, 36, 190));

        System.out.println("===========================");
        System.out.println("Find all");
        customerService.findAll().forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Find by ID");
        System.out.println(customerService.findById(cust.getId()));

        System.out.println("===========================");
        System.out.println("Update by ID");
        System.out.println(customerService.updateById(cust.getId(),
                new Customer("Mario", false, 15, 55)));

        System.out.println("===========================");
        System.out.println("Delete by ID");
        customerService.deleteById(cust.getId());
        System.out.println("===========================");
        System.out.println("Find all");
        customerService.findAll().forEach(System.out::println);

        System.out.println("===========================");
        System.out.println("Delete all");
        customerService.deleteAll();
        System.out.println("===========================");
        System.out.println("Find all");
        System.out.println(customerService.findAll());*/
    }

}