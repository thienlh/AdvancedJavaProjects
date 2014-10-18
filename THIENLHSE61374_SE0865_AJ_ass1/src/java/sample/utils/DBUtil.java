/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author thienlh
 */
public class DBUtil implements Serializable {

    //  Lay context hien hanh
    //  Lookup server context
    //  Lookup datasource
    //  Get connection
    //  Return
    public static Connection makeConnection() {
        Context context;
        DataSource ds;
        Connection cn;
        try {
            context = new InitialContext();
            if (context != null) {
                Context serverContext = (Context) context.lookup("java:comp/env");
                if (serverContext != null) {
                    ds = (DataSource) serverContext.lookup("ThienDS");
                    cn = ds.getConnection();
                    return cn;
                }
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
