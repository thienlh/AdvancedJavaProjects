<%-- 
    Document   : errorProcess
    Created on : Oct 13, 2014, 1:54:22 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Error occur!</h1>
        <font color="red"><%=exception.getMessage() %></font>
    </body>
</html>
