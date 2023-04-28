package hmc_controller;

import hmc_model.Login;
import hmc_model.ManagerClasses.LoginManager;
import hmc_model.ManagerClasses.ServiceManager;
import hmc_model.Service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author k_gsquared
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
    // statement to execute when user logs in 
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private RequestDispatcher rdp = null;
    private LoginManager loginmanager;
    private ServiceManager serviceManager;
    private ArrayList<Service> servList;
    private Login ulogin;
    

    public LoginServlet() {
        loginmanager = new LoginManager();
        serviceManager = new ServiceManager();
        servList = new ArrayList<>();
        ulogin = new Login();
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // current session of the user logged on
        HttpSession session = request.getSession();
        
        // username stored entered by the user
        String username = session.getAttribute("username").toString();
        String password = session.getAttribute("password").toString();
        
        // enscapulation of the class members 
   
        ulogin.setUsername(username);
        ulogin.setPassword(password);
        
        
        try {
            // Get The ServletContextListener 
            conn = (Connection) getServletContext().getAttribute("conn");
            
            
            loginmanager.setConnection(conn);

            // confirm the credentinals entered by the user
            if(loginmanager.loginIsValid(ulogin)) {
                // credentials entered are correct
                
                // open revelevant JSP page 
               
                    // confirm user type
                    // open JSP
                    if(loginmanager.getUserType().equalsIgnoreCase("cashier")) {        
                       
                       // getting last invoice number
                     
                       servList = serviceManager.listTableRows();      
		       // set list of all services in the database
                       session.setAttribute("servList", servList);
                       rdp = request.getRequestDispatcher("pos.jsp");
                    } 
                

                if(rdp != null) {
			rdp.forward(request, response);
		} else {
			System.err.println("print error message");
		}
            } 
        } catch (SQLException ex) {
               System.err.print("sql in login verification failed");
        }
    }
}// end class
