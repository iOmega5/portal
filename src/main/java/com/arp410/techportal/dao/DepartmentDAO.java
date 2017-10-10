package com.arp410.techportal.dao;

import com.arp410.techportal.model.Department;
import com.arp410.techportal.utils.ConnectionUtility;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements Serializable {

    private Connection jdbcConnection;

    public DepartmentDAO() {
        jdbcConnection = ConnectionUtility.getConnection();
    }

    public List<Department> listAllDepartment() throws SQLException {
        List<Department> listDepartment = new ArrayList<>();
        String sql = "SELECT idDepartment, nameDepartment From department";

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int idDepartment = resultSet.getInt("idDepartment");
            String nameDepartment = resultSet.getString("nameDepartment");

            Department department = new Department(idDepartment, nameDepartment);
            listDepartment.add(department);
        }
        resultSet.close();
        statement.close();

        return listDepartment;
    }
}
