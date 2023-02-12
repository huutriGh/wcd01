package com.aptech.wcd01.Controllers;

import com.aptech.wcd01.services.EmployeeJDBCService;
import com.aptech.wcd01.services.EmployeeJPAService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    @Inject
    EmployeeJDBCService employeeService ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employeeList", employeeService.getAllEmployee());
        req.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req,resp);
    }
}
