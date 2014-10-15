/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.account.AccountDAO;
import sample.account.AccountError;

/**
 *
 * @author thienle
 */
public class SignupServlet extends HttpServlet {

//    private final String errorDisplayServlet = "ErrorDisplayServlet";
    private final String errorDisplayServlet = "CreateAccount.jsp";
    private final String loginPage = "login.html";    

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
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String lastname = request.getParameter("txtLastname");

            boolean error = false;

            AccountError errorObj = new AccountError();
            
            if (username.length() < 6 || username.length() > 20) {
                error = true;
                errorObj.setUsernameErrs("Username from 6 to 20");
            }
            if (password.length() < 5 || password.length() > 20) {
                error = true;
                errorObj.setPasswordErrs("Password from 6 to 20");
            }
            if (!confirm.equals(password)) {
                error = true;
                errorObj.setConfirmErrs("Password and Confirm not match!");
            }
            if (lastname.length() < 2 || lastname.length() > 20) {
                error = true;
                errorObj.setLastnameErrs("Last name from 2 to 20");
            }

            request.setAttribute("ERROR", errorObj);
            String url = errorDisplayServlet;
            if (!error) {
                AccountDAO dao = new AccountDAO();
                boolean result = dao.createAccount(username, password, lastname, error);

                if (result) {
                    url = loginPage;
                } else {
                    errorObj.setDuplicateUsername("Da ton tai");
                    request.setAttribute("ERROR", errorObj);
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
