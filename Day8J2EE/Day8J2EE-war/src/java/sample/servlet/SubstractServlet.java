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
public class SubstractServlet extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SubstractServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubstractServlet at " + request.getContextPath() + "</h1>");
            //  Get parameters
            String n1 = request.getParameter("txtNum1");
            String n2 = request.getParameter("txtNum2");

            //  Parsing
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);

            //  Init
            Context context = null;
            Object obj = null;
            CalculatorSessionBeanRemoteHome homeObj = null;
            CalculatorSessionBeanRemote ejbObj = null;
            try {
                //  1.  Get current context
                context = new InitialContext();
                //  2.  Lookup for Home object using middle object
                obj = (CalculatorSessionBeanRemoteHome) context.lookup("CalJNDI");
                homeObj = (CalculatorSessionBeanRemoteHome) PortableRemoteObject.narrow(obj, CalculatorSessionBeanRemoteHome.class);
            } catch (NamingException ex) {
                log("Naming error!", ex.getCause());
            }
            //  3.  Create EJBObject base on Home Object
            if (homeObj != null) {
                try {
                    ejbObj = homeObj.create();
                } catch (CreateException ex) {
                    log("Error while creating ejbObject", ex.getCause());
                } catch (RemoteException ex) {
                    log("Error while creating remote Object", ex.getCause());
                }
                //  Invoke business method
                double result = ejbObj.substract(num1, num2);
                out.println("result=" + result);
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
