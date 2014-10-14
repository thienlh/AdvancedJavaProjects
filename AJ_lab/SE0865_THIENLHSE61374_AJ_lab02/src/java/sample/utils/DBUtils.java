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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thienle
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        try {
            //  1.  Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //  2.  Prepare connection string
            //  protocol:servername://ip:port;databaseName=""
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=THIENLHSE61374";
            //  3.  Establish
            Connection cn = DriverManager.getConnection(url,"sa","*9394lht#");
            //  4.  Return
            return cn;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
