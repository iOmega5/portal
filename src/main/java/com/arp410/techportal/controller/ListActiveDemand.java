package com.arp410.techportal.controller;

import com.arp410.techportal.dao.DemandDAO;
import com.arp410.techportal.model.Demand;
import com.arp410.techportal.model.Department;
import org.springframework.stereotype.Component;


import java.sql.SQLException;
import java.util.List;

@Component
public class ListActiveDemand {

    private List<Demand> demandList;


    private DemandDAO demandDAO;

    private Department department = new Department(104,"Отдел АСУП");


    public void init(){

        try {
            demandList = demandDAO.listAllDemand(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Demand> getDemandList(){
        return demandList;
    }

    public void setDemandDAO(DemandDAO demandDAO) {
        this.demandDAO = demandDAO;
    }
}
