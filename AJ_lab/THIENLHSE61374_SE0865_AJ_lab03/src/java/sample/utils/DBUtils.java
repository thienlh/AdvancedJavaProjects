/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thienlh
 */
public class DBUtils {

    public static Connection makeConnection() {
        try {
            //  1.  Init Connection
            Connection cn = null;
            //  2.  Init connection string
            String url =  "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=THIENLHSE61374_SE0865_AJ_lab03";
                
                //  1.  Load the driver
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //  2.  Connect
                cn = DriverManager.getConnection(url, "sa", "*9394lht#");
                //  3.  Return
                return cn;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
