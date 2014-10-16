/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.CreateException;
import javax.ejb.EJBObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.session.CalculatorSessionBeanRemote;
import sample.session.CalculatorSessionBeanRemoteHome;

/**
 *
 * @author thienlh
 */
public class AddServlet extends HttpServlet {

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
            out.println("<title>Servlet AddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddServlet at " + request.getContextPath() + "</h1>");

            String n1 = request.getParameter("txtNum1");
            String n2 = request.getParameter("txtNum2");

            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);

            CalculatorSessionBeanRemoteHome homeObj = null;
            CalculatorSessionBeanRemote ejbObj = null;
            try {
                //  Lay context hien hanh
                Context context = new InitialContext();
                if (context != null) {
                    Object obj = context.lookup("CalJNDI");
                    homeObj = (CalculatorSessionBeanRemoteHome) PortableRemoteObject.narrow(obj, CalculatorSessionBeanRemote.class);

                }
                //  Lookup HomeObj
                //  Create EjbObj dua tren HomeObj
                if (homeObj != null) {
                    try {
                        ejbObj = homeObj.create();
                    } catch (CreateException ex) {
                        ex.printStackTrace();
                    }
                }
                //  Goi business method tren EJBObj
                //  Xu li
            } catch (NamingException ex) {
                ex.printStackTrace();
            }

            double result = ejbObj.add(num1, num2);

            out.println("result=" + result);

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
