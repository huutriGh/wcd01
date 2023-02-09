package com.aptech.wcd01.services;

import com.aptech.wcd01.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class EmloyeeServiceImpl implements EmployeeService {


    private final EntityManager entityManager;

    public EmloyeeServiceImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {
            String errMsg = validateEntity(employee);
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            return false;
        }


    }

    @Override
    public boolean updateEmployee(Employee employee) {
        entityManager.getTransaction().begin();
//        Employee emp = entityManager.find(Employee.class, employee.getId());
//        emp.setAge(employee.getAge());
//        emp.setName(employee.getName());
//        emp.setAddress(employee.getAddress());
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteEmployee(String id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(getEmployeeById(id));
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public List<Employee> getAllEmployee() {
        return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return entityManager.find(Employee.class, id);
    }

    private String validateEntity(Employee employee) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        StringBuilder stringBuilder = new StringBuilder();

        for (ConstraintViolation<Employee> violation : violations) {
            stringBuilder.append(violation.getMessageTemplate()).append("\n").append(violation.getMessageTemplate()).append("\n");

        }
        return stringBuilder.toString();
    }
}
