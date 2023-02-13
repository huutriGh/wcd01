package com.aptech.wcd01.controllers;

import com.aptech.wcd01.services.EmployeeJPAService;
import com.aptech.wcd01.services.EmployeeJPAServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeJPAService employeeJPAService = new EmployeeJPAServiceImpl();
        req.setAttribute("employeeList", employeeJPAService.getAllEmployee());
        req.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req,resp);

    }
}
