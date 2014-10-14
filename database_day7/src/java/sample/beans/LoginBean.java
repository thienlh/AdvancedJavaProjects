/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.beans;

import java.io.Serializable;
import java.sql.SQLException;
import sample.account.AccountDAO;

/**
 *
 * @author thienlh
 */
public class LoginBean implements Serializable {

    private String username;
    private String password;

    public LoginBean() {
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkLogin() {
        AccountDAO dao = new AccountDAO();
        boolean result = dao.checkLogin(username, password);
        return result;
    }
}
