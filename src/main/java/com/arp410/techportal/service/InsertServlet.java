package com.arp410.techportal.service;

import com.arp410.techportal.dao.DemandDAO;
import com.arp410.techportal.model.Demand;
import com.arp410.techportal.model.DemandIpAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class InsertServlet extends HttpServlet {

    private DemandDAO demandDAO = new DemandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String departmentId;

        String ipAddress = request.getRemoteAddr();
        String message = request.getParameter("message");

        if (request.getSession().getAttribute("auth") != null) {
            departmentId = String.valueOf(request.getSession().getAttribute("departmentId"));
        } else{
            departmentId = request.getParameter("dep");
        }

        String unicData = new SimpleDateFormat("ddMMy-HHmm-ss").format(new Date());

        String unicNumber = (departmentId) + "-" + (unicData) + "-" + Math.abs(new Random().nextInt()); //TODO

        Demand demand = new Demand(departmentId, message, unicNumber);
        DemandIpAddress demandIpAddress = new DemandIpAddress(ipAddress, unicNumber);

        try {
            demandDAO.insertDemand(demand);
            demandDAO.insertIpToDb(demandIpAddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }
}
