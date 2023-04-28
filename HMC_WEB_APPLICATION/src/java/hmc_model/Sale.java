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
public class Sale {
    private Integer invno;
    private LocalDate invdate;
    private Employee capture;
    private Double totalamt;

    public Sale() {
    }

    public Sale(Integer invno, LocalDate invdate, Employee capture, Double totalamt) {
        this.invno = invno;
        this.invdate = invdate;
        this.capture = capture;
        this.totalamt = totalamt;
    }

    public Integer getInvno() {
        return invno;
    }

    public void setInvno(Integer invno) {
        this.invno = invno;
    }

    public LocalDate getInvdate() {
        return invdate;
    }

    public void setInvdate(LocalDate invdate) {
        this.invdate = invdate;
    }

    public Employee getCapture() {
        return capture;
    }

    public void setCapture(Employee capture) {
        this.capture = capture;
    }

    public Double getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Double totalamt) {
        this.totalamt = totalamt;
    }

    @Override
    public String toString() {
        return "Sale{" + "invno=" + invno + ", invdate=" + invdate + ", capture=" + capture + ", totalamt=" + totalamt + '}';
    }
}
