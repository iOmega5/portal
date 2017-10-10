//package com.arp410.techportal.service;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.*;
//
//@WebServlet(name = "LoginServlet", urlPatterns = "/login")
//public class LoginServlet_User extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//
//        String dbLogin = null;
//        String dbPassword = null;
//        int dbDepartmentId = 0;
//        String dbDepartmentUser = "unknown";
//
//
//        String sql = "SELECT user.loginUser, user.passwordUser, dep.idDepartment, dep.nameDepartment FROM user AS user " +
//                "INNER JOIN department AS dep ON user.departmentUser = dep.idDepartment " +
//                "WHERE loginUser=? AND passwordUser=?";
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/techportaldb", "root", "root");
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, login);
//            ps.setString(2, password);
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                dbLogin = rs.getString(1);
//                dbPassword = rs.getString(2);
//                dbDepartmentId = rs.getInt(3);
//                dbDepartmentUser = rs.getString(4);
//            }
//            if (login.equals(dbLogin) && password.equals(dbPassword)) {
//                HttpSession session = request.getSession();
//                session.setAttribute("auth", true);
//                session.setAttribute("department", dbDepartmentUser);
//                session.setAttribute("idDepartmenr", dbDepartmentId);
//                String postURL = (String) session.getAttribute("postLoginURL");
//                if (postURL != null) {
//                    response.sendRedirect(postURL);
//                } else {
//                    response.sendRedirect("demand.jsp");
//                }
//            } else {
//                response.sendRedirect("index.jsp");
//            }
//            rs.close();
//            ps.close();
//            conn.close();
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void connection() {
//        //TODO
//    }
//}
