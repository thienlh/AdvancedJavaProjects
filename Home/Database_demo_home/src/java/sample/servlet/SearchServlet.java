/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.account.AccountDAO;
import sample.account.AccountDTO;

/**
 *
 * @author thienle
 */
public class SearchServlet extends HttpServlet {

    private String welcomeJSP = "welcome.jsp";

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Search Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Search Result</h1>");

            //  Get parameters
            String searchQuery = request.getParameter("txtSearch");

            //  Search
            AccountDAO dao = new AccountDAO();
            dao.searchLikeName(searchQuery);
            List<AccountDTO> result = dao.getListAccount();

//            //  Display on table
//            if (result != null) {
//                if (result.size() > 0) {
//                    //  HTML
//                    out.println("<table border='1'>");
//                    out.println("<thead>");
//                    out.println("<tr>");
//                    out.println("<th>No.</th>");
//                    out.println("<th>Username</th>");
//                    out.println("<th>Password</th>");
//                    out.println("<th>Last name</th>");
//                    out.println("<th>Roles</th>");
//                    out.println("<th>Delete</th>");
//                    out.println("<th>Update</th>");
//                    out.println("</tr>");
//                    out.println("</thead>");
//                    out.println("<tbody>");
//
//                    for (int i = 0; i < result.size(); i++) {
//                        out.println("<form action='CenterServlet'>");
//                        AccountDTO reg = result.get(i);
//
//                        out.println("<tr>");
//                        out.println("<td>"+ (i+1) +"</td>");
//                        out.println("<td>" + reg.getUsername()
//                                + "<input type='hidden' name='txtUser' value='"
//                                + reg.getUsername()
//                                + "' />"
//                                + "</td>");
//                        out.println("<td><input type='text' name='txtPass' value='"
//                                + reg.getPassword()
//                                + "'/></td>");
//                        out.println("<td>" + reg.getLastname() + "</td>");
//                        if (reg.isIsAdmin()) {
//                            out.println("<td><input type='checkbox' "
//                                    + "name='chkIsAdmin' value='ON' "
//                                    + "checked='checked' /></td>");
//                        } else {
//                            out.println("<td><input type='checkbox' name='chkIsAdmin' value='ON'/></td>");
//                        }
//
//                        //  Prepare string
//                        String urlRewriting = "CenterServlet?btAction=Delete&txtUsername="
//                                + reg.getUsername()
//                                + "&searchQuery=" + searchQuery;
//                        out.println("<td><a href='"
//                                + urlRewriting
//                                + "'>Delete</a></td>");
//                        //  Update
//                        out.println("<td><input type='submit' value='Update' name='btAction'/></td>");
//                        out.println("<td><input type='hidden' name='txtSearchQuery' value='"
//                                + searchQuery
//                                + "' /></td>");
//                        
//                        out.println("</tr>");
//                        out.println("</form>");
//                    }
//
//                    out.println("</tbody>");
//                    out.println("</table>");
            request.setAttribute("INFO", result);
            RequestDispatcher rd = request.getRequestDispatcher(welcomeJSP);
            rd.forward(request, response);
            return;
//        }
                //  out.println("</form>");

//        out.println("<h2><font color='red'>No record is match your search query!</font></h2>");
//
//        out.println("</body>");
//        out.println("</html>");
//    }
}
finally {
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
