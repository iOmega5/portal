package com.arp410.techportal.utils;

import com.arp410.techportal.model.Demand;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DemandMapper implements RowMapper<Demand> {

    @Override
    public Demand mapRow(ResultSet rs, int rowNum) throws SQLException {
        Demand demand = new Demand();
        demand.setIdDemand(rs.getInt("idDemand"));
        demand.setFromDemand(rs.getString("fromDemand"));
        demand.setMessageDemand(rs.getString("messageDemand"));
        demand.setDataOfDemand(rs.getString("dataOfDemand"));
        demand.setStatusOfDemand(rs.getInt("statusDemand"));
        demand.setUnicNumberOfDemand(rs.getString("unicNumberOfDemand"));
        return demand;
    }
}
