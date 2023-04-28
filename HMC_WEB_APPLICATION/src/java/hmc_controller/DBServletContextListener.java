package hmc_controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;

/**
 *
 * @author k_gsquared
 */
public class DBServletContextListener implements ServletContextListener {

    private Connection conn = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        // getting the database connection using servlet context parameter in web.xml file
        String url = sc.getAttribute("db").toString();

        try {
            conn = DriverManager.getConnection(url);
            sc.setAttribute("conn", conn);

        } catch (SQLException e) {
            System.err.println("database did not connect");
        }

    }

    /*
    * @param ServletContextEvent represents an object of ServletContextEvent
    * closes the database clonnection and destroys the objects of the manager class
    */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // close the database connection
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("something went wrong closing the database");
            }
        }
    }
} // end DBServletContextListener
