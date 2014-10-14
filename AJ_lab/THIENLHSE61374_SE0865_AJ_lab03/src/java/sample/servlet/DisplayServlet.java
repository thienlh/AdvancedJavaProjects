/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.Cart.CartObj;
import sample.Product.ProductDAO;
import sample.Product.ProductDTO;

/**
 *
 * @author thienlh
 */
public class DisplayServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Product List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Product List</h1>");

            //  Check session for a cart
            HttpSession session = request.getSession();

            //  Check the cart
            CartObj cart = (CartObj) session.getAttribute("CART");
            //  if there is no cart, create one
            if (cart == null) {
                session.setAttribute("CART", new CartObj());
            }
            // Load all items in database
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>No.</th>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Quantity per unit</th>");
            out.println("<th>Price</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            ProductDAO dao = new ProductDAO();
            dao.loadProducts();
            List<ProductDTO> productsList = dao.getProductsList();

            for (int i = 0; i < productsList.size(); i++) {
                //  Get the entry
                ProductDTO reg = productsList.get(i);

                out.println("<tr>");
                //  No.
                out.println("<td>"
                        + (i + 1)
                        + "</td>");
                //  ID
                out.println("<td>"
                        + reg.getProductID()
                        + "</td>");
                //  Name
                //  Prepre urlRewriting string
                String urlRewriting = "CenterServlet?btAction=Add to cart&txtProductName="
                        + reg.getProductName();
                out.println("<td>"
                        + "<a href='"
                        + urlRewriting
                        + "'>"
                        + reg.getProductName()
                        + "</a>"
                        + "</td>");
                //  Quantity per unit
                out.println("<td>"
                        + reg.getProductQuantity()
                        + "</td>");
                //  Price
                out.println("<td>"
                        + reg.getProductPrice()
                        + "</td>");
                
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            int numOfProducts = productsList.size();
            out.println("Total: "
                    + numOfProducts
                    + " products in the store.</br>");
            
            out.println("<a href='ViewCartServlet'>View my shopping cart</a>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
