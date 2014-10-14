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
import sample.object.ObjCart;

/**
 *
 * @author thienle
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
            //  1. Go to session
            HttpSession session = request.getSession(false);
            if (session != null) {
                //  2. Check if this place exist
                ObjCart cart = (ObjCart) session.getAttribute("CART");
                //  4. Check for the cart
                if (cart != null) {
                    //  3. Get items in the cart
                    HashMap<String, Integer> items = cart.getItems();

                    out.println("<table border='1'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>No.</th>");
                    out.println("<th>Title</th>");
                    out.println("<th>Quantity</th>");
                    out.println("<th>Action</th>");
                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    Iterator iter = items.entrySet().iterator();
                    int count = 0;
                    out.println("<form action='CenterServlet' method='POST'>");

                    while (iter.hasNext()) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        
                        out.println("<tr>");
                        out.println("<td>" + ++count + "</td>");
                        out.println("<td>" + entry.getKey() + "</td>");
                        out.println("<td>" + entry.getValue() + "</td>");
                        out.println("<td>"
                                + "<input type='checkbox' name='chkItem' value='"
                                + entry.getKey()
                                + "' />"
                                + "</td>");
                        out.println("</tr>");
                    }

                    out.println("<tr>");
                    out.println("<td colspan='3'>"
                            + "<a href='welcome.html'>Add more items to cart</a>"
                            + "</td>");
                    out.println("<td><input type='submit' value='Remove items' name='btAction'/></td>");
                    
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</tbody>");
                    out.println("</table>");
                }
                return;
            }
            out.println("<h2><font color='red'>Your cart has been stolen "
                    + "or you don't have a cart at all!</font></h2>");
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
