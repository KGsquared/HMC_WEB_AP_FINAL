/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmc_model;

/**
 *
 * @author Approve
 */
public class Location {
    private Integer locid;
    private String locdesc;

    public Location() {
    }

    public Location(Integer locid, String locdesc) {
        this.locid = locid;
        this.locdesc = locdesc;
    }

    public Integer getLocid() {
        return locid;
    }

    public void setLocid(Integer locid) {
        this.locid = locid;
    }

    public String getLocdesc() {
        return locdesc;
    }

    public void setLocdesc(String locdesc) {
        this.locdesc = locdesc;
    }

    @Override
    public String toString() {
        return "Location{" + "locid=" + locid + ", locdesc=" + locdesc + '}';
    }
    
}
