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
import java.util.Map;
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
public class ViewCartServlet extends HttpServlet {

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
            out.println("<title>Your cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your cart</h1>");

            //  Check session
            HttpSession session = request.getSession(false);
            if (session != null) {
                //  Check for the cart
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart == null) {
                    //  Create one
                    session.setAttribute("CART", new CartObj());
                    //  Add product
                    String product = request.getParameter("txtProductName");
                    if (product != null) {
                        cart.addToCart(product);
                    }
                } else {
                    //  Add product
                    String product = request.getParameter("txtProductName");
                    if (product != null) {
                        cart.addToCart(product);
                    }
                    //  Display all items in the cart
                    out.println("<table border='1'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>No.</th>");
                    out.println("<th>ID</th>");
                    out.println("<th>Name</th>");
                    out.println("<th>Quantity per unit</th>");
                    out.println("<th>Price</th>");
                    out.println("<th>Quantity</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");
                    HashMap productsList = cart.getItems();
                    Iterator iter = productsList.entrySet().iterator();
                    int count = 0;
                    while (iter.hasNext()) {
                        //  Get the entry
                        Map.Entry entry = (Map.Entry) iter.next();

                        out.println("<tr>");
                        //  No.
                        out.println("<td>"
                                + ++count
                                + "</td>");
                        //  ID
//                        out.println("<td>"
//                                + reg.getProductID()
//                                + "</td>");
                        //  Name
                        out.println("<td>"
                                + entry.getKey()
                                + "</td>");
                        //  Quantity per unit
//                        out.println("<td>"
//                                + reg.getProductQuantity()
//                                + "</td>");
                        //  Price
//                        out.println("<td>"
//                                + reg.getProductPrice()
//                                + "</td>");
                        //  Quantity
                        out.println("<td>"
                                + entry.getValue()
                                + "</td>");

                        out.println("</tr>");
                    }
                    out.println("</tbody>");
                    out.println("</table>");
                }
                out.println("<h2><font color=red>"
                        + "Your cart is empty! "
                        + "Go buy some product!"
                        + "</font></h2>");
            } else {
                out.println("<h2><font color=red>"
                        + "Some one stole your cart "
                        + "or you don't even have one at all!"
                        + "</font></h2>");
            }

            out.println("<a href='DisplayServlet'>Go buy more products</a>");

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
