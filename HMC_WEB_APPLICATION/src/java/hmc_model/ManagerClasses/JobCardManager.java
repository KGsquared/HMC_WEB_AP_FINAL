package hmc_model.ManagerClasses;

import hmc_model.Employee;
import hmc_model.JobCard;
import hmc_model.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author k_gsquared
 */
public class JobCardManager implements HMCDBCRUD{
    
    private String saleSelectSQL     = "SELECT * FROM jobCard";
      private Connection conn   = null;
      private JobCard jobCard;
      private Employee employee;
      private Service service;
      private PreparedStatement ps  = null;
      private ResultSet rs = null;

    public JobCardManager() {
        this.service = new Service();
        this.jobCard = new JobCard();
        this.employee = new Employee();
    }

    @Override
    public ArrayList<?> listTableRows() throws SQLException {
         
      ArrayList<JobCard> listJobCard = new ArrayList<>();
          while (rs.next()) {
                
                Integer jobno = rs.getInt("jobno");
                String date= rs.getString("date"); // change the invdate data type in database to Date
                String regno = rs.getString("regno");
                String model = rs.getString("model");
                Integer serviceid = rs.getInt("servid");
                
                service.setService_id(serviceid);
                String phone = rs.getString("phone");
                String driver = rs.getString("driver"); // In the database you made hiredate have a datatype of varchar change it to date to match with the class data type of set hiredate
                Integer mechanicid = rs.getInt("mechanicid");
                
                employee.setEmpno(mechanicid);
                
                Double amt = rs.getDouble("amt");  // change data type to double in the database;
                
                jobCard.setJobno(jobno);
                jobCard.setJobdate(LocalDate.MAX); // change data type in the database
                jobCard.setRegno(regno);
                jobCard.setModel(model); // change data type in database to match with the on in the setter method.                
                jobCard.setServid(service);
                jobCard.setPhone(phone);
                jobCard.setDriver(driver);
                jobCard.setMechanic(employee);// it takes in an employee object
                jobCard.setAmt(Double.NaN);
                listJobCard.add(jobCard);
          }
          return listJobCard;
    }


    @Override
    public void insertTableRow(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConnection(Connection conn) throws SQLException {
        this.conn = conn;
    }

    @Override
    public void updateTableRow(Object obj, Integer colno) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
