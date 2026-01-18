package com.ownProject.simple.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp_table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  name;

    private Double salary;

    private String designation;

    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")   // foreign key column
    private Company company;

}
