/*
 * This class Is Intented Control the enventory items and
 * Searches the inventory 
 * Also ensures that items are updated accordingly 
 */
package hmc_model.ManagerClasses;

import hmc_model.Employee;
import hmc_model.Inventory;
import hmc_model.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author k_gsquared
 */
public class InventoryManager implements HMCDBCRUD{
    private String saleSelectSQL;
    private Connection conn;
    private Inventory inventory;
    private Employee emp;
    private Location location;
    private PreparedStatement ps;
    private ResultSet rs;

    public InventoryManager() {
        conn      = null;
        ps        = null;
        rs        = null;
        invtSeSQL = "SELECT * FROM inventory";
        // foreign keys in the table 
        inventory = new Inventory();
        emp       = new Employee();
        location  = new Location();
    }
    
    @Override
    public void setConnection(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertTableRow(Object obj) throws SQLException {
          
    }

    @Override
    public void alterTableRow(Object obj) throws SQLException {
    
    }
    
    @Override
    public ArrayList<Inventory> listTableRows() throws SQLException {
          rs = executeDBSQL(invtSeSQL, conn);
          ArrayList<Inventory> listInventory = new ArrayList<>();
          while (rs.next()) {
                // obtain a column from the results set
                Integer pid   = rs.getInt("pid");
                String brand  = rs.getString("brand"); 
                String cond   = rs.getString("cond");
                String desc   = rs.getString("desc");
                Integer locid = rs.getInt("locid");
                // field which represents the foreign key in the location table
                location.setLocid(locid);
                Double cost   = rs.getDouble("cost");
                Double price  = rs.getDouble("price");
                Integer qty   = rs.getInt("qty");
                
                // build inventory object
                inventory.setPid(pid);
                inventory.setBrand(brand);
                inventory.setCond(cond);
                inventory.setDescription(desc);
                // the location object only has reference to the foreign key in this table, of course the integer foreign the location id
                inventory.setLocid(location); 
                inventory.setCost(cost);
                inventory.setPrice(price);
                inventory.setQuantity(qty);
                // add inventory to the list
                listInventory.add(inventory);
          }
          return listInventory;     
    }
}
