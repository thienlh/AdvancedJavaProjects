<%-- 
    Document   : LeaderDashboard
    Created on : Oct 17, 2014, 10:17:15 PM
    Author     : thienlh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.tomcat.util.http.fileupload.RequestContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome leader, <%=session.getAttribute("USER")%>!</h1>

        <form action="LeaderDashboard.jsp">
            <%--Get Semester and block --%>
            <c:forTokens delims=",.;-" var="blockSemester" items="<%%>">
                
            </c:forTokens>
            Semester: <select name="ddlSemester">
                <option>Spring</option>
                <option>Summer</option>
                <option>Fall</option>
            </select><br/>
            Block: <select name="ddlBlock">
                <option>1</option>
                <option>2</option>
                <option>3</option>
            </select><br/>
            <input type="submit" value="Search" name="btAction"/>
        </form>
        <h2>Search Result</h2><br/>
    </body>
</html>
