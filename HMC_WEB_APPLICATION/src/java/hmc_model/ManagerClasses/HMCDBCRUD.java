package hmc_model.ManagerClasses;

// import all classes associated with this object 
import java.sql.*;
import java.util.ArrayList;

/**
 * HMC Database CRUD 
 * Declaration of this class depends on the implementing class or classes which needs services of this Interface
 * @author k_gsquared
 */
public interface HMCDBCRUD {
    /*
    * @return list of table rows in the database
    */   
    public ArrayList<?> listTableRows() throws SQLException;
    
    /*
    * @param an object which represents a single row in db tables
    * inserts a single row in the database
    */
    public void insertTableRow(Object obj) throws SQLException;
    
    /*
    * @param object to alter, property to alter, newValue
    * an object here represents table that is in the table
    */
    public void updateTableRow(Object obj, Integer colno) throws SQLException;
    
    /*
    * @param database connection
    * assigns DB connection to this object 
    */
    public void setConnection(Connection conn) throws SQLException;
    
    /*
    * @param String SQL statement to execute 
    * @return ResultSet for the statement exec
    * FOR USE WITH DATABASE SELECT STATEMENTS
    */
    default ResultSet executeQuerySQL(String SQL, Connection conn) {
      PreparedStatement ps;
      ResultSet rs;          
      try {
        ps  = conn.prepareStatement(SQL);
        rs                    = ps.executeQuery();
        return rs;
      } catch(SQLException e) {
          System.err.println("an error occured while executing statement in the database \n" + e);
          return null;
      } 
    }
    
    /*
    *@param SQL statement to execute
    *@param Conn database connection assigned to this object
    *@return PreparedStatement 
    *FOR USE WITH DATABASE DML
    */
    default PreparedStatement executeDMLSQL(String SQL, Connection conn) throws SQLException {
      return conn.prepareStatement(SQL);
    }  
    
    /*
    *@param PreparedStatement
    *@return Integer representation of the number of columns affected the table
    *FOR USE DATABASE DML
    */
    default void updateTable(PreparedStatement ps) throws SQLException {
      int counter = ps.executeUpdate();
      if(counter >= 1) {
        System.out.println("rows changed");
      } else {
        System.out.println("no rows changed");
      }
    } 
}

