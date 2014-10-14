/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.el;

import java.io.Serializable;

/**
 *
 * @author thienlh
 */
public class ELFunction implements Serializable {
    public static String info(String name, int age, boolean sex)    {
        return "Name" +name +"-"+age +"-"+ sex;
    }
}
