package com.arp410.techportal.model;

public class DemandIpAddress {

    private int idDeamndIp;
    private String ipAddress;
    private String unicNumberDemand;

    public DemandIpAddress(int idDeamndIp, String ipAddress, String unicNumberDemand) {
        this.idDeamndIp = idDeamndIp;
        this.ipAddress = ipAddress;
        this.unicNumberDemand = unicNumberDemand;
    }

    public DemandIpAddress(String ipAddress, String unicNumberDemand) {
        this.ipAddress = ipAddress;
        this.unicNumberDemand = unicNumberDemand;
    }

    public int getIdDeamndIp() {
        return idDeamndIp;
    }

    public void setIdDeamndIp(int idDeamndIp) {
        this.idDeamndIp = idDeamndIp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getunicNumberDemand() {
        return unicNumberDemand;
    }

    public void setunicNumberDemand(String unicNumberDemand) {
        this.unicNumberDemand = unicNumberDemand;
    }

    @Override
    public String toString() {
        return "DemandIpAddress{" +
                "idDeamndIp=" + idDeamndIp +
                ", ipAddress='" + ipAddress + '\'' +
                ", unicNumberDemand=" + unicNumberDemand +
                '}';
    }
}
