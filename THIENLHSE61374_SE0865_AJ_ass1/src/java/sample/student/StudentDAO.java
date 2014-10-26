/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.student;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sample.utils.DBUtil;

/**
 *
 * @author thienlh
 */
public class StudentDAO implements Serializable {

    List<StudentDTO> studentList;

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public List<StudentDTO> search(String classID, String block, String semester) {
        List<StudentDTO> result = null;

        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "";
        System.out.println(classID + block + semester);
        if (block == null) {
            if (semester == null) {
                //  Search by classID only
                sql = "SELECT p.studentID,s.lastName,s.middleName,s.studentName,p.subjectAvg,s.isHide"
                        + "FROM student s,"
                        + "(SELECT studentID,subjectAvg FROM personnel WHERE classID=?) p"
                        + "WHERE s.studentID=p.studentID";
            } else {
                //  Search by semester and classID
            }
        } else {
            if (semester.equals("All")) {
                //  Search by semester and classID
            } else {
                //  Search by semester, classID and block
            }
        }

        try {
            cn = DBUtil.makeConnection();

            stm = cn.prepareStatement(sql);
            stm.setString(1, classID);
            rs = stm.executeQuery();
            if (rs.next()) {
                String studentID = rs.getString("studentID");
                String studentName = rs.getString("studentName");
                String lastName = rs.getString("lastName");
                String midName = rs.getString("middleName");
                boolean isHide = rs.getBoolean("isHide");
                String avg = rs.getString("subjectAvg");

                StudentDTO tmp = new StudentDTO(studentID, studentName, lastName, midName, isHide, avg);
                studentList.add(tmp);
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

        return result;
    }
}
