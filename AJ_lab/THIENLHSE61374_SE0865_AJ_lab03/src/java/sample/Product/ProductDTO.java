/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Product;

import java.io.Serializable;

/**
 *
 * @author thienlh
 */
public class ProductDTO implements Serializable {

    private String productID;
    private String productName;
    private String productQuantity;
    private float productPrice;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, String productQuantity, float productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }
    
    
    /**
     * @return the productID
     */
    public String getProductID() {
        return productID;
    }

    /**
     * @param productID the productID to set
     */
    public void setProductID(String productID) {
        this.productID = productID;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productQuantity
     */
    public String getProductQuantity() {
        return productQuantity;
    }

    /**
     * @param productQuantity the productQuantity to set
     */
    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * @return the productPrice
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * @param productPrice the productPrice to set
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
