/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.personnel;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtil;

/**
 *
 * @author thienlh
 */
public class personnelDAO implements Serializable {

    String delimeter = "-";
    List<String> blockList = null;
    List<String> semesterList = null;

    public List<String> getBlockList() {
        return blockList;
    }

    public List<String> getSemesterList() {
        return semesterList;
    }

    public void getBlockSemester() {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            cn = DBUtil.makeConnection();
            String sql = "select blockSemester from personnel";
            stm = cn.prepareStatement(sql);
            rs = stm.executeQuery();
            blockList = new ArrayList<String>();
            semesterList = new ArrayList<String>();
            while (rs.next()) {
                String value = rs.getString("blockSemester");
                blockList.add(value.split(delimeter)[0]);
                semesterList.add(value.split(delimeter)[1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public float getAvg(String studentID) {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            cn = DBUtil.makeConnection();
            String sql = "select subjectAvg from personnel where studentID=?";
            stm = cn.prepareStatement(sql);
            stm.setString(1, studentID);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getFloat("subjectAvg");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return 0;
    }
}
