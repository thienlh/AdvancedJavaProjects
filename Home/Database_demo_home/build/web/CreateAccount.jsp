<%-- 
    Document   : CreateAccount
    Created on : Oct 15, 2014, 1:08:28 AM
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
        <h1>Create account</h1>
        <c:set var="errs" value="${requestScope.ERROR}"/>

        <c:if test="${not empty errs}">
            <c:if test="${not empty errs.usernameErrs}">
                <font color="red">- ${errs.usernameErrs}</font></br>
            </c:if>
            <c:if test="${not empty errs.passwordErrs}">
                <font color="red">- ${errs.passwordErrs}</font></br>
            </c:if>
            <c:if test="${not empty errs.confirmErrs}">
                <font color="red">- ${errs.confirmErrs}</font></br>
            </c:if>
            <c:if test="${not empty errs.lastnameErrs}">
                <font color="red">- ${errs.lastnameErrs}</font></br>
            </c:if>
            <c:if test="${not empty errs.duplicateUsername}">
                <font color="red">${errs.duplicateUsername}</font></br>
            </c:if>
        </c:if>

        <form action="CenterServlet" method="POST">
            Username* <input type="text" name="txtUsername" value="" />  6-20 characters<br/>
            Password*   <input type="password" name="txtPassword" value="" />  5-20 characters<br/>
            Confirm* <input type="password" name="txtConfirm" value="" />  5-20 characters<br/>
            Last name* <input type="text" name="txtLastname" value="" />  5-20 characters<br/>
            <input type="submit" value="Sign up" name="btAction"/>    
            <input type="reset" value="Reset" name="btAction"/>
        </form>
    </body>
</html>
