<%-- 
    Document   : index
    Created on : Oct 14, 2014, 7:33:44 PM
    Author     : thienlh
--%>

<%@page import="sample.account.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <!--Declare variables-->
        <%!
            final String viewPage = "view.jsp";
            final String errorPage = "error.html";
        %>

        <!--  Check login  -->
        <%
            //  Get parameters
            String username = (String) request.getParameter("txtUsername");
            String password = (String) request.getParameter("txtPassword");
            //  Create DAO
            AccountDAO dao = new AccountDAO();
            boolean result = dao.checkLogin(username, password);
            if (result) {
                //  Go to view page
                session.setAttribute("USER", username);
                RequestDispatcher rd = request.getRequestDispatcher(viewPage);
                rd.forward(request, response);
            } else {
                //  Go to invalid page
                response.sendRedirect(errorPage);
            }
        %>
    </body>
</html>
