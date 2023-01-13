package com.example.jpa.repository.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active;
    private Integer age;
    private Integer heightInCm;

    public Customer(String name, boolean active, Integer age, Integer heightInCm) {
        this.name = name;
        this.active = active;
        this.age = age;
        this.heightInCm = heightInCm;
    }
}