/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.Registration;

import java.io.Serializable;

/**
 *
 * @author thienle
 */
public class RegistrationDTO implements Serializable    {
    //  Deaclare all feild not public
    private String username;
    private String password;
    private String lastName;
    private Boolean roles;
    //  Getter and setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getRoles() {
        return roles;
    }

    public void setRoles(Boolean roles) {
        this.roles = roles;
    }

    //  Default constructor
    public RegistrationDTO() {
    }

    public RegistrationDTO(String username, String password, 
            String lastName, Boolean roles) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.roles = roles;
    }
    
}
