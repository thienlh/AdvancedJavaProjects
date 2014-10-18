/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.session;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author thienlh
 */
public interface AccountSessionBeanRemote extends EJBObject {
    boolean checkLogin(String username, String password) throws RemoteException;
}
