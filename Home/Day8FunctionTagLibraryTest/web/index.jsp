<%-- 
    Document   : index
    Created on : Oct 16, 2014, 1:16:09 AM
    Author     : thienlh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sun's JSTL Function Tag Library Demos</h1>
        fn:length ${fn:length("This is Le Hung Thien")}<br/>
        fn:contains ${fn:contains("This is Le Hung Thien", " ")}<br/>
        fn:containsIgnoredCase ${fn:containsIgnoreCase("This Is Le Hung Thien", "i")}<br/>
        fn:indexOf ${fn:indexOf("This is Le Hung Thien", "g")}<br/>
        fn:split <br/>
        <c:forEach var="value" items="${fn:split('This is Le Hung Thien', ' ')}">
            ${value}<br/>
        </c:forEach>
        fn:subString ${fn:substring("This is Le Hung Thien", 3, 7)}<br/>
        fn:toUpperCase ${fn:toUpperCase("This is Le Hung Thien")}<br/>
        fn:toLowerCase ${fn:toLowerCase("This is Le Hung Thien")}<br/>
        fn:Trim ${fn:trim("This is Le    Hung Thien     ")}<br/>
    </body>
</html>
