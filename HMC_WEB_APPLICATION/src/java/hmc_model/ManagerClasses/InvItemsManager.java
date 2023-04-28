package hmc_model.ManagerClasses;

import hmc_model.Employee;
import hmc_model.InvItems;
import hmc_model.Inventory;
import hmc_model.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
*
* InvItemsManager manages DB CRUD operations associated with the InvItems object or db table
* @author k_gsquared
* 23-04-23
*/
public class InvItemsManager implements HMCDBCRUD {
    private final String invItemsSelectSQL = "SELECT * FROM employee ;";
    private final String invItemsInsertSQL = "INSERT INTO TABLE inventory VALUES(?,?,?);";
    private InvItems invItem;
    private Sale sale;
    private Employee salesman;
    private Inventory pid;
    private PreparedStatement ps            = null;
    private ResultSet rs                    = null; 
    private Connection conn;
     
     
    /**instantiate the InvItemsManager with some of the fields partially set**/ 
    public InvItemsManager() {
      invItem   = new InvItems();
      sale      = new Sale();
      salesman  = new Employee();
      pid       = new Inventory();
    }
     
     /*
    * list all object in the database 
    * @return ArrayList<InvItems> returns a list of invitems 
    */
    @Override
    public ArrayList<InvItems> listTableRows() throws SQLException {
      ps = conn.prepareStatement(invItemsSelectSQL);
      rs = ps.executeQuery();
      
      // list of all invitems
      ArrayList<InvItems> invItems = new ArrayList<>();
      
      while(rs.next()){
        Integer lno = rs.getInt("lno");
        sale.setInvno(rs.getInt("invno"));
        salesman.setEmpno(rs.getInt("empno"));
        pid.setPid(rs.getInt("pid"));
        Double amt  = rs.getDouble("amt");
        Integer quantity = rs.getInt("qty");
        // build InvItems add it to the database
        invItem.setLno(lno);
        invItem.setInvno(sale);
        invItem.setSalesman(salesman);
        invItem.setPid(pid);
        invItem.setAmt(amt);
        
        // add invitems to list of invoice items 
        invItems.add(invItem);
      }
      return invItems;
    }
    


    @Override
    public void insertTableRow(Object obj) throws SQLException {
    }

    @Override
    public void updateTableRow(Object obj) throws SQLException {
    }

    @Override
    public void setConnection(Connection conn) throws SQLException {
        this.conn = conn;
    }
} // END InvItemManager
