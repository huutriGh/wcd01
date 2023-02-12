package com.aptech.wcd01;

import com.aptech.wcd01.models.Employee;
import com.aptech.wcd01.models.EmployeeList;
import com.aptech.wcd01.services.EmployeeJPAService;
import com.aptech.wcd01.services.EmployeeJPAServiceImpl;
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
    EmployeeJPAService employeeJPAService ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext()
                .getRequestDispatcher("/WEB-INF/insert.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
           // EmployeeList employeeList = new EmployeeList();

            Employee employee = new Employee();
            employee.setId(req.getParameter("id"));
            employee.setName(req.getParameter("name"));
            employee.setAddress(req.getParameter("address"));
            employee.setAge(Integer.valueOf(req.getParameter("age")));



            if (!employeeJPAService.addEmployee(employee)) {

                req.setAttribute("error", "Employee is exist");
                req.getServletContext()
                        .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            } else {

                req.setAttribute("employeeList",employeeJPAService.getAllEmployee());
                req.getServletContext()
                        .getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
            }

        } catch (Exception ex) {
            req.setAttribute("error", ex.getMessage());
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
            ex.printStackTrace();
        }

    }
}
