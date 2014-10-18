/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author thienlh
 */
public interface AccountSessionBeanRemoteHome extends EJBHome{
    AccountSessionBeanRemote create() throws CreateException, RemoteException;
}
