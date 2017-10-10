package com.arp410.techportal.beans;

import com.arp410.techportal.dao.DepartmentDAO;
import com.arp410.techportal.model.Department;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class DropdownView implements Serializable {

    private DepartmentDAO departmentDAO = new DepartmentDAO();

    private List<Department> departments = new ArrayList<>();
    private String nameDepartment;

    @PostConstruct
    public void init() throws SQLException {
       departments = departmentDAO.listAllDepartment();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public void displayLocation() {
        FacesMessage msg;
        if(nameDepartment != null)
            msg = new FacesMessage("Selected", nameDepartment);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Department name is not selected.");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}