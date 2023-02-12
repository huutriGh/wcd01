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

@WebServlet(urlPatterns = "/delete")
public class DeleteSevlet extends HttpServlet {
    @Inject
    EmployeeJPAService employeeJPAService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("emp", employeeJPAService.getEmployeeById(id));
        req.getRequestDispatcher("/WEB-INF/delete.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!employeeJPAService.deleteEmployee(req.getParameter("id"))) {

            req.setAttribute("error", "Update employee fail !!!");
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/failed.jsp").forward(req, resp);
        } else {

            resp.sendRedirect(req.getContextPath() + "/list");

        }
    }
}
