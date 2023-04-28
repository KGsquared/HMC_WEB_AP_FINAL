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
public class JobCard {
    private Integer jobno;
    private LocalDate jobdate;
    private String regno;
    private String model;
    private Service servid;
    private String phone;
    private String driver;
    private Employee mechanic;
    private Double amt;

    public JobCard() {
    }

    public Integer getJobno() {
        return jobno;
    }

    public void setJobno(Integer jobno) {
        this.jobno = jobno;
    }

    public LocalDate getJobdate() {
        return jobdate;
    }

    public void setJobdate(LocalDate jobdate) {
        this.jobdate = jobdate;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Service getServid() {
        return servid;
    }

    public void setServid(Service servid) {
        this.servid = servid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Employee getMechanic() {
        return mechanic;
    }

    public void setMechanic(Employee mechanic) {
        this.mechanic = mechanic;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }

    @Override
    public String toString() {
        return "JobCard{" + "jobno=" + jobno + ", jobdate=" + jobdate + ", regno=" + regno + ", model=" + model + ", servid=" + servid + ", phone=" + phone + ", driver=" + driver + ", mechanic=" + mechanic + ", amt=" + amt + '}';
    }
}
