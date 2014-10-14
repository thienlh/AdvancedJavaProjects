/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.Registration.RegistrationDAO;
import sample.Registration.RegistrationDTO;

/**
 *
 * @author thienle
 */
public class SearchServlet extends HttpServlet {

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
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Result page</h1>");

            String name = request.getParameter("txtName");

            RegistrationDAO dao = new RegistrationDAO();
            dao.searchLikeLastname(name);

            List<RegistrationDTO> result = dao.getListAccount();

            if (result != null) {
                if (result.size() > 0) {
                    out.println("<table border='1'>");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>No.</th>");
                    out.println("<th>Username</th>");
                    out.println("<th>Password</th>");
                    out.println("<th>Last name</th>");
                    out.println("<th>Roles</th>");
                    out.println("<th>Delete</th>");
                    out.println("<th>Update</th>");

                    out.println("</tr>");
                    out.println("</thead>");
                    out.println("<tbody>");

                    for (int i = 0; i < result.size(); i++) {

                        out.println("<form action='CenterServlet'>");

                        RegistrationDTO reg = result.get(i);

                        out.println("<tr>");
                        //  No
                        out.println("<td>" + (i + 1) + "</td>");
                        //  Username
                        out.println("<td>" + reg.getUsername()
                                + "        <input type='hidden' name='txtUser' value='" + reg.getUsername() + "' />"
                                + "</td>");
                        //  Password
                        out.println("<td><input type='text' name='txtPass' value='"
                                + reg.getPassword() + "' />"
                                + "</td>");
                        //  Lastname
                        out.println("<td>" + reg.getLastName()
                                + "</td>");
                        //  Roles
                        if (reg.getRoles() == true) {
                            out.println("<td>"
                                    + "<input type='checkbox' name='chkAdmin' value='ON' checked='checked' />"
                                    + "</td>");
                        } else {
                            out.println("<td>"
                                    + "<input type='checkbox' name='chkAdmin' value='ON' />"
                                    + "</td>");
                        }

                        //  resource?parValues
                        String urlRewriting = "CenterServlet?btAction=Delete&user=" + reg.getUsername() + "&searchValue=" + name;

                        out.println("<td><a href='" + urlRewriting + "'>Delete</a></td>");
                        out.println("<td>"
                                + "<input type='hidden' name='txtSearchValue' value='" + name + "' />"
                                + "<input type='submit' value='Update' name='btAction'/>"
                                + "</td>");

                        out.println("</tr>");
                        out.println("</form>");
                    }

                    out.println("</tbody>");
                    out.println("</table>");
                    return;
                }
            }

            out.println("<h2>No record is match!</h2>");

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
