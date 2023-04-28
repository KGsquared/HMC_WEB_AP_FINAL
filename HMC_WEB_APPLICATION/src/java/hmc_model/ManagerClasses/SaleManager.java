/*

 */
package hmc_model.ManagerClasses;

import hmc_model.Employee;
import hmc_model.Sale;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author k_gsquared
 */
public class SaleManager implements HMCDBCRUD{
    private String saleSelectSQL;
    private Connection conn;
    private Sale sale;
    private Employee emp;

    public SaleManager() {
        rs            = null;
        ps            = null;
        conn          = null;
        saleSelectSQL = "SELECT * FROM sale";
        this.sale = new Sale();
        this.emp  = new Employee();
    }

    @Override
    public ArrayList<?> listTableRows() throws SQLException {
          rs = executeDBSQL(this.saleSelectSQL, this.conn)
          ArrayList<Sale> listSale = new ArrayList<>();
          while (rs.next()) {
                Integer invno   = rs.getInt("invno");
                Date invdate    = rs.getDate("invdate"); // change the invdate data type in database to Date
                Integer capture = rs.getInt("capture");
                emp.setEmpno(capture);
                // set inv properties
                sale.setInvno(invno);
                sale.setInvdate(invdate.toLocalDate());
                sale.setCapture(emp);
                // add sale to the lists
                listSale.add(sale);
          }
          return listSale;
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
}
