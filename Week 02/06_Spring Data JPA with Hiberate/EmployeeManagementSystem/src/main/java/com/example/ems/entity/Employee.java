package com.example.ems.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "employees")
@NamedQueries({
        @NamedQuery(
                name = "Employee.fetchByEmailNamed",
                query = "SELECT e FROM Employee e WHERE e.email = :email"
        )
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    @Fetch(FetchMode.JOIN) // Hibernate-Specific performance annotation (Exercise 10)
    private Department department;
}