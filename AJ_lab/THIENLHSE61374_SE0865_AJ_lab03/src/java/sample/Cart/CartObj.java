/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.Cart;

import java.util.HashMap;

/**
 *
 * @author thienlh
 */
public class CartObj {
    private HashMap<String, Integer> items;

    public CartObj() {
        items = new HashMap<String, Integer>();
    }
    

    public void addToCart(String productName) {
        int quantity = 1;
        //  If product already exist
        if (items.containsKey(productName)) {
            //  Quantity + 1
            quantity = items.get(productName) + 1;
        }
        //  Replace the old entry with new one
        items.put(productName, quantity);
    }
    
    public int getNumberOfItems()   {
        return items.isEmpty() ? 0 : items.size();
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }
}
