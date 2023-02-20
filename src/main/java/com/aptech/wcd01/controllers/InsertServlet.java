package com.aptech.wcd01.controllers;

import com.aptech.wcd01.models.Employee;
import com.aptech.wcd01.services.EmployeeJPAService;
import com.aptech.wcd01.services.EmployeeJPAServiceImpl;
import com.aptech.wcd01.validation.BeanValidation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/insert")
public class InsertServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher("/WEB-INF/insert.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            EmployeeJPAService employeeJPAService = new EmployeeJPAServiceImpl();
            Employee employee = new Employee();
            employee.setId(req.getParameter("id"));
            employee.setName(req.getParameter("name"));
            employee.setAddress(req.getParameter("address"));
            employee.setAge(Integer.valueOf(req.getParameter("age")));
            BeanValidation<Employee> employeeBeanValidation = new BeanValidation<>();
            String error = employeeBeanValidation.validEmployee(employee);
            if (!error.isEmpty()) {

                req.setAttribute("error", error);
                req.getServletContext().getRequestDispatcher("/WEB-INF/insert.jsp").include(req, resp);

            } else {

                if (!employeeJPAService.addEmployee(employee)) {

                    req.setAttribute("error", "Employee is exist");
                    req.getServletContext()
                            .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
                } else {

                    resp.sendRedirect(req.getContextPath() + "/list");

                }
            }

        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            ex.printStackTrace();
        }

    }
}
