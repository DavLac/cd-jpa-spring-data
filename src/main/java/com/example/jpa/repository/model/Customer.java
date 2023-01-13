package com.example.jpa.repository.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "CUSTOMERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active;
    private Integer age;
    private Integer heightInCm;

    @CreatedDate
    private Instant createdDate;

    public Customer(String name, boolean active, Integer age, Integer heightInCm) {
        this.name = name;
        this.active = active;
        this.age = age;
        this.heightInCm = heightInCm;
    }
}
