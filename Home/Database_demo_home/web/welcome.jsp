<%-- 
    Document   : welcome
    Created on : Oct 14, 2014, 7:53:05 PM
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
        <c:set var="name" value="${param.txtName}"></c:set>
        <c:if test="${not empty name}">
            <c:set var="list" value="${requestScope.INFO}"></c:set>
            <c:if test="${not empty INFO}">  
                <h2>No record is match!</h2>
            </c:if>
            <!--Print the table-->
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Last name</th>
                        <th>Role</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${INFO}" varStatus="counter">
                        <!--Print the record-->
                        <tr>
                            <!--
                            <td>
                            ${counter}
                        </td>
                            -->
                            <td>
                                ${counter.count}
                            </td>
                            <td>
                                ${dto.username}
                                <input type="hidden" name="txtUser" value="" />
                            </td>
                            <!--
                            <td>
                            ${dto.username}
                        </td>
                            -->

                            <!--
                            <td>
                            ${dto1.username}
                        </td>
                            -->
                            <td>
                                <input type="text" name="${txtPass}" value="" />
                            <td>
                                ${dto.lastname}
                            </td>
                            <td>
                                ${dto.isAdmin}
                                <c:if test="${chkIsAdmin}">
                                    checked = "checked"
                                </c:if>
                            </td>
                            <c:url var="delLink" value="CenterServlet">
                                <c:param name="btAction" value="Delete"></c:param>
                                <c:param name="txtUsername" value="${dto.username}"></c:param>
                                <c:param name="searchQuery" value="${name}"></c:param>
                            </c:url>
                            <td>
                                <a href="${delLink}">Delete</a>
                            </td>

                            <td>
                                <input type="hidden" value="${searchQuery}" />
                                <input type="submit" value="Update" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
