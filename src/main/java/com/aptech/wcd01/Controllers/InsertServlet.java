package com.aptech.wcd01.Controllers;

import com.aptech.wcd01.models.Employee;
import com.aptech.wcd01.services.EmployeeJDBCService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/insert")
public class InsertServlet extends HttpServlet {


    @Inject
    private EmployeeJDBCService employeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher("/WEB-INF/insert.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {


            Employee employee = new Employee();
            employee.setId(req.getParameter("id"));
            employee.setName(req.getParameter("name"));
            employee.setAddress(req.getParameter("address"));
            employee.setAge(Integer.parseInt(req.getParameter("age")));



            if (!employeeService.addEmployee(employee)) {

                req.setAttribute("error", "Insert employee error");
                req.getServletContext()
                        .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);

            } else {
                resp.sendRedirect("list");
            }

        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            ex.printStackTrace();
        }

    }
}
