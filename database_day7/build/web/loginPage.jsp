<%-- 
    Document   : loginPage
    Created on : Oct 14, 2014, 7:44:09 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login jsp</h1>

        <jsp:useBean id="loginAtt" class="sample.beans.LoginBean" scope="session"/>
        <%--<jsp:setProperty name="loginAtt" property="username" value='<%=request.getParameter("txtUsername")%>'/>
        <jsp:setProperty name="loginAtt" property="password" value='<%=request.getParameter("txtPassword")%>'/>
        
        <jsp:getProperty name="loginAtt" property="username"/></br>
        <jsp:getProperty name="loginAtt" property="password"/></br>
        --%>

        <%--<jsp:setProperty name="loginAtt" property="username" param="txtUsername"/>
        <jsp:setProperty name="loginAtt" property="password" param="txtPassword--%>

        <%--<jsp:setProperty name="loginAtt" property="username"/>
        <jsp:setProperty name="loginAtt" property="password"/>--%>
        <jsp:setProperty name="loginAtt" property="*"/>

        <c:if test="${loginAtt.checkLogin()}">
            <jsp:forward page="welcome.jsp">
                <jsp:param name="par1" value="Forward"/>
                <jsp:param name="par2" value="JSP"/>
            </jsp:forward>
        </c:if>
        <h2>Invalid</h2>
        <%-- <%
             if (loginAtt.checkLogin()) {
                 //  response.sendRedirect("welcome.jsp");
                 //  Da xuong hang thi phai co param
                 %>
                 
                 <jsp:forward page="welcome.jsp">
                     <jsp:param name="par1" value="Forward"/>
                     <jsp:param name="par2" value="JSP"/>
                 </jsp:forward>
         <%
             } else {
         %>
         <h2>Invalid</h2>
         <%
             }
         %>
         <%
         System.out.println("Hi!!!!!!!!!!!!");
         %>--%>
    </body>
</html>
