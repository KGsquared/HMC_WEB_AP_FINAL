/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmc_model;

import hmc_model.Location;

/**
 *
 * @author Approve
 */
public class Inventory {
    private Integer pid;
    private String brand;
    private String cond;
    private String description;
    private Location locid;
    private Double cost;
    private Double price;
    private Double vat;
    private Integer quantity;
    
    public Inventory() {
    }

    public Inventory(Integer pid, String brand, String cond, String description, Location locid, Double cost, Double price, Double vat, Integer quantity) {
        this.pid = pid;
        this.brand = brand;
        this.cond = cond;
        this.description = description;
        this.locid = locid;
        this.cost = cost;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }
    
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocid() {
        return this.locid;
    }

    public void setLocid(Location locid) {
        this.locid = locid;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "inventory{" + "pid=" + pid + ", brand=" + brand + ", cond=" + cond + ", description=" + description + ", locid=" + locid + ", cost=" + cost + ", price=" + price + ", vat=" + vat + ", quantity=" + quantity + '}';
    }
}
