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
import java.util.List;


public class ArchiveServlet extends HttpServlet {

    private DemandDAO demandDAO = new DemandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int idDepartment = (int) request.getSession().getAttribute("departmentId");
        String nameDepartment = (String) request.getSession().getAttribute("departmentName");

        if (nameDepartment.equals("Отдел АСУП")) {

            Department department = new Department(idDepartment, nameDepartment);

            List<Demand> listDemandArchive = null;
            try {
                listDemandArchive = demandDAO.listArchiveDemand(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("listDemandArchive", listDemandArchive);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secured/demandarchive.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("../index.jsp");
        }
    }
}
