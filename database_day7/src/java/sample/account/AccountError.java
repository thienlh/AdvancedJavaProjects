/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.account;

import java.io.Serializable;

/**
 *
 * @author thienle
 */
public class AccountError implements Serializable {

    private String usernameErrs;
    private String passwordErrs;
    private String confirmErrs;
    private String lastnameErrs;
    private String duplicateUsername;

    public AccountError() {
    }

    public AccountError(String usernameErrs, String passwordErrs, String confirmErrs, String lastnameErrs, String duplicateUsername) {
        this.usernameErrs = usernameErrs;
        this.passwordErrs = passwordErrs;
        this.confirmErrs = confirmErrs;
        this.lastnameErrs = lastnameErrs;
        this.duplicateUsername = duplicateUsername;
    }

    /**
     * @return the usernameErrs
     */
    public String getUsernameErrs() {
        return usernameErrs;
    }

    /**
     * @param usernameErrs the usernameErrs to set
     */
    public void setUsernameErrs(String usernameErrs) {
        this.usernameErrs = usernameErrs;
    }

    /**
     * @return the passwordErrs
     */
    public String getPasswordErrs() {
        return passwordErrs;
    }

    /**
     * @param passwordErrs the passwordErrs to set
     */
    public void setPasswordErrs(String passwordErrs) {
        this.passwordErrs = passwordErrs;
    }

    /**
     * @return the confirmErrs
     */
    public String getConfirmErrs() {
        return confirmErrs;
    }

    /**
     * @param confirmErrs the confirmErrs to set
     */
    public void setConfirmErrs(String confirmErrs) {
        this.confirmErrs = confirmErrs;
    }

    /**
     * @return the duplicateUsername
     */
    public String getDuplicateUsername() {
        return duplicateUsername;
    }

    /**
     * @param duplicateUsername the duplicateUsername to set
     */
    public void setDuplicateUsername(String duplicateUsername) {
        this.duplicateUsername = duplicateUsername;
    }

    /**
     * @return the lastnameErrs
     */
    public String getLastnameErrs() {
        return lastnameErrs;
    }

    /**
     * @param lastnameErrs the lastnameErrs to set
     */
    public void setLastnameErrs(String lastnameErrs) {
        this.lastnameErrs = lastnameErrs;
    }

}
