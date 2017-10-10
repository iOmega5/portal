package com.arp410.techportal.service;


import com.arp410.techportal.dao.DemandDAO;
import com.arp410.techportal.model.Demand;
import com.arp410.techportal.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListServlet extends HttpServlet {

    private DemandDAO demandDAO = new DemandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int idDepartment = (int) request.getSession().getAttribute("departmentId");
        String nameDepartment = (String) request.getSession().getAttribute("departmentName");

        Department department = new Department(idDepartment, nameDepartment);

        List<Demand> listDemand = null;

        try {
            listDemand = demandDAO.listAllDemand(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listDemand", listDemand);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secured/demand.jsp");
        requestDispatcher.forward(request, response);
    }
}

