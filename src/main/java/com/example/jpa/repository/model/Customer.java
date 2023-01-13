package com.example.jpa.repository.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name_and_status", columnNames = {"name", "active"})
        },
        indexes = {
                @Index(name = "customer_name_idx", columnList = "name")
        })
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active;
    private Integer age;
    //@Column(name = "height_in_cm")
    private Integer heightInCm;

}