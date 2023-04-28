package hmc_model.ManagerClasses;

import hmc_model.Occupation;
import java.sql.*;
import java.util.ArrayList;

/*
* OccupationManager manages stores employees logins 
* @author k_gsquared
* Date    23/04/2023
*/
public class OccupationManager implements HMCDBCRUD { 
    private Connection conn;
    private Occupation occ;
    private ResultSet rs;
    private PreparedStatement ps;
    private String occpInSQL;
    private String occpSeSQL;
    private String occpUpSQL;
    
    public OccupationManager() {        
        rs        = null;
        ps        = null;
        conn      = null;
        occpInSQL = "INSERT INTO TABLE login VALUES(?,?,?)";  
        occpSeSQL = "SELECT * FROM job";
        occpUpSQL = "UPDATE TABLE Occupation SET comm = ? WHERE jobid = ?";
        occ       = new Occupation();
    }
	    
    /*
    *@param database connection 
    */
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    	
    /*
    *@param ujob is the job role of the user who is trying to login
    *@return  return occupation with the job description set
    */
    public Occupation jobDesc(Occupation ujob) throws SQLException {
      ArrayList<Occupation> jobs = listTableRows();
        for(int i = 0; i < jobs.size(); i++)
          if(jobs.get(i).getJobid().equals(ujob.getJobid())) 
            ujob.setJobdesc(jobs.get(i).getJobdesc());   
        return ujob;
    }
  
    //---------------------------DATABASE DML OR CRUD METHODS------------------------------------//
    /*
    *
    *@param Occupation object that will be added as new row in the table
    */
    @Override
    public void insertTableRow(Object obj) throws SQLException {
        Occupation newocc     = (Occupation) obj;
        PreparedStatement ps  = executeDMLSQL(this.occpInSQL, this.conn);
        ps.setInt(1, newocc.getJobid());
        ps.setString(2, newocc.getJobdesc());
        ps.setDouble(3, newocc.getComm());
        updateTable(ps);
    }

    /*
    *@param obj is an object which must be altered in the database
    *@param colno column in the database to alter
    */
    @Override
    public void updateTableRow(Object obj, Integer colno) throws SQLException {
      Occupation updateocc = (Occupation) obj;
      PreparedStatement ps = executeDMLSQL(occpUpSQL, conn);
      if(colno == 1){
        ps.setInt(1, updateocc.getJobid());
        ps.setInt(1, updateocc.getJobid());
      } else if(colno == 2){
        ps.setInt(1, updateocc.getJobid()); // where clause - primary key 
        ps.setString(2, updateocc.getJobdesc());
      } else {
        ps.setInt(1, updateocc.getJobid());
        ps.setDouble(3, updateocc.getComm());
      }
      updateTable(ps);
    }

    /*
    * @return ArrayList<Occupation> in the database
    */
    public ArrayList<Occupation> listTableRows() throws SQLException {
        ResultSet rs                    = executeQuerySQL(this.occpSeSQL, this.conn);
        ArrayList<Occupation> listOfOcc = new ArrayList<>();
        while (rs.next()) {
                // confirm if user credentials exist in the database
                Integer jobid   = rs.getInt("jobid");
                String jobdesc  = rs.getString("jobdesc");
                Double comm     = rs.getDouble("comm");
                occ.setJobid(jobid);
                occ.setJobdesc(jobdesc);
                occ.setComm(comm);
                listOfOcc.add(occ);
          }
          return listOfOcc;
    }
    //-------------------------END DATABASE DML OR CRUD METHODS------------------------------------//
}
