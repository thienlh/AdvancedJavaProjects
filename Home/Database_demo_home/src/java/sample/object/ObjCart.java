/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.object;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author thienle
 */
public class ObjCart implements Serializable {

    private String customerID;
    private HashMap<String, Integer> items;

    public ObjCart() {
        this.customerID = "0000";
        this.items = new HashMap<String, Integer>();
    }

    public ObjCart(String customerID) {
        this.customerID = customerID;
        this.items = new HashMap<String, Integer>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void addItem(String title) {
        int quantity = 1;
        if (items.containsKey(title)) {
            quantity = items.get(title) + 1;
        }
        items.put(title, quantity);
    }

    public void removeItem(String title) {
        if (items.containsKey(title)) {
            items.remove(title);
        }
    }
}
