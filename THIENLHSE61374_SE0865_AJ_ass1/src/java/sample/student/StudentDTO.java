/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.student;

import java.io.Serializable;

/**
 *
 * @author thienlh
 */
public class StudentDTO implements Serializable {

    private String studentID;
    private String studentName;
    private String lastName;
    private String midName;
    private boolean isHide;
    private String avg;

    public StudentDTO() {
    }

    public StudentDTO(String studentID, String studentName, String lastName, String midName, boolean isHide, String avg) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.lastName = lastName;
        this.midName = midName;
        this.isHide = isHide;
        this.avg = avg;
    }

    /**
     * @return the studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the midName
     */
    public String getMidName() {
        return midName;
    }

    /**
     * @param midName the midName to set
     */
    public void setMidName(String midName) {
        this.midName = midName;
    }

    /**
     * @return the isHide
     */
    public boolean isIsHide() {
        return isHide;
    }

    /**
     * @param isHide the isHide to set
     */
    public void setIsHide(boolean isHide) {
        this.isHide = isHide;
    }

    /**
     * @return the avg
     */
    public String getAvg() {
        return avg;
    }

    /**
     * @param avg the avg to set
     */
    public void setAvg(String avg) {
        this.avg = avg;
    }
    
}
