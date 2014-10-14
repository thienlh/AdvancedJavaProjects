/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.io.Serializable;

/**
 *
 * @author thienle
 */
public class ProductDTO implements Serializable {

    //  1. Non public fields
    private String code;
    private String name;
    private String description;
    private float price;
    private String category;

    //  2.  Default constructor
    public ProductDTO() {
    }
    
    //  3.  Parameter constructor
    public ProductDTO(String code, String name, String description, float price, String category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
    
    //  4.  Getters and Setters
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
