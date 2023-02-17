package com.aptech.wcd01.controllers;

import com.aptech.wcd01.services.EmployeeJDBCService;
import com.aptech.wcd01.services.EmployeeJDBCServiceImpl;
import com.aptech.wcd01.services.EmployeeJPAService;
import com.aptech.wcd01.services.EmployeeJPAServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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

        String search = req.getParameter("searchStr");
        var cookie = new Cookie("lastSearchStr",search );
        cookie.setHttpOnly(true);
        resp.addCookie(cookie);
        req.setAttribute("employeeList", employeeJDBCService.searchEmployee(search));

        req.getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }
}
