/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Product;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author thienlh
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> listProduct;

    //  1.  Init Connection
    Connection cn = null;
    //  2.  Init PreparedStatement
    PreparedStatement stm = null;
    //  3.  Init ResultSet
    ResultSet rs = null;

    public void loadProducts() {
        try {
            //  1.  Get connection
            cn = DBUtils.makeConnection();
            //  2.  Prepare the sql string
            String sql = "SELECT * "
                    + "FROM Products";
            //  2.  Create object to pass the parameters
            stm = cn.prepareStatement(sql);
            //  3.  Set parameters
            //  4.  Connect
            rs = stm.executeQuery();
            //  5.  Your business
            //  Add product to list
            listProduct = new ArrayList<ProductDTO>();

            while (rs.next()) {
                //  Prepare fields
                String id = rs.getString("product_id");
                String name = rs.getString("product_name");
                String quantity = rs.getString("product_quantity");
                float price = rs.getFloat("product_price");
                //  Add new product to list
                ProductDTO tmp = new ProductDTO(id, name, quantity, price);
                listProduct.add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //  Close ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  Close PrepareStatement
            try {
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //  Close Connection
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ProductDTO> getProductsList() {
        return listProduct;
    }
}
