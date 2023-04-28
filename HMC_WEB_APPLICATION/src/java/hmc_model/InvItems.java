/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmc_model;

/**
 *
 * @author Approve
 */
public class InvItems {
    private Integer lno;
    private Sale invno;
    private Employee salesman;
    private Inventory pid;
    private Integer quantity;
    private Double amt;

    public InvItems() {
    }

    public InvItems(Integer lno, Sale invno, Employee salesman, Inventory pid, Integer quantity, Double amt) {
        this.lno = lno;
        this.invno = invno;
        this.salesman = salesman;
        this.pid = pid;
        this.quantity = quantity;
        this.amt = amt;
    }

    public Integer getLno() {
        return lno;
    }

    public void setLno(Integer lno) {
        this.lno = lno;
    }

    public Sale getInvno() {
        return invno;
    }

    public void setInvno(Sale invno) {
        this.invno = invno;
    }

    public Employee getSalesman() {
        return salesman;
    }

    public void setSalesman(Employee salesman) {
        this.salesman = salesman;
    }

    public Inventory getPid() {
        return pid;
    }

    public void setPid(Inventory pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }
    
    @Override
    public String toString() {
        return "InvItems{" + "lno=" + lno + ", invno=" + invno + ", salesman=" + salesman + ", pid=" + pid + ", quantity=" + quantity + ", amt=" + amt + '}';
    }
}
