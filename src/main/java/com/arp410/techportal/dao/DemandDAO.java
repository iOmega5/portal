package com.arp410.techportal.dao;

import com.arp410.techportal.interfaces.NumberGenerator;
import com.arp410.techportal.model.Demand;
import com.arp410.techportal.model.DemandData;
import com.arp410.techportal.model.DemandIpAddress;
import com.arp410.techportal.model.Department;
import com.arp410.techportal.utils.ConnectionUtility;
import org.springframework.context.annotation.Bean;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DemandDAO {

    private Connection jdbcConnection;
    private DemandData demandData;
    private NumberGenerator numberGenerator;
    private Demand demand;
    private DemandIpAddress demandIpAddress;


    public DemandDAO() {
        jdbcConnection = ConnectionUtility.getConnection();
    }


    public boolean insertDemand(Demand demand) throws SQLException {
        String insertSQL = "INSERT INTO techportaldb.demand (fromDemand, messageDemand, dataDemand, statusDemand, unicNumberDemand) " +
                "VALUES (?,?,?,?,?)";

        int statusOfDemand = 1;

        PreparedStatement statement = jdbcConnection.prepareStatement(insertSQL);

        statement.setInt(1, Integer.parseInt(demand.getFromDemand()));
        statement.setString(2, demand.getMessageDemand());
        statement.setString(3, String.valueOf(new SimpleDateFormat("dd-MM-y").format(new Date()))); //TODO
        statement.setInt(4, statusOfDemand);
        statement.setString(5, demand.getUnicNumberOfDemand());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        return rowInserted;
    }

    public boolean addToArchive(Demand demand, String unicDataEnds) throws SQLException {

        String movedSql = "INSERT INTO techportaldb.demand_archive (fromDemand, messageDemand, dataDemandStart, dataDemandEnds, statusDemand, unicNumberDemand) " +
                "VALUE (?,?,?,?,?,?)";

        int statusOfDemand = 0;
        int fromDep;
        Map<String, Integer> list = listOfDepartment();

        fromDep = list.get(demand.getFromDemand());

        PreparedStatement statement = jdbcConnection.prepareStatement(movedSql);

        statement.setInt(1, fromDep);
        statement.setString(2, demand.getMessageDemand());
        statement.setString(3, demand.getDataOfDemand());
        statement.setString(4, unicDataEnds);
        statement.setInt(5, statusOfDemand);
        statement.setString(6, demand.getUnicNumberOfDemand());


        boolean rowMoved = statement.executeUpdate() > 0;

        if (rowMoved) {
            deleteDemand(demand);
        }

        statement.close();
        return rowMoved;
    }

    @Bean
    public List<Demand> listAllDemand(Department department) throws SQLException {
        List<Demand> listDemand = new ArrayList<>();

        String sql;
        ResultSet resultSet;
        Statement statement = null;
        PreparedStatement ps = null;

        String depName = department.getNameDepartment();

        if (depName.equals("Отдел АСУП")) {
            sql = "SELECT demand.idDemand, demand.messageDemand,demand.dataDemand,demand.statusDemand,demand.unicNumberDemand, dep.nameDepartment " +
                    "FROM techportaldb.demand AS demand" +
                    " INNER JOIN techportaldb.department AS dep" +
                    " WHERE demand.fromDemand = dep.idDepartment";

            statement = jdbcConnection.createStatement();
            resultSet = statement.executeQuery(sql);

        } else {
            sql = "SELECT demand.idDemand, demand.messageDemand,demand.dataDemand,demand.statusDemand,demand.unicNumberDemand, dep.nameDepartment " +
                    "FROM techportaldb.demand AS demand" +
                    " INNER JOIN techportaldb.department AS dep" +
                    " WHERE demand.fromDemand = dep.idDepartment AND dep.nameDepartment = ?";

            ps = jdbcConnection.prepareStatement(sql);
            ps.setString(1, depName);
            resultSet = ps.executeQuery();
        }

        while (resultSet.next()) {
            int idDemand = resultSet.getInt("idDemand");
            String from = resultSet.getString("nameDepartment");
            String message = resultSet.getString("messageDemand");
            String dataDemand = resultSet.getString("dataDemand");
            int status = resultSet.getInt("statusDemand");
            String unicNumber = resultSet.getString("unicNumberDemand");

            Demand demand = new Demand(idDemand, from, message, dataDemand, status, unicNumber);

            listDemand.add(demand);
        }
        resultSet.close();

        if (statement != null) {
            statement.close();
        }

        if (ps != null) {
            ps.close();
        }

        return listDemand;
    }

    public boolean deleteDemand(Demand demand) throws SQLException {
        String sql = "DELETE FROM demand where unicNumberDemand = ?";

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, demand.getUnicNumberOfDemand());

        boolean rowDeleted = statement.executeUpdate() > 0;

        statement.close();

        return rowDeleted;
    }

    public boolean updateDemand(Demand demand) throws SQLException {
        String sql = "UPDATE demand SET statusDemand = ?";
        sql += " WHERE idDemand = ?";

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, String.valueOf(demand.getStatusOfDemand(rs.getInt("statusDemand"))));

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();

        return rowUpdated;
    }

    public Map<String, Integer> listOfDepartment() throws SQLException {
        Map<String, Integer> departments = new HashMap<>();

        String sqlDepartment = "SELECT department.nameDepartment, department.unicNumberDepartment FROM department";

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlDepartment);

        while (resultSet.next()) {
            String nameDepartment = resultSet.getString(1);
            int unicnNmber = resultSet.getInt(2);
            departments.put(nameDepartment, unicnNmber);
        }

        resultSet.close();
        statement.close();

        return departments;
    }


    public Demand getDemand(String unicNumberDemand) throws SQLException {

        String sql = "SELECT dep.nameDepartment, demand.messageDemand, demand.dataDemand, demand.statusDemand, demand.unicNumberDemand FROM techportaldb.demand AS demand" +
                " INNER JOIN techportaldb.department AS dep" +
                " WHERE demand.fromDemand = dep.idDepartment AND unicNumberDemand = ?";

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, unicNumberDemand);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String from = resultSet.getString("nameDepartment");
            String message = resultSet.getString("messageDemand");
            String dataDemand = resultSet.getString("dataDemand");
            int status = resultSet.getInt("statusDemand");
            String unicNumber = resultSet.getString("unicNumberDemand");

            demand = new Demand(from, message, dataDemand, status, unicNumber);

        }

        resultSet.close();
        statement.close();

        return demand;
    }


    public List<Demand> listArchiveDemand(Department department) throws SQLException {
        List<Demand> listArchiveDemand = new ArrayList<>();

        String sql;
        ResultSet resultSet;
        Statement statement;

        sql = "SELECT demand_arch.idDemand_archive, demand_arch.messageDemand,demand_arch.dataDemandStart, demand_arch.dataDemandEnds, demand_arch.statusDemand,demand_arch.unicNumberDemand, dep.nameDepartment " +
                "FROM techportaldb.demand_archive AS demand_arch" +
                " INNER JOIN techportaldb.department AS dep" +
                " WHERE demand_arch.fromDemand = dep.unicNumberDepartment";

        statement = jdbcConnection.createStatement();
        resultSet = statement.executeQuery(sql);


        while (resultSet.next()) {

            String from = resultSet.getString("nameDepartment");
            String message = resultSet.getString("messageDemand");
            String dataDemand = resultSet.getString("dataDemandStart");
            String dataDemandEnds = resultSet.getString("dataDemandEnds");
            int status = resultSet.getInt("statusDemand");
            String unicNumber = resultSet.getString("unicNumberDemand");

            Demand demand = new Demand(from, message, dataDemand, dataDemandEnds, status, unicNumber);

            listArchiveDemand.add(demand);
        }
        resultSet.close();
        statement.close();

        return listArchiveDemand;
    }

    public boolean insertIpToDb(DemandIpAddress demandIpAddress) throws SQLException {
        String insertSQL = "INSERT INTO techportaldb.demand_ipaddress (ipAddress, unicNumberDemand) " +
                "VALUES (?,?)";

        PreparedStatement statement = jdbcConnection.prepareStatement(insertSQL);

        statement.setString(1, demandIpAddress.getIpAddress());
        statement.setString(2, demandIpAddress.getunicNumberDemand());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        return rowInserted;
    }

    public List<DemandIpAddress> listIpDemand(Department department) throws SQLException {
        List<DemandIpAddress> listIpDemand = new ArrayList<>();

        String sql;
        ResultSet resultSet;
        Statement statement;

        sql = "SELECT ip.ipAddress, ip.unicNumberDemand FROM techportaldb.demand_ipaddress AS ip";

        statement = jdbcConnection.createStatement();
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String ipAddress = resultSet.getString("ipAddress");
            String unicNumberDemand = resultSet.getString("unicNumberDemand");

            DemandIpAddress demandIpAddress = new DemandIpAddress(ipAddress, unicNumberDemand);
            listIpDemand.add(demandIpAddress);
        }

        statement.close();
        resultSet.close();

        return listIpDemand;
    }

}
