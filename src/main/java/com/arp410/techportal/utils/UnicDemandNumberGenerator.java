package com.arp410.techportal.utils;

import com.arp410.techportal.interfaces.NumberGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UnicDemandNumberGenerator implements NumberGenerator {

//    private String getUnicDemandDataData(){
//        return new SimpleDateFormat("ddMMy-HHmm-ss").format(new Date());
//    }
//
//    private int randomPostfix() {
//        return Math.abs(new Random().nextInt());
//    }

//    private String prefix(){
//        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("departmentId");
//    }

    @Override
    public String generateNumber(String prefix) {
        return prefix + "-" + new SimpleDateFormat("ddMMy-HHmm-ss").format(new Date()) + "-" + Math.abs(new Random().nextInt());
    }
}
