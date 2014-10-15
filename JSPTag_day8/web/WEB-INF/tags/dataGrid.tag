<%-- 
    Document   : dataGrid
    Created on : Oct 15, 2014, 2:47:03 AM
    Author     : thienlh
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="dataSource" required="true"%>
<%@attribute name="sql" required="true"%>
<%@tag dynamic-attributes="params" %>

<c:if test="${not empty dataSource}">
    <c:catch>
        <sql:setDataSource var="cn" dataSource="${dataSource}"/>
        <c:if test="${not empty cn}">
            <sql:query dataSource="${cn}" sql="${sql}">
                <c:forEach var="p" items="${param}">
                    <sql:param value="${p.value}"/>
                </c:forEach>
                <c:if test="${not empty p}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                    <c:forEach var="columnName" items="${rs.columnNames}">
                                    <th>${columnName}</th>
                                    </c:forEach>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="row" items="${rs.rowsByIndex}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <c:forEach var="field" items="${row}">
                                        <td>${field}</td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </c:if>
            </sql:query>
        </c:if>
    </c:catch>
    <c:if test="${not empty ex}">

    </c:if>
</c:if>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>