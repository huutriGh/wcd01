package com.aptech.wcd01.services;

import com.aptech.wcd01.models.Employee;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;



public class EmployeeJPAServiceImpl implements EmployeeJPAService {



    private EntityManager entityManager;


    public EmployeeJPAServiceImpl() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();


    }

    @Override
    public List<Employee> getAllEmployee() {

        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public boolean addEmployee(Employee employee) {

        try {

            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();


            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }

    }

    @Override
    public boolean updateEmployee(Employee employee) {

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();


            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }
    }

    @Override
    public boolean deleteEmployee(String id) {
        return false;
    }
}
