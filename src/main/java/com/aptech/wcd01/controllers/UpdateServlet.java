package com.aptech.wcd01.controllers;

import com.aptech.wcd01.models.Employee;
import com.aptech.wcd01.services.EmployeeJPAService;
import com.aptech.wcd01.services.EmployeeJPAServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    EmployeeJPAService employeeJPAService = new EmployeeJPAServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        req.setAttribute("emp", employeeJPAService.getEmployeeById(id));
        req.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        employeeJPAService = new EmployeeJPAServiceImpl();
        Employee employee = new Employee();
        employee.setId(req.getParameter("id"));
        employee.setName(req.getParameter("name"));
        employee.setAddress(req.getParameter("address"));
        employee.setAge(Integer.parseInt(req.getParameter("age")));

        if (employeeJPAService.updateEmployee(employee)) {
            resp.sendRedirect(req.getContextPath() + "/list");
        } else {
            req.setAttribute("error", "Delete error !!!");
            req.getServletContext().getRequestDispatcher("/WEB-INF/failed.jsp");
        }
    }
}
