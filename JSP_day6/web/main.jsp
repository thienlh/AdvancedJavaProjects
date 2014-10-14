<%-- 
    Document   : main
    Created on : Oct 13, 2014, 1:10:58 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Directive Incldes JSP program</title>
    </head>
    <body>
        <%--include use directives --%>
        Current date is
        <%@include file="myDate.jsp" %>
    </body>
</html>
