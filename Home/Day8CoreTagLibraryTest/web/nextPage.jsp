<%-- 
    Document   : nextPage
    Created on : Oct 16, 2014, 1:00:21 AM
    Author     : thienlh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome, ${param.user}</h1>
        <!--Include right here-->
        <%--<c:import url="index.jsp"/>--%>
        <!--Include when the variable is used-->
        <c:import url="index.jsp" var="content"/>
        ${content}
    </body>
</html>
