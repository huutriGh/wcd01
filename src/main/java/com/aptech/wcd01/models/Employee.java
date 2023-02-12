package com.aptech.wcd01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @Column(name = "Id")
    private  String id;

    @Column(name = "Emp_Name", columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "Adress",columnDefinition = "nvarchar(100)")

    private  String address;
    @Column(name = "Age")
    @Min(value = 16, message = "Age must greater than 15")
    private int age;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
