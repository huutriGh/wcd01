package com.aptech.wcd01.Controllers;

import com.aptech.wcd01.models.Employee;
import com.aptech.wcd01.services.EmployeeJPAService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    @Inject
    EmployeeJPAService employeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("emp", employeeService.getEmployeeById(id));
        req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setId(req.getParameter("id"));
        employee.setName(req.getParameter("name"));
        employee.setAddress(req.getParameter("address"));
        employee.setAge(Integer.parseInt(req.getParameter("age")));

        if (!employeeService.updateEmployee(employee)) {

            req.setAttribute("error", "Update employee fail !!!");
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
        } else {

            resp.sendRedirect(req.getContextPath() + "/list");

        }
    }
}