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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String sql = "select * from CEO where username=? and password=?";
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

    public List<AccountDTO> getListAccount() {
        return listAccount;
    }

    public boolean deleteAccount(String username) {
        //  Declare Connection
        Connection cn = null;
        //  Declare PreparedStatement
        PreparedStatement stm = null;

        try {
            //  1. Make connection
            cn = DBUtils.makeConnection();
            //  2. Create sql string
            String sql = "delete from CEO where username=?";
            //  3. Create object to pass the parameter
            stm = cn.prepareStatement(sql);
            //  4. Set parameters
            stm.setString(1, username);
            //  5. Execute query
            int row = stm.executeUpdate();
            //  6. Your business
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public boolean updateAccount(String username, String password, boolean roles) {
        //  Init Connection
        Connection cn = null;
        //  Init PreparedStatement
        PreparedStatement stm = null;
        try {
            //  1. Make connection
            cn = DBUtils.makeConnection();
            //  2. Create sql string
            String sql = "UPDATE CEO "
                    + "SET password=?, isAdmin=? "
                    + "WHERE username=?";
            //  3. Create object to pass the parameters
            stm = cn.prepareStatement(sql);
            //  4. Set parameters
            stm.setString(1, password);
            stm.setBoolean(2, roles);
            stm.setString(3, username);
            //  5. Execute query
            int row = stm.executeUpdate();
            //  6. Your business
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
    
    public boolean createAccount(String username, String password, String fullname, boolean roles)  {
        //  Init Connection
        Connection cn = null;
        //  Init PreparedStatement
        PreparedStatement stm = null;
        try {
            //  1. Make connection
            cn = DBUtils.makeConnection();
            //  2. Create sql string
            String sql = "insert into CEO(username, password, fullname, isAdmin) " + "Values(?,?,?,?)";
            //  3. Create object to pass the parameters
            stm = cn.prepareStatement(sql);
            //  4. Set parameters
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setBoolean(4, roles);
            //  5. Execute query
            int row = stm.executeUpdate();
            //  6. Your business
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
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
    
}
