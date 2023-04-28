/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmc_model;

/**
 *
 * @author Approve
 */
public class Expense {
    private Integer expno;
    private Integer docno;
    private String description;
    private Double totalamt;

    public Expense() {
    }
    
    public Expense(Integer expno, Integer docno, String description, Double totalamt) {
        this.expno = expno;
        this.docno = docno;
        this.description = description;
        this.totalamt = totalamt;
    }
    
    
    
    public Integer getExpno() {
        return expno;
    }

    public void setExpno(Integer expno) {
        this.expno = expno;
    }

    public Integer getDocno() {
        return docno;
    }

    public void setDocno(Integer docno) {
        this.docno = docno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Double totalamt) {
        this.totalamt = totalamt;
    }

    @Override
    public String toString() {
        return "Expense{" + "expno=" + expno + ", docno=" + docno + ", description=" + description + ", totalamt=" + totalamt + '}';
    }
    
    
}
