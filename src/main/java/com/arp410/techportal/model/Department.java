package com.arp410.techportal.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Department implements Serializable {

    private int id;
    private String nameDepartment;
    private int unicNumberDepartment;
    private String aboutDepartment;

    public Department() {
    }

    public Department(int id, String nameDepartment) {
        this.id = id;
        this.nameDepartment = nameDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getUnicNumberDepartment() {
        return unicNumberDepartment;
    }

    public void setUnicNumberDepartment(int unicNumberDepartment) {
        this.unicNumberDepartment = unicNumberDepartment;
    }

    public String getAboutDepartment() {
        return aboutDepartment;
    }

    public void setAboutDepartment(String aboutDepartment) {
        this.aboutDepartment = aboutDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", nameDepartment='" + nameDepartment + '\'' +
                ", unicNumberDepartment=" + unicNumberDepartment +
                ", aboutDepartment='" + aboutDepartment + '\'' +
                '}';
    }
}
