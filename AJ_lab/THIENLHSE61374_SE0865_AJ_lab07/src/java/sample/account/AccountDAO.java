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
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author thienle
 */
public class AccountDAO implements Serializable {

    private List<AccountDTO> listAccount;

    public boolean checkLogin(String username, String password) {
        //  Declare Connection
        Connection cn = null;
        //  Declare PreparedStatement
        PreparedStatement stm = null;
        //  Declare ResultSet
        ResultSet rs = null;

        try {
            //  Make connection using DBUtils
            cn = DBUtils.makeConnection();
            //  Make sql string
            String sql = "select * from TBL_Account where Username=? and Password=?";
            //  Create object 
            //  Truyen cau lenh co tham so, Obj lenh la gi???????
            stm = cn.prepareStatement(sql);
            //  Set parameters
            stm.setString(1, username);
            stm.setString(2, password);
            //  Execute string
            rs = stm.executeQuery();
            //  Your business
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //  Close ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //  Close PreparedStatement
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //  Close Connection
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void searchLikeName(String searchQuery) {
        //  Declare Connection
        Connection cn = null;
        //  Declare PreparedStatement
        PreparedStatement stm = null;
        //  Declare ResultSet
        ResultSet rs = null;

        try {
            //  Make connnection
            cn = DBUtils.makeConnection();
            //  Create sql string
            String sql = "select * from CEO where lastname like ?";
            //  Create object to pass parameter
            stm = cn.prepareStatement(sql);
            //  Set parameters
            stm.setString(1, "%" + searchQuery + "%");
            //  Execute query
            rs = stm.executeQuery();
            //  Your business
            listAccount = new ArrayList<AccountDTO>();

            while (rs.next()) {
                //  Get parameters
                String username = rs.getString("username");
                String password = rs.getString("password");
                String lastname = rs.getString("lastname");
                boolean isAdmin = rs.getBoolean("isAdmin");
                //  Create temporary object
                AccountDTO tmp = new AccountDTO(username, password, lastname, isAdmin);
                //  Save into list
                listAccount.add(tmp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //  close ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  close PreparedStatement
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  close Connection
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadInfo() {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //  1.  Get connection
            cn = DBUtils.makeConnection();
            //  2.  Prepare the sql string
            String sql = "SELECT * "
                    + "FROM TBL_Account";
            //  2.  Create object to pass the parameters
            stm = cn.prepareStatement(sql);
            //  3.  Set parameters
            //  4.  Connect
            rs = stm.executeQuery();
            //  5.  Your business
            //  Add product to list
            listAccount = new ArrayList<AccountDTO>();

            while (rs.next()) {
                //  Prepare fields
                String username = rs.getString("Username");
                String password = rs.getString("Username");
                String lastname = rs.getString("Lastname");
                boolean roles = rs.getBoolean("isAdmin");
                //  Add new product to list
                AccountDTO tmp = new AccountDTO(username, password, lastname, roles);
                listAccount.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //  Close ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  Close PrepareStatement
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  Close Connection
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public AccountDTO getUserInfo(String username) {
        //  Declare Connection
        Connection cn = null;
        //  Declare PreparedStatement
        PreparedStatement stm = null;
        //  Declare ResultSet
        ResultSet rs = null;

        try {
            //  Make connnection
            cn = DBUtils.makeConnection();
            //  Create sql string
            String sql = "select * from TBL_Account where username=?";
            //  Create object to pass parameter
            stm = cn.prepareStatement(sql);
            //  Set parameters
            stm.setString(1, username);
            //  Execute query
            rs = stm.executeQuery();
            //  Your business
            if (rs.next()) {
                String password = rs.getString("Password");
                System.out.println("Password=" + password);
                String lastName = rs.getString("Lastname");
                boolean role = rs.getBoolean("isAdmin");
                return new AccountDTO(username, password, lastName, role);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //  close ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  close PreparedStatement
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  close Connection
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<AccountDTO> getListAccount() {
        return listAccount;
    }
}
