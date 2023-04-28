/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmc_model;

import java.time.LocalDate;

/**
 *
 * @author Approve
 */
public class Payment {
    private Integer payid;
    private LocalDate date;
    private String method;
    private Double amt;
    private String description;

    public Payment() {
    }
    public Payment(Integer payid, LocalDate date, String method, Double amt, String description) {
        this.payid = payid;
        this.date = date;
        this.method = method;
        this.amt = amt;
        this.description = description;
    }

    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Payment{" + "payid=" + payid + ", date=" + date + ", method=" + method + ", amt=" + amt + ", description=" + description + '}';
    }
}
