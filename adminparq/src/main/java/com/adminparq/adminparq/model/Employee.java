package com.adminparq.adminparq.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class) // entityListeners -> escuchar y reaccionar a las distintas operaciones
// que realiza un EntityManager//
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Employee;
    private String password;

    public Employee(){

    }

    public Employee(Long id, String name, String Employee, String password) {
        this.id = id;
        this.name = name;
        this.Employee = Employee;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String Employee) {
        this.Employee = Employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
