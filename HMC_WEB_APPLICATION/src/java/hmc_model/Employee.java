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
public class Employee {
    
    private Integer empno;
    private String fname, mname,lname,phoneno,email,gender;
    private LocalDate hiredate,birthdate;
    private Occupation jobid;

    public Employee() {
    }

    public Employee(Integer empno, String fname, String mname, String lname, String phoneno, String email, String gender, LocalDate hiredate, LocalDate birthdate, Occupation jobid) {
        this.empno = empno;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.phoneno = phoneno;
        this.email = email;
        this.gender = gender;
        this.hiredate = hiredate;
        this.birthdate = birthdate;
        this.jobid = jobid;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Occupation getJobid() {
        return jobid;
    }

    public void setJobid(Occupation jobid) {
        this.jobid = jobid;
    }

    @Override
    public String toString() {
        return "Employee{" + "empno=" + empno + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", phoneno=" + phoneno + ", email=" + email + ", gender=" + gender + ", hiredate=" + hiredate + ", birthdate=" + birthdate + ", jobid=" + jobid + '}';
    }
}
