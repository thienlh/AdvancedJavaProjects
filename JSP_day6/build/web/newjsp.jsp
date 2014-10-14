<%-- 
    Document   : newjsp
    Created on : Oct 13, 2014, 1:04:24 AM
    Author     : thienlh
--%>
<%@ page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!-- My first Prgram.jsp -->
        <% out.println("Hello there!"); %></br>
        <%="Current date is: " + new Date() %>
        <%--End of program--%>
    </body>
</html>
