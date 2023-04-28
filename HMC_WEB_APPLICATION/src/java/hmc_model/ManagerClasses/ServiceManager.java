
package hmc_model.ManagerClasses;

import hmc_model.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceManager implements HMCDBCRUD{

     private String paySelectSQL = "SELECT * FROM services";
      //private String loginInsertSQL   = "INSERT INTO TABLE login VALUES(?,?,?)";
      private Connection conn = null;
      private Service  service;
      private PreparedStatement ps = null;
      private ResultSet rs = null;

    public ServiceManager() {
        service = new Service();
    }
  
    @Override
    public ArrayList<Service> listTableRows() throws SQLException {
    
         ArrayList<Service> listservices = new ArrayList<>();
          while (rs.next()) {
                
                Integer servid = rs.getInt("servid");
                String desc = rs.getString("desc");
                Double price = rs.getDouble("price");
               
                service.setService_id(servid);
                service.setDescription(desc);
                service.setPrice(price);
                
                listservices.add(service);
          }
          return listservices;
        
    }
    
    @Override
    public void setConnection(Connection conn) {
       this.conn = conn;
    }
 
    @Override
    public void insertTableRow(Object obj) throws SQLException {
        
    }
  
    @Override
    public void updateTableRow(Object obj, Integer colno) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
