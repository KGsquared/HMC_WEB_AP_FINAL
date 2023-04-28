/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmc_model;

/**
 *
 * @author Approve
 */
public class Service {
    
    private String description;
    private Integer service_id;
    private Double vat;
    private Double price;
    
    public Service(){
        description="";
        service_id=0;
        vat=0.0;
        price=0.0;
    }

    public Service(String description, int service_id, double vat, double price) {
        this.description = description;
        this.service_id = service_id;
        this.vat = vat;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
