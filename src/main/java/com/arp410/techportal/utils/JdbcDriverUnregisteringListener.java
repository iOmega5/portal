package com.arp410.techportal.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


/**
 * Application shutdown listener which unregistering a JDBC driver to prevent having errors while Tomcat stopping the
 * application.
 *
 * @author Leonid Kazancev
 * @see <a href="https://issues.apache.org/jira/browse/DBCP-332">Apache.org</a>
 */
@WebListener
public class JdbcDriverUnregisteringListener implements ServletContextListener {

    /**
     * Instance of this class created like any other {@link ServletContextListener} on application startup.
     * We can manage order of call {@link #contextInitialized(ServletContextEvent)} and
     * {@link #contextDestroyed(ServletContextEvent)} via {@code web.xml}. But servlet container (like Tomcat) creates
     * all instances of listeners together.
     *
     * <p>So, if we initialize logger field ordinary (by class field in listener),
     * then it will be initialized before first {@link #contextInitialized(ServletContextEvent)} and we lose
     * opportunity to initialize system properties (like {@code LOG_FILE}) via
     * {@link org.jtalks.poulpe.web.listener.LoggerInitializationListener LoggerInitializationListener}</p>
     *
     * <p><b>Best practices is</b>: Do not directly initialize fields of servlet listeners. Use
     * {@link #contextInitialized(ServletContextEvent)} and {@link #contextDestroyed(ServletContextEvent)} methods</p>
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        deregisterDrivers(getDrivers());
    }

    /**
     * Retrieves an Enumeration with all of the currently loaded JDBC drivers.
     *
     * @return the list of JDBC Drivers
     */
    Enumeration<Driver> getDrivers() {
        return DriverManager.getDrivers();
    }

    /**
     * Unregistering JDBC drivers given as param.
     *
     * @param drivers {@link Enumeration} of {@link Driver} to unregister
     */
    void deregisterDrivers(Enumeration<Driver> drivers) {
        while (drivers.hasMoreElements()) {
            deregisterDriver(drivers.nextElement());
        }
    }

    /**
     * Unregistering single JDBC driver given as param.
     *
     * @param driver to unregister
     */
    void deregisterDriver(Driver driver) {
        try {
            DriverManager.deregisterDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
