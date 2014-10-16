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
 * @author thienle
 */
public class DBUtils implements Serializable {

    public static Connection makeConnection() {
        Connection cn;
        DataSource ds;
        try {
            Context context = new InitialContext();
            Context serverContext = (Context) context.lookup("java:comp/env");

            ds = (DataSource) serverContext.lookup("ThienDS");
            cn = ds.getConnection();
            return cn;
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
