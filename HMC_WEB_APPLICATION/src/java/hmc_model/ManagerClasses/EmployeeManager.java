package hmc_model.ManagerClasses;
import java.time.LocalDate;
import hmc_model.Employee;
import hmc_model.Occupation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
* @author k_gsquared
*
*/
public class EmployeeManager implements HMCDBCRUD {  
    private final String empSeSQL = "SELECT * FROM employee ";
    private final String employeeInsertSQL = "INSERT INTO TABLE inventory VALUES(?,?,?)";
    private Employee employee;
    private Occupation empjob;
    private Connection conn; 
    private PreparedStatement ps            = null;
    private ResultSet rs                    = null;

    /*
    * no-args constructor instantiate an EmployeeManager class
    * with inventory manager partially set
    */
    public EmployeeManager(){
        conn     = null;
        employee = new Employee();
        empjob   = new Occupation();
    }
    
    /*
    * list all object in the database 
    *
    */
    public ArrayList<Employee> listTableRows() throws SQLException {
        // execute sql select statement 
        rs = executeDBSQL(empSeSQL, conn);
        ArrayList<Employee> listOfEmployees = new ArrayList<>();
        while(rs.next()) {
            Integer empno       = rs.getInt("empno");
            String fname        = rs.getString("fname");
            String mname        = rs.getString("nname");
            String lname        = rs.getString("lname");
            String phoneno      = rs.getString("phoneno");
            String email        = rs.getString("email");
            String gender       = rs.getString("gender");
            LocalDate hiredate  = LocalDate.parse(rs.getString("hiredate"));
            LocalDate birthdate = LocalDate.parse(rs.getString("birthdate"));
            Integer jobid       = rs.getInt("jobid");
            // set the job id to object 
            empjob.setJobid(jobid);
            
            // build employee object and add to list of employees
            employee.setEmpno(empno);
            employee.setFname(fname);
            employee.setMname(mname);
            employee.setLname(lname);
            employee.setPhoneno(phoneno);
            employee.setEmail(email);
            employee.setGender(gender);
            employee.setHiredate(hiredate);
            employee.setBirthdate(birthdate);
            employee.setJobid(empjob);            
            
            listOfEmployees.add(employee);
        }
       return listOfEmployees;
    }
    
     /*
    * @param Object represent an object in the database 
    * insert a new employee record in the database
    */
    @Override
    public void insertTableRow(Object obj) throws SQLException {
    }
    /**
     *
     * @param obj
     * @throws SQLException
     */

    @Override
    public void alterTableRow(Object obj) throws SQLException {
    }

    @Override
    public void setConnection(Connection conn) throws SQLException {
      this.conn = conn;
    }
} 
