<%-- 
    Document   : myDate
    Created on : Oct 13, 2014, 1:09:04 AM
    Author     : thienlh
--%>
<%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date JSP program</title>
    </head>
    <body>
        <%= new Date().toLocaleString() %>
    </body>
</html>
