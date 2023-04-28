/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmc_model.ManagerClasses;

import hmc_model.Payment;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class PaymentManager implements HMCDBCRUD{

     private String paySelectSQL     = "SELECT * FROM payments";
      //private String loginInsertSQL   = "INSERT INTO TABLE login VALUES(?,?,?)";
      private Connection conn = null;
      private Payment  payment;
      private PreparedStatement ps    = null;
      private ResultSet rs            = null;

    public PaymentManager() {
        
        payment = new Payment();
    }
   
      
      
    @Override
    public ArrayList<?> listTableRows() throws SQLException {
   
        ArrayList<Payment> listPayMents = new ArrayList<>();
          while (rs.next()) {
                
                Integer payid = rs.getInt("payid");
                Date date = rs.getDate("date");
                String  method = rs.getString("method");
                Double  amt = rs.getDouble("amt");
                String paydesc = rs.getString("desc");
                
                payment.setPayid(payid);
                payment.setDate(date.toLocalDate());
                payment.setMethod(method);
                payment.setAmt(amt);
                payment.setDescription(paydesc);
                
                listPayMents.add(payment);
          }
          return listPayMents;
    }

    @Override
    public void insertTableRow(Object obj) throws SQLException {
    
    }

    @Override
    public void alterTableRow(Object obj) throws SQLException {
   
    }

    @Override
    public void setConnection(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
