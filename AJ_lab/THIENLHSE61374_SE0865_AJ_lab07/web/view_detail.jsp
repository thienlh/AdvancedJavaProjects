<%-- 
    Document   : view_detail
    Created on : Oct 14, 2014, 10:16:52 PM
    Author     : thienlh
--%>

<%@page import="sample.account.AccountDTO"%>
<%@page import="sample.account.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User detail</title>
    </head>
    <body>
        <h1>User information</h1>
        <!--Get parameter-->
        <%
            AccountDAO dao = new AccountDAO();

            String username_info = request.getParameter("user");
            String role = request.getParameter("isAdmin");
            boolean isAdmin = false;
            if (role.equalsIgnoreCase("true")) {
                isAdmin = true;
            }
            String username = (String) session.getAttribute("USER");
            //  Check whether you can see it
            boolean isAbletoView = false;
            AccountDTO me = dao.getUserInfo(username);
            if(me.isIsAdmin())    {
                isAbletoView = true;
            }
            
            AccountDTO reg = dao.getUserInfo(username_info);

            if (reg != null) {
                //  Check wheter this user is admin
                if (isAbletoView) {
                    //  Print all
%>
        User name: <%=reg.getUsername()%></br>
        Password: <%=reg.getPassword()%></br>
        Last name: <%=reg.getLastname()%></br>
        Is Admin: <%=isAdmin%>
        <%
        } else {
            //  Print this user's info only
            if (username.equals(username_info)) {
                //  View info
%>
        User name: <%=reg.getUsername()%></br>
        Password: <%=reg.getPassword()%></br>
        Last name: <%=reg.getLastname()%></br>
        Is Admin: <%=isAdmin%>
        <%
        } else {
                //  No permission
        %><font color="red">You don't have permission to view this user's info!</font><%
            }
        %>

        <%
                }
            }
        %>

    </body>
</html>
