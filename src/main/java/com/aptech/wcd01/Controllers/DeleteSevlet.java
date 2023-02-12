package com.aptech.wcd01.Controllers;

import com.aptech.wcd01.services.EmployeeJDBCService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteSevlet extends HttpServlet {
    @Inject
    EmployeeJDBCService employeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("emp", employeeService.getEmployeeById(id));
        req.getRequestDispatcher("/WEB-INF/delete.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!employeeService.deleteEmployee(req.getParameter("id"))) {

            req.setAttribute("error", "Update employee fail !!!");
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
        } else {

            resp.sendRedirect(req.getContextPath() + "/list");

        }
    }
}
