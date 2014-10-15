<%-- 
    Document   : welcome
    Created on : Oct 14, 2014, 8:04:04 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/newtag_library.tld" prefix="abc"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%--<font color="red">Welcome, <%=(LoginBean)session.getAttribute("loginAtt").getUsername()%></font>

        <jsp:useBean id="loginAtt" class="sample.beans.LoginBean" scope="session"/>
        <jsp:getProperty name="loginAtt" property="username"/>--%>
        <font color="yellow">Welcome, ${loginAtt.username}</font>
        <font color="pink">Welcome, ${sessionScope.loginAtt.username}</font>

        <h1>Welcome to my world!</h1>


        <!--Par1: <%=request.getParameter("par1")%>
        Par2: <%=request.getParameter("par2")%>-->

        Par1: ${param.par1}
        Par1: ${param.par2}

        ${abc:info("Thien", "15", "true")}</br>
        ${abc:info("Chien", "18", "false")}</br>
        ${abc:info("Nguyen", "40", "true")}</br>

        <a href="JSPServlet">Discover JSP scope in servlet</a><br/>

        <form action="welcome.jsp">
            Name <input type="text" name="txtName" value="" />
            <input type="submit" value="Search" />
        </form><br/>

        <c:set var="name" value="${param.txtName}"></c:set>

        <c:if test="${not empty name}">
            <c:catch var="ex">
                <sql:setDataSource var="cn" dataSource="ThienDS"/>
                <c:if test="${not empty cn}">
                    <sql:query var="rs" dataSource="${cn}">
                        Select * from ACCOUNT where username like ?
                        <sql:param value="${name}"/>
                    </sql:query>
                </c:if>
            </c:catch>
            <c:if test="${not empty ex}">

            </c:if>
        </c:if>
        <c:if test="${not empty rs}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Last name</th>
                        <th>Roles</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="record" items="${rs.rows}" varStatus="counter">

                    </c:forEach>
                    <tr>
                        <td>${counter.count}</td>
                        <td>${record.username}</td>
                        <td>${record.password}</td>
                        <td>${record.lastname}</td>
                        <td>${record.isAdmin}</td>
                    </tr>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
