package com.arp410.techportal.service;

import com.arp410.techportal.dao.DepartmentDAO;
import com.arp410.techportal.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class NewFormServlet extends HttpServlet {
    private DepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        List<Department> departments = null;

        try {
            departments = departmentDAO.listAllDepartment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("depDropdown", departments);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secured/demandForm.jsp");
        requestDispatcher.forward(request, response);
    }
}
