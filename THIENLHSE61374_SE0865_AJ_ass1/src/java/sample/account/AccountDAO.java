/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtil;

/**
 *
 * @author thienlh
 */
public class AccountDAO implements Serializable {

    public boolean checkLogin(String username, String password) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            cn = DBUtil.makeConnection();
            System.out.println("Connection=" + cn);
            String sql = "select * from account where username=? and password=? and isLeader='true'";
            stm = cn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);

            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
    
    public String getBlockSemester()    {
        
    }
}
