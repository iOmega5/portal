package com.arp410.techportal.interfaces;

import com.arp410.techportal.model.Demand;

import java.util.List;

public interface DemandDAO {

    void insertDemand (Demand demand);

    void deleteDemand (Demand demand);

    void addDemandToArchive(Demand demand);

    Demand getDemandById(int id);

    List<Demand> getDemandList();

}
