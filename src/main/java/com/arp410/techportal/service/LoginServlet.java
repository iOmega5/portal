package com.arp410.techportal.service;

import com.arp410.techportal.utils.ConnectionUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String dbLogin = null;
        String dbPassword = null;
        int dbIdDepartment = 0;

        String sql = "SELECT nameDepartment, unicNumberDepartment, idDepartment FROM department " +
                "WHERE nameDepartment = ? AND unicNumberDepartment = ?";

        try {

            Connection conn = ConnectionUtility.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dbLogin = rs.getString(1);
                dbPassword = rs.getString(2);
                dbIdDepartment = rs.getInt(3);
            }
            if (login.equals(dbLogin) && password.equals(dbPassword)) {
                HttpSession session = request.getSession();

                session.setAttribute("auth", true);
                session.setAttribute("departmentId", dbIdDepartment);
                session.setAttribute("departmentName", dbLogin);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
