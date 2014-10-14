/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

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
 * @author thienle
 */
public class ProductDAO implements Serializable {

    private List<ProductDTO> listProduct;

    public boolean saveProduct(ProductDTO product) {
        //  1.  Init Connection
        Connection cn = null;
        //  2.  Init PreparedStatement
        PreparedStatement stm = null;

        try {
            //  1.  Make connection
            cn = DBUtils.makeConnection();
            //  2.  Prepare sql string
            String sql = "insert into "
                    + "Product(code,name,description,price,category) "
                    + "values (?,?,?,?,?)";
            //  3.  Create object to pass parameters
            stm = cn.prepareStatement(sql);
            //  4.  Set parameters
            stm.setString(1, product.getCode());
            stm.setString(2, product.getName());
            stm.setString(3, product.getDescription());
            stm.setFloat(4, product.getPrice());
            stm.setString(5, product.getCategory());
            //  5.  Execute query
            int row = stm.executeUpdate();
            //  6. Your business
            if (row > 0) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //  Close PreparedStatement
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
        return false;
    }

    public void loadProduct() {
        //  1.  Init Connection
        Connection cn = null;
        //  2.  Init PreparedStatement
        PreparedStatement stm = null;
        //  3.  Init ResultSet
        ResultSet rs = null;
        try {
            //  1.  Make connection
            cn = DBUtils.makeConnection();
            //  2.  Prepare sql query
            String sql = "select * from Product";
            //  3.  Create object to pass parameters
            stm = cn.prepareStatement(sql);
            //  4.  Set parameters

            //  5.  Execute query
            rs = stm.executeQuery();
            //  6.  Your business
            listProduct = new ArrayList<ProductDTO>();
            while (rs.next()) {
                //  Get parameters
                String code = rs.getString("code");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                float price = rs.getFloat("price");
                String category = rs.getString("category");
                //  Add to list
                ProductDTO tmp = new ProductDTO(code, name, desc, price, category);
                getListProduct().add(tmp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the listProduct
     */
    public List<ProductDTO> getListProduct() {
        return listProduct;
    }
}
