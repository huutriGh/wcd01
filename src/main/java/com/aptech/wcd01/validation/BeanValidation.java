package com.aptech.wcd01.validation;

import com.aptech.wcd01.models.Employee;
import jakarta.validation.*;

import java.util.Set;

public  class BeanValidation<T> {

    public   String validEmployee(T employee){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> validation =  validator.validate(employee);
        StringBuilder error = new StringBuilder();
        for (ConstraintViolation<T> violation:validation) {
            error.append(violation.getMessageTemplate()).append("\n");
        }
        return  error.toString();

    }


}
