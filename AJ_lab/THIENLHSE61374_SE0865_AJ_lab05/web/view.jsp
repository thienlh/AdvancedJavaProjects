<%-- 
    Document   : view
    Created on : Oct 14, 2014, 9:00:23 PM
    Author     : thienlh
--%>

<%@page import="java.util.List"%>
<%@page import="sample.account.AccountDAO"%>
<%@page import="sample.account.AccountDTO"%>
<%@page import="sample.utils.DBUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View page</title>
    </head>
    <body>
        <font color="purple">Welcome, <%= session.getAttribute("USER")%>!</font>
        <h1>Information page</h1>
        Last name: <input type="text" name="txtSearchQuery" value="" />
        <input type="submit" value="Search" />

        <h2>Result of searching</h2>
        <!--Load from database-->
        <%
            AccountDAO dao = new AccountDAO();
            dao.loadInfo();
            List<AccountDTO> listAccount = dao.getListAccount();

            for (int i = 0; i < listAccount.size(); i++) {
                AccountDTO reg = listAccount.get(i);
                //  Print the table
        %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Username</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <%=(i+1) %>
                                </td>
                                <td>
                                    <%= reg.getUsername() %>
                                </td>
                                <%
                                String urlRewriting = "view_detail.jsp?user="
                                        + reg.getUsername()
                                        + "&&isAdmin="
                                        + reg.isIsAdmin();
                                %>
                                <td>
                                    <a href="<%=
                                    urlRewriting
                                    %>">View details</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
        <%
            }
        %>
    </body>
</html>
