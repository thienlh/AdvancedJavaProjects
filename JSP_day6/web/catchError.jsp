<%-- 
    Document   : catchError
    Created on : Oct 13, 2014, 1:49:35 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorProcess.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process</title>
    </head>
    <body>
        <h1>Error implicit Obj Demo</h1>
        
        <%= Integer.parseInt("a") %>
    </body>
</html>