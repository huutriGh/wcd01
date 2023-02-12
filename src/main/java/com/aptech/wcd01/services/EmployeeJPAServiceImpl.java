package com.aptech.wcd01.services;

import com.aptech.wcd01.models.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Set;


@ApplicationScoped
public class EmployeeJPAServiceImpl implements EmployeeJPAService {


    @PersistenceContext(unitName = "employee")
    private  EntityManager entityManager;
    private  UserTransaction userTransaction;

    public EmployeeJPAServiceImpl() {

        try {
            userTransaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
        } catch (NamingException e) {

            e.printStackTrace();
        }
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {

            userTransaction.begin();
            entityManager.joinTransaction();
            entityManager.persist(employee);
            userTransaction.commit();

            return true;
        } catch (Exception exception) {
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
        }catch (Exception ex) {
            ex.printStackTrace();
            return  false;
        }

    }

    @Override
    public boolean deleteEmployee(String id) {
        try {
            userTransaction.begin();
            entityManager.joinTransaction();
            entityManager.remove(getEmployeeById(id));
            userTransaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
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

    /**
     * Funtion get all violation when valid entity
     * @param employee
     * @return String of message invalid.
     */

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
