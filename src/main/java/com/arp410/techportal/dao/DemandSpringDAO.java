package com.arp410.techportal.dao;

import com.arp410.techportal.interfaces.DemandDAO;
import com.arp410.techportal.model.Demand;
import com.arp410.techportal.utils.DemandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("demandSpringDAO")
public class DemandSpringDAO implements DemandDAO {

    private SimpleJdbcInsert insertDemand;
    private NamedParameterJdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }

    @Override
    public void insertDemand(Demand demand) {
        String insertSQL = "INSERT INTO techportaldb.demand (fromDemand, messageDemand, dataDemand, statusDemand, unicNumberDemand) " +
                "VALUES (?,?,?,?,?)";
        jdbcTemplate.getJdbcOperations().update(insertSQL, demand.getFromDemand(), demand.getMessageDemand(),demand.getDataOfDemand(), demand.getStatusOfDemand(), demand.getUnicNumberOfDemand());

    }

    @Override
    public void deleteDemand(Demand demand) {

    }

    @Override
    public void addDemandToArchive(Demand demand) {

    }

    @Override
    public Demand getDemandById(int id) {
        return null;
    }

    @Override
    public List<Demand> getDemandList() {
        String selectListDemand = "SELECT demand.idDemand, demand.messageDemand,demand.dataDemand,demand.statusDemand,demand.unicNumberDemand, dep.nameDepartment " +
                "FROM techportaldb.demand AS demand" +
                " INNER JOIN techportaldb.department AS dep" +
                " WHERE demand.fromDemand = dep.idDepartment";
        return jdbcTemplate.query(selectListDemand, new DemandMapper());
    }
}
