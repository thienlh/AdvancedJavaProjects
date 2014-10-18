/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.session;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author thienlh
 */
public interface AccountSessionBeanLocalHome extends EJBLocalHome {
    
    sample.session.AccountSessionBeanLocal create() throws CreateException;
}
