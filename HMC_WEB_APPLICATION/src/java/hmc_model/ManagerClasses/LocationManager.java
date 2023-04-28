/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmc_model.ManagerClasses;

import hmc_model.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class LocationManager implements HMCDBCRUD {
    
     private String expSelectSQL     = "SELECT * FROM location";
      //private String loginInsertSQL   = "INSERT INTO TABLE login VALUES(?,?,?)";
      private Connection conn   = null;
      private Location  location;
      private PreparedStatement ps  = null;
      private ResultSet rs = null;

    public LocationManager() {
        
        location  = new Location();
    }

    @Override
    public ArrayList<?> listTableRows() throws SQLException {
       
         ArrayList<Location> listLocation = new ArrayList<>();
          while (rs.next()) {
                
                Integer locid = rs.getInt("locid");
                String locdesc = rs.getString("locdesc");
               
                location.setLocid(locid);
                location.setLocdesc(locdesc);
               
                
                listLocation.add(location);
          }
          return listLocation;
        
    }

    @Override
    public void setConnection(Connection conn) {
     this.conn = conn;   
    }

    @Override
    public void insertTableRow(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterTableRow(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
