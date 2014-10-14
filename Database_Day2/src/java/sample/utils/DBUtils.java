/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp.DriverManagerConnectionFactory;

/**
 *
 * @author thienle
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        try {
            //  Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //  Connection String
            //  protocol:servername://ip:port;databaseName=DBName;instanceName=adfasdf
            String url = "jdbc:sqlserver://localhost:1433;databaseName=THIEN";
            //  Establish
            Connection cn = DriverManager.getConnection(url, "sa", "*9394lht#");
            //  Return
            return cn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
