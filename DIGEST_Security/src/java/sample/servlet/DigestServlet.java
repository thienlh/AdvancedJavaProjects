/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;

/**
 *
 * @author thienlh
 */
public class DigestServlet extends HttpServlet {

    //  Users list
    Hashtable users = new Hashtable();

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        users.put("thienlh:*9394lht#", "allowed");
        users.put("tomcat:tomcat", "allowed");
        users.put("guest:123456", "");
    }

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
        System.out.println("Hi i am here!");
        PrintWriter out = response.getWriter();
        try {
            String username = null;
            String password = null;
            boolean valid = false;

            //  Check for header
            String header = request.getHeader("Authorization");
            if (header != null) {
                //  Do some shit
                StringTokenizer st = new StringTokenizer(header);
                try {
                    String basic = st.nextToken();
                    //  If request header contains "BASIC"
                    if (basic.equalsIgnoreCase("Basic")) {
                        String credential = st.nextToken();
                        //  Decode the request using Base64 decoder
                        BASE64Decoder decoder = new BASE64Decoder();
                        password = new String(decoder.decodeBuffer(credential));
                        //  Just a friendly reminder
                        //  users key format username:password
                        int p = password.indexOf(":");
                        username = password.substring(0, p);
                        valid = users.containsKey(password) 
                                && users.get(password).equals("allowed");
                    }
                } catch (NoSuchElementException ex) {
                    log("There're no token in header!", ex.getCause());
                } catch (IOException ex)  {
                    log("Error in Base 64 decoder!", ex.getCause());
                } catch (Exception e)  {
                    e.printStackTrace();
                }
            }
            //  If header not contains "Authorization" but valid
            //  (requests that have been authorization)
            if (!valid) {
                String s = "Basic realm=\"Servlet User\"";  //  WTF?
                //  Response 401 with "WWW-Authenticate" in header
                response.setHeader("WWW-Authenticate", s);
                response.setStatus(401);
            } else {
                out.println("<h1>Welcome "
                        + username
                        + "! You have been authorizated!<h1>");
            }
            out.println("<h1><font color=red>Invalid username or password "
                    + "or you don't have permission to process!</font></h1>");

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
