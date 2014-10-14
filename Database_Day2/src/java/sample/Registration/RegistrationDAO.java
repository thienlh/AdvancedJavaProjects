/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author thienle
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String username, String password) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //  Tao connection    
            cn = DBUtils.makeConnection();
            //  Tao cau lenh sql
            String sql = "select * from HUNGTHIEN where username=? and password=?";
            //  Tao object lenh
            //  Truyen cau lenh co tham so, Obj lenh la gi? 
            stm = cn.prepareStatement(sql);
            //  Thiet lap tham so
            stm.setString(1, username);
            stm.setString(2, password);

            //  Thuc thi cau lenh
            rs = stm.executeQuery();

            //  Xu li
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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

    private List<RegistrationDTO> listAccount;

    public void searchLikeLastname(String name) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //  Tao connection    
            cn = DBUtils.makeConnection();
            //  Tao cau lenh sql
            String sql = "select * from HUNGTHIEN where lastname LIKE ?";
            //  Tao object lenh
            //  Truyen cau lenh co tham so, Obj lenh la gi? 
            stm = cn.prepareStatement(sql);
            //  Thiet lap tham so
            stm.setString(1, "%" + name + "%");
            //  Thuc thi cau lenh
            rs = stm.executeQuery();

            //  Xu li
            listAccount = new ArrayList<RegistrationDTO>();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String lastname = rs.getString("lastname");
                boolean roles = rs.getBoolean("isAdmin");

                RegistrationDTO tmp = new RegistrationDTO(username, password, lastname, roles);
                listAccount.add(tmp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
    }

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    public boolean deleteAcount(String username) {

        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //  Tao connection    
            cn = DBUtils.makeConnection();
            //  Tao cau lenh sql
            String sql = "delete from HUNGTHIEN where username=?";
            //  Tao object lenh
            //  Truyen cau lenh co tham so, Obj lenh la gi? 
            stm = cn.prepareStatement(sql);
            //  Thiet lap tham so
            stm.setString(1, username);
            //  Thuc thi cau lenh
            int row = stm.executeUpdate();
            //  Xu li
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
    
    public boolean updatePassRoles(String username, String password, boolean roles) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //  Tao connection    
            cn = DBUtils.makeConnection();
            //  Tao cau lenh sql
            String sql = "update HUNGTHIEN set password=?, isAdmin=?"
                    + " where username=?";
            //  Tao object lenh
            //  Truyen cau lenh co tham so, Obj lenh la gi? 
            stm = cn.prepareStatement(sql);
            //  Thiet lap tham so
            stm.setString(1, password);
            stm.setBoolean(2, roles);
            stm.setString(3, username);
            
            //  Thuc thi cau lenh
            int row = stm.executeUpdate();
            //  Xu li
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

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
    
}
