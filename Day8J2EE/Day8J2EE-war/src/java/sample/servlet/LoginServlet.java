/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.session.AccountSessionBeanRemote;
import sample.session.AccountSessionBeanRemoteHome;

/**
 *
 * @author thienlh
 */
public class LoginServlet extends HttpServlet {

    private String invalidPage = "invalid.html";
    private String welcomePage = "welcome.html";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");

            String username = request.getParameter("txtUsename");
            String password = request.getParameter("txtPassword");
            try {
                Context context = new InitialContext();

                Object obj = context.lookup("AccJNDI");
                System.out.println("jkladfhakljfhaskjdlfhasdkjfhaskdjf");
                AccountSessionBeanRemoteHome homeObj = (AccountSessionBeanRemoteHome) PortableRemoteObject.narrow(obj, AccountSessionBeanRemoteHome.class);
                try {
                    AccountSessionBeanRemote ejbObj = homeObj.create();
                    boolean result = ejbObj.checkLogin(username, password);
                    
                    String url = invalidPage;

                    if (result) {
                        url = welcomePage;
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("password", password);
                    }

                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                } catch (CreateException ex) {
                    ex.printStackTrace();
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            } catch (NamingException ex) {
                ex.printStackTrace();
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
