package com.aptech.wcd01.services;

import com.aptech.wcd01.models.Employee;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import jakarta.transaction.UserTransaction;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;


@ApplicationScoped
public class EmployeeJPAServiceImpl implements EmployeeJPAService {


    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;
    UserTransaction userTransaction;

    public EmployeeJPAServiceImpl() {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        entityManager = entityManagerFactory.createEntityManager();
        try {
            userTransaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

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


            userTransaction.begin();
            entityManager.joinTransaction();
            entityManager.persist(employee);
            userTransaction.commit();


            return true;
        } catch (Exception ex) {
            ex.printStackTrace();

            return false;
        }

    }

    @Override
    public boolean updateEmployee(Employee employee) {

        try {
            userTransaction.begin();
            entityManager.joinTransaction();
            entityManager.merge(employee);
            userTransaction.commit();


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
