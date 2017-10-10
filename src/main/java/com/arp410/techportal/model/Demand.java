package com.arp410.techportal.model;

public class Demand {
    private int idDemand;
    private String fromDemand;
    private String messageDemand;
    private String dataOfDemand;
    private String dataOfDemandEnds;
    private int statusOfDemand;
    private String unicNumberOfDemand;

    public Demand() {
    }

    public Demand(int idDemand) {
        this.idDemand = idDemand;
    }

    public Demand(String unicNumberOfDemand) {
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    public Demand(String fromDemand, String messageDemand, String unicNumberOfDemand) {
        this.fromDemand = fromDemand;
        this.messageDemand = messageDemand;
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    public Demand(String fromDemand, String messageDemand, String dataOfDemand, int statusOfDemand, String unicNumberOfDemand) {
        this.fromDemand = fromDemand;
        this.messageDemand = messageDemand;
        this.dataOfDemand = dataOfDemand;
        this.statusOfDemand = statusOfDemand;
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    public Demand(int idDemand, String fromDemand, String messageDemand, String dataOfDemand, int statusOfDemand, String unicNumberOfDemand) {
        this.idDemand = idDemand;
        this.fromDemand = fromDemand;
        this.messageDemand = messageDemand;
        this.dataOfDemand = dataOfDemand;
        this.statusOfDemand = statusOfDemand;
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    public Demand(String fromDemand, String messageDemand, String dataOfDemand, String dataOfDemandEnds, int statusOfDemand, String unicNumberOfDemand) {
        this.fromDemand = fromDemand;
        this.messageDemand = messageDemand;
        this.dataOfDemand = dataOfDemand;
        this.dataOfDemandEnds = dataOfDemandEnds;
        this.statusOfDemand = statusOfDemand;
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    public Demand(int idDemand, String fromDemand, String messageDemand, String dataOfDemand, String dataOfDemandEnds, int statusOfDemand, String unicNumberOfDemand) {
        this.idDemand = idDemand;
        this.fromDemand = fromDemand;
        this.messageDemand = messageDemand;
        this.dataOfDemand = dataOfDemand;
        this.dataOfDemandEnds = dataOfDemandEnds;
        this.statusOfDemand = statusOfDemand;
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    public int getIdDemand() {
        return idDemand;
    }

    public void setIdDemand(int idDemand) {
        this.idDemand = idDemand;
    }

    public String getFromDemand() {
        return fromDemand;
    }

    public void setFromDemand(String fromDemand) {
        this.fromDemand = fromDemand;
    }

    public String getMessageDemand() {
        return messageDemand;
    }

    public void setMessageDemand(String messageDemand) {
        this.messageDemand = messageDemand;
    }

    public String getDataOfDemand() {
        return dataOfDemand;
    }

    public void setDataOfDemand(String dataOfDemand) {
        this.dataOfDemand = dataOfDemand;
    }

    public String getDataOfDemandEnds() {
        return dataOfDemandEnds;
    }

    public void setDataOfDemandEnds(String dataOfDemandEnds) {
        this.dataOfDemandEnds = dataOfDemandEnds;
    }

    public int getStatusOfDemand() {
        return statusOfDemand;
    }

    public void setStatusOfDemand(int statusOfDemand) {
        this.statusOfDemand = statusOfDemand;
    }

    public String getUnicNumberOfDemand() {
        return unicNumberOfDemand;
    }

    public void setUnicNumberOfDemand(String unicNumberOfDemand) {
        this.unicNumberOfDemand = unicNumberOfDemand;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "idDemand=" + idDemand +
                ", fromDemand='" + fromDemand + '\'' +
                ", messageDemand='" + messageDemand + '\'' +
                ", dataOfDemand='" + dataOfDemand + '\'' +
                ", dataOfDemandEnds='" + dataOfDemandEnds + '\'' +
                ", statusOfDemand=" + statusOfDemand +
                ", unicNumberOfDemand='" + unicNumberOfDemand + '\'' +
                '}';
    }
}
