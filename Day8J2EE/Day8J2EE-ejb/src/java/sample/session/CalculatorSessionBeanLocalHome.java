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
public interface CalculatorSessionBeanLocalHome extends EJBLocalHome {
    
    sample.session.CalculatorSessionBeanLocal create() throws CreateException;
}
