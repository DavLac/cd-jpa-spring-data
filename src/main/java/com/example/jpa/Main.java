package com.example.jpa;

import com.example.jpa.repository.model.Customer;
import com.example.jpa.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
            customerService.create(new Customer("Fred", false, 33, 195));
            customerService.create(new Customer("George", true, 35, 200));
            customerService.create(new Customer("Hank", false, 37, 205));
            customerService.create(new Customer("Ingmar", false, 39, 210));
            customerService.create(new Customer("Joe", true, 41, 215));
            customerService.create(new Customer("Kurt", false, 43, 220));
            customerService.create(new Customer("Liam", true, 45, 225));
            customerService.create(new Customer("Mark", false, 47, 230));
            customerService.create(new Customer("Nico", false, 49, 235));
            customerService.create(new Customer("Orwell", true, 51, 240));
            customerService.create(new Customer("Joe", true, 51, 240));
            System.out.println("Customers created!");



            printLine("Find all customers sorted by height DESC");
            customerService.findAllByOrderByHeightInCmDesc().forEach(System.out::println);

            printLine("Find by active");
            customerService.findByActive(true).forEach(System.out::println);

            printLine("Find first 2 by name");
            customerService.findFirst2ByName("Joe").forEach(System.out::println);

            printLine("Find all customers named 'Joe' or 'Mark' using IN");
            customerService.findByNameIn(List.of("Joe", "Mark")).forEach(System.out::println);

            printLine("Find all customers named 'Joe' or 'Mark' using @Query");
            customerService.findByNames("Joe", "Mark").forEach(System.out::println);


//            printLine("find all");
//            customerService.findAll().forEach(System.out::println);
//            printLine("find one by id");
//            System.out.println(customerService.findById(customer.getId()));
//            System.out.println(customerService.findById(16L));
//            printLine("update 1");
//            System.out.println(customerService.findById(customer.getId()));
//            customerService.updateNameById(customer.getId(), new Customer("Eddie", false, 33, 190));
//            System.out.println(customerService.findById(customer.getId()));
//            printLine("delete by id");
//            System.out.println(customerService.findById(customer.getId()));
//            customerService.deleteById(customer.getId());
//            System.out.println(customerService.findById(customer.getId()));
//
//            printLine("delete all");
//            customerService.findAll().forEach(System.out::println);
//            customerService.deleteAll();
//            customerService.findAll().forEach(System.out::println);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public void printLine(String string) {
        System.out.println("==========================[ " + string + " ]==========================   (╯°□°)╯︵ ┻━┻");
    }

}
