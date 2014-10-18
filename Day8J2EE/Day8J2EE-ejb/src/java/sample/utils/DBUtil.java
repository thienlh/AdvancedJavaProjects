/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author thienlh
 */
public class DBUtil implements Serializable {

    public static Connection makeConnection(SessionContext currentContext, String dataSourceName) {
        //  Lay context hien hanh
        DataSource ds = null;
        Connection cn = null;
        ds = (DataSource) currentContext.lookup(dataSourceName);
        if (ds != null) {
            //  Lookup DataSource
            try {
                cn = ds.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return cn;
    }
}
