package com.arp410.techportal.service;

import com.arp410.techportal.dao.DemandDAO;
import com.arp410.techportal.model.Demand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "/delete")
public class DeleteServlet extends HttpServlet {

    private DemandDAO demandDAO = new DemandDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String unicNumberOfDemand = (request.getParameter("unicNumberOfDemand")); //TODO
        Demand demand = new Demand(unicNumberOfDemand);
        try {
            demandDAO.deleteDemand(demand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
