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
public interface CalculatorSessionBeanLocal extends EJBLocalObject {
    double add(double num1, double num2);
    double substract(double num1, double num2);
}
