/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class RemoveBookServlet extends HttpServlet {

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
            //  1. Den noi lay gio
            HttpSession session = request.getSession(false);
            if (session != null) {
                //  2. Lay gio, kiem tra gio
                ObjCart cart = (ObjCart) session.getAttribute("CART");
                if (cart != null) {
                    //  3.  Lay danh sach hang chon lua, kiem tra co
                    String[] list = request.getParameterValues("chkItem");
                    if (list != null) {
                        //  4.  Duyet tung mon hang va bo ra khoi gio
                        for (int i = 0; i < list.length; i++) {
                            cart.removeItem(list[i]);
                        }
                        //  5.  Dua gio lai cho robot
                        session.setAttribute("CART", cart);
                    }
                }
                //  6.  Xem lai gio hang
                String urlRewriting = "CenterServlet?btAction=View your cart";
                response.sendRedirect(urlRewriting);
                return;
            }
            out.println("<h2><font color='red'>"
                    + "Gio hang khong ton tai hoac khong co item nao!"
                    + "</font></h2>");
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
