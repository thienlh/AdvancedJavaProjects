/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.SessionContext;
import javax.sql.DataSource;
import sample.utils.DBUtil;

/**
 *
 * @author thienlh
 */
public class AccountDAO implements Serializable {

    public boolean checkLogin(String username, String password, SessionContext context, String dsName) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtil.makeConnection(context, dsName);
            String sql = "select * from CEO where username=? and password=?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return false;
    }
}
