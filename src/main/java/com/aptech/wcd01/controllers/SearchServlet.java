package com.aptech.wcd01.controllers;

import com.aptech.wcd01.services.EmployeeJDBCService;
import com.aptech.wcd01.services.EmployeeJDBCServiceImpl;
import com.aptech.wcd01.services.EmployeeJPAService;
import com.aptech.wcd01.services.EmployeeJPAServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

//    EmployeeJPAService employeeJPAService = new EmployeeJPAServiceImpl();
    EmployeeJDBCService employeeJDBCService = new EmployeeJDBCServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("employeeList", employeeJDBCService.searchEmployee(req.getParameter("searchStr")));
        req.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }
}
