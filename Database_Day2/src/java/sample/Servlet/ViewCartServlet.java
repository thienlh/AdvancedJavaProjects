/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

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
import sample.shopping.CartObj;

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
        String actionType = "hidden";
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View cart</title>");
            out.println("</head>");
            out.println("<body>");

            //  1.  Di toi noi dung gio
            HttpSession session = request.getSession(false);
            if (session != null) {
                //  2.  Lay gio ra
                CartObj cart = (CartObj) session.getAttribute("CART");
                //  Phong ngua may thang ngu chu mua hang ma doi xem gio
                if (cart != null) {
                    //  Load danh sach
                    HashMap<String, Integer> items = cart.getItems();
                    out.println("<h1>Your cart</h1>");
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
                    out.println("<form action='CenterServlet' method='POST'>");

                    Iterator iter = items.entrySet().iterator();
                    int count = 0;
                    //  Hien thi ra
                    while (iter.hasNext()) {
                        //  Lay entry hien tai
                        Map.Entry entry = (Map.Entry) iter.next();

                        out.println("<tr>");
                        out.println("<td>"
                                + ++count
                                + "</td>");
                        out.println("<td>"
                                + entry.getKey()
                                + "</td>");
                        out.println("<td>"
                                + entry.getValue()
                                + "</td>");
                        //  Ki thuat hidden field nang cao
                        out.println("<td><input type='checkbox' name='cboItem' value='"
                                + entry.getKey()
                                + "' /></td>");
                        out.println("</tr>");
                    }

                    out.println("<tr>");
                    out.println("<td colspan=3>"
                            + "<a href='welcome.html'>Add more items to cart</a>"
                            + "</td>");
                    out.println("<td><input type='"
                            + actionType
                            + "' value='Delete checked items' name='btAction' /></td>");
                    out.println("</tr>");
                    out.println("</form>");
                    out.println("</tbody>");
                    out.println("</table>");
                }
            }

            out.println("<h2><font color='red'>Someone stolen your cart "
                    + "or you don't have one at all :p</font></h2>");
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
