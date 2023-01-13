package com.example.jpa.repository;

import com.example.jpa.repository.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customer")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.name = ?1 OR c.name = ?2")
    List<Customer> findByNames(String name1, String name2);

    List<Customer> findByNameIn(List<String> names);
    List<Customer> findAllByOrderByHeightInCmDesc();

    List<Customer> findAllByActive(boolean active);

    List<Customer> findTop2ByName(String name);
}
