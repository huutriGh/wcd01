package com.aptech.wcd01.controllers;

import com.aptech.wcd01.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session =  req.getSession(false);
        if(session != null){
            session.invalidate();
            req.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUserName(userName).setPassword(password);

        if (userName.equals("user") && password.equals("password")) {
            var session = req.getSession(true);

            session.setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/list");
        } else {

            req.getServletContext().getRequestDispatcher("/login.jsp").include(req, resp);
            resp.getWriter().write("Invalid username or password");
        }
    }
}
