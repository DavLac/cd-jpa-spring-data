package com.example.jpa;

import com.example.jpa.repository.model.Customer;
import com.example.jpa.service.CustomerService;
import org.springframework.stereotype.Component;

@Component
public class Main {

    private final CustomerService customerService;

    public Main(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void run() {
        try {
            printLine("create 5 customers");
            customerService.create(new Customer("Adam", false, 25, 170));
            customerService.create(new Customer("Bob", true, 27, 175));
            customerService.create(new Customer("Clark", false, 29, 180));
            customerService.create(new Customer("Dave", true, 31, 185));
            Customer customer = customerService.create(new Customer("Eric", false, 33, 190));

            printLine("find all");
            customerService.findAll().forEach(System.out::println);
            printLine("find one by id");
            System.out.println(customerService.findById(customer.getId()));

            //System.out.println(customerService.findById(16L));

            printLine("update 1");
            System.out.println(customerService.findById(customer.getId()));
            customerService.updateNameById(customer.getId(), new Customer("Eddie", false, 33, 190));
            System.out.println(customerService.findById(customer.getId()));
            printLine("delete by id");
            System.out.println(customerService.findById(customer.getId()));
            //customerService.deleteById(customer.getId());
            System.out.println(customerService.findById(customer.getId()));

            printLine("delete all");
            customerService.findAll().forEach(System.out::println);
            customerService.deleteAll();
            customerService.findAll().forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public void printLine(String string) {
        System.out.println("==========================[ " + string + " ]==========================");
    }

}
