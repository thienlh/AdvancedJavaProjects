<%-- 
    Document   : welcome
    Created on : Oct 14, 2014, 8:04:04 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/newtag_library.tld" prefix="abc"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%--<font color="red">Welcome, <%=(LoginBean)session.getAttribute("loginAtt").getUsername()%></font>

        <jsp:useBean id="loginAtt" class="sample.beans.LoginBean" scope="session"/>
        <jsp:getProperty name="loginAtt" property="username"/>--%>
        <font color="yellow">Welcome, ${loginAtt.username}</font>
        <font color="pink">Welcome, ${sessionScope.loginAtt.username}</font>
        
        <h1>Welcome to my world!</h1>
        
        
        Par1: <%=request.getParameter("par1")%>
        Par2: <%=request.getParameter("par2")%>
        
        ${abc:info("Thien", "15", "true")}</br>
        ${abc:info("Chien", "18", "false")}</br>
        ${abc:info("Nguyen", "40", "true")}</br>
        
        <a href="JSPServlet">Discover JSP scope in servlet</a>
    </body>
</html>
