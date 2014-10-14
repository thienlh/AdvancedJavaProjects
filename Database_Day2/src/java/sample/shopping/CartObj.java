/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;

/**
 *
 * @author thienle
 */
public class CartObj {
    //  Fields
    private String customerID;
    private HashMap<String, Integer> items; //  There is an 's' for a reason!
    //  Constructor
    public CartObj() {
        this.customerID = "0000";
        this.items = new HashMap<String, Integer>();
    }

    public CartObj(String customerID) {
        this.customerID = customerID;
        this.items = new HashMap<String, Integer>();
    }
    //  Getters and NO Setters

    /**
     * @return the customerID
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * @return the items
     */
    public HashMap<String, Integer> getItems() {
        return items;
    }
    //  Methods
    //  1.  Add new items
    public void addNewItems(String title)    {
        int quantity = 1;
        //  If that title exist then add 1 to the quantity of this item
        if (items.containsKey(title)) {
            quantity = items.get(title) + 1;
        }
        items.put(title, quantity);
    }
    //  2.  Remove an items
    public void removeAnItems(String title)  {
        if (items.containsKey(title)) {
            items.remove(title);
        }
    }
}
