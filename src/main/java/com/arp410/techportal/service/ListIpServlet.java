package com.arp410.techportal.service;

import com.arp410.techportal.dao.DemandDAO;
import com.arp410.techportal.model.Demand;
import com.arp410.techportal.model.DemandIpAddress;
import com.arp410.techportal.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class ListIpServlet extends HttpServlet {

    private DemandDAO demandDAO = new DemandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
// TODO
        int idDepartment = (int) request.getSession().getAttribute("departmentId");
        String nameDepartment = (String) request.getSession().getAttribute("departmentName");

        if (nameDepartment.equals("Отдел АСУП")) {

            Department department = new Department(idDepartment, nameDepartment);

            List<DemandIpAddress> listIpDemand = null;
            try {
                listIpDemand = demandDAO.listIpDemand(department);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("listIpDemand", listIpDemand);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/secured/demandip.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("../index.jsp");
        }
    }
}
