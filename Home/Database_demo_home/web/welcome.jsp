<%-- 
    Document   : index
    Created on : Oct 8, 2014, 5:46:13 AM
    Author     : thienle
--%>

<%@page import="sample.account.AccountDAO"%>
<%@page import="sample.account.AccountDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--<font color="red">Welcome, <%=session.getAttribute("USERS")%> </font>--%>
        <font>${sessionScope.USERS}</font>
        <h1>Welcome to my world!</h1>
        <form action="CenterServlet">
            Name <input type="text" name="txtSearch" value="" /> <input type="submit" value="Search" name="btAction" />
        </form><br/>

        <%
            String name = request.getParameter("txtName");
            if (name != null) {
                List<AccountDTO> result = (List<AccountDTO>) request.getAttribute("INFO");
                if (result != null) {
                    if (result.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Last name</th>
                    <th>Roles</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < result.size(); i++) {
                        AccountDTO dto = result.get(i);
                        String urlRewriting = "CenterServlet?btAction=Delete"
                                + "&txtUsername=" + dto.getUsername()
                                + "&searchValue="
                                + request.getParameter("txtUser");
                %>
                <!-- <form action="CenterServlet">
                <tr>
                    <td>
                        <%=(i + 1)%>
                    </td>

                    <td>
                        <%=dto.getUsername()%>
                        <input type="hidden" name="txtUsername" value="<%=dto.getUsername()%>" />
                    </td>

                    <td>
                        <input type="password" name="txtPassword" value="<%=dto.getPassword()%>" />
                    </td>

                    <td>
                        <%=dto.getLastname()%>
                    </td>

                    <td>
                        <input type="checkbox" name="chkAdmin" value="ADMIN" 
                               <%
                                   if (dto.isIsAdmin()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               />
                    </td>

                    <td>
                        <a href="<%=urlRewriting%>">Delete</a>
                    </td>

                    <td>
                        <input type="hidden" name="searchValue"
                               value="<%=request.getParameter("txtUser")%>"
                               />
                        <input type="submit" value="Update" name="btAction"/>
                    </td>
                </tr>
            </form> -->
                <%
                    }
                %>
            </tbody>
        </table>

        <%
        } else {
        %>
        <h2><font color="blue">No record is matched!</font></h2>
            <%
                }
            %>

        <form action="CenterServlet">
            Book title: <select name="cboBookTitle">
                <option>Servlet</option>
                <option>CGI</option>
                <option>Tomcat</option>
                <option>Container</option>
                <option>JSP</option>
                <option>Java Beans</option>
                <option>EPL</option>
                <option>La Liga</option>
                <option>Other</option>
            </select><br/><br/>
            <input type="submit" value="Add to cart" name="btAction"/>  
            <input type="submit" value="View your cart" name="btAction"/>
        </form>
    </body>
</html>