package com.itdr.pojo;

public class Commodity {
    private  int  sid;
    private String sname;
    private double price;
    private int status;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCname() {
        return sname;
    }

    public void setCname(String cname) {
        this.sname = cname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
