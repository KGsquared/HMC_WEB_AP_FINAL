package hmc_model.ManagerClasses;

import hmc_model.Login;
import hmc_model.Occupation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
* LoginManager is a class which managers user logins against the logins credentials which are stored in the database
* @author k_gsquared
* Date    23-04-2023
*/
public class LoginManager implements HMCDBCRUD {
    private String loginSelectSQL ;
    private String loginInsertSQL;
    private String loginAlterSQL;
    private String loginUpdateSQL;
    private boolean loginIsCorrect;
    private Login login;
    private Connection conn;
    private OccupationManager occpMan;
    private Occupation occ;

    public LoginManager() {
        conn            = null;
        loginIsCorrect  = false; 
        // sql statements CRUD Statements
        loginInsertSQL  = "INSERT INTO TABLE login VALUES(?,?,?);";
        loginUpdateSQL  = "UPDATE TABLE login SET password = '?' WHERE username = '?';";
        loginSelectSQL  = "SELECT * FROM login;";
        occ     = new Occupation();
        login   = new Login();
        occpMan = new OccupationManager();
    }
    
    /* 
    *since the constructor does not implicitly set the connection object respectively with the method  
    *@return String representation of the type of user
    */
    public String getUserType() throws SQLException {
        return  new OccupationManager().jobDesc(occ).getJobdesc();
    }

    /* USER AUTHENTICATION METHOD  
    *@param Login - this the login credentials entered by the user
    *@return boolean value indicating whether the login credentials are correct
    */
    public boolean loginIsValid(Login ulogin) throws SQLException {
        // login details in the database
        ResultSet rs = executeQuerySQL(loginSelectSQL, conn);
        ArrayList<Login> credentialsInDB = listTableRows();
        while (rs.next()) {
                // confirm if user credentials exist in the database
                if (ulogin.getUsername().equals(rs.getString("username")) 
                     && ulogin.getPassword().equals(rs.getString("password"))) {
                       loginIsCorrect = true;
                       Integer jobid  = rs.getInt("jobid");
                       occ.setJobid(jobid);
                       ulogin.setOccupation(occ);
                       return loginIsCorrect;
                } 
        }
        return loginIsCorrect; // at this point the login might be invalidated 
    }
        
    /*
      @param database <b>conn</b> connection object
    */
    @Override
    public void setConnection(Connection conn){
        this.conn = conn;
    }

//-------------------------DATABASE DML Methods--------------------------------------------------//
    /*
    *
    * @return list of all login credentials stored in the database
    */
    public ArrayList<Login> listTableRows() throws SQLException {            
            // list of all users in the login table
            ArrayList<Login> loginCredentials = new ArrayList<Login>();
            ResultSet rs = executeQuerySQL(this.loginSelectSQL, this.conn);
            while (rs.next()) {
                // confirm if user credentials exist in the database
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                occ.setJobid(rs.getInt("jobid"));
                login.setOccupation(occ);
                // add object to db
                loginCredentials.add(login);
            } // end while loop
            return loginCredentials;
    }

    /*
    *
    * @param Login object 
    * insert new login details into the database//
    */
    @Override
    public void insertTableRow(Object obj) throws SQLException {
      Login newLogin       = (Login) obj;
      PreparedStatement ps = executeDMLSQL(loginInsertSQL, conn);
      ps.setString(1, newLogin.getUsername());
      ps.setString(2, newLogin.getPassword());
      ps.setInt(3, newLogin.getOccupation().getJobid());
      updateTable(ps);
    }
    
    /*
     * @param Login Object to alter and Column to alter, newvalue for that column
     * change login credentials already stored in the database
     * this method can change any property associated with this object 
    */
    @Override
    public void updateTableRow(Object obj, Integer columnno) throws SQLException {
      Login updatelogin     = (Login) obj;
      PreparedStatement ps  = executeDMLSQL(loginUpdateSQL, conn);
      if(columnno == 1) 
        ps.setString(1, updatelogin.getUsername()); 
      else if(columnno == 2)
        ps.setString(2, updatelogin.getPassword());
      else 
        ps.setInt(3, updatelogin.getOccupation().getJobid());
      // execute DML statement
      updateTable(ps);
    }
//----------------------------END DML methods------------------------------------------------//
}   
