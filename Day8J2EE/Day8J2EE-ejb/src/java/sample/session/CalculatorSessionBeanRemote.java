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
public interface CalculatorSessionBeanRemote extends EJBObject {
    double add(double num1, double num2) throws RemoteException;
    double substract(double num1, double num2) throws RemoteException;
}
