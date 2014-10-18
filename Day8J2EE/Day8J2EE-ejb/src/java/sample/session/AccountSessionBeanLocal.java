/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.session;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author thienlh
 */
public interface AccountSessionBeanLocal extends EJBLocalObject {

    boolean checkLogin(String username, String password);
    
}
