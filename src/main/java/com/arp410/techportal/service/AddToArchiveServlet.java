package com.arp410.techportal.service;

import com.arp410.techportal.dao.DemandDAO;
import com.arp410.techportal.model.Demand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddToArchiveServlet extends HttpServlet {

    private DemandDAO demandDAO = new DemandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String unicDataEnds = new SimpleDateFormat("ddMMy-HHmm-ss").format(new Date());
        String unicNumberOfDemand = (request.getParameter("unicNumberOfDemand"));

        Demand demand = null;
        try {
            demand = demandDAO.getDemand(unicNumberOfDemand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            demandDAO.addToArchive(demand, unicDataEnds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
