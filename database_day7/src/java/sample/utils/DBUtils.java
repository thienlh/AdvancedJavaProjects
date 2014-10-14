/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author thienle
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        Connection cn;
        try {
            Context context = new InitialContext();
            Context serverContext = (Context) context.lookup("java:comp/env");
            
            DataSource ds = (DataSource) serverContext.lookup("ThienDS");
            cn = ds.getConnection();
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        
        
//        try {
//            //  1. Load driver using Class.forName()
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //  2. Connection String
//            //  protocol:servername://ip:port;databaseName=DBName;instanceName=adfasdf
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=ACCOUNT";
//            //  3. Establish
//            Connection cn = DriverManager.getConnection(url, "sa", "*9394lht#");
//            //  4. Return
//            return cn;
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        return null;
    }
}
