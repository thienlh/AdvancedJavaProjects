<%-- 
    Document   : index
    Created on : Oct 15, 2014, 4:34:05 PM
    Author     : thienlh
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sun's JSP Standard Tag Library - Core Tag Library</h1>
        <b>c:set, c:out and c:remove</b><br/>
        <c:set var="num" value="10"/>
        Print the value of num <c:out value="${num}"/> <br/>
        Remove the value of num <c:remove var="num" /><br/>
        Print the value of num again <c:out value="${num}" /><br/><br/>

        <c:set var="addInfo" value="LE HUNG THIEN" />
        <c:out value="${addInfo}" /><br/>
        <%= request.getAttribute("addInfo")%><br/><br/>

        <c:set var="addInfo2" value="THIENLHSE61374" scope="session"/>
        ${addInfo2}<br/>
        <%= request.getAttribute("addInfo2")%><br/>
        ${requestScope.addInfo2}<br/>
        <%= session.getAttribute("addInfo2")%><br/>
        ${sessionScope.addInfo2}<br/><br/>


        <b>c:if, c:choose (Decision making)</b><br/>
        <c:set var="num1" value="534"/>
        <c:set var="num2" value="9394"/>
        <c:if test="${num1 le num2}">
            <c:out value="num 1 is less than or equal num 2"/><br/><br/>
        </c:if>

        <b>Exception demo c:catch</b><br/><br/>

        <form action="index.jsp">
            Num1: <input type="text" name="n1" value="${param.n1}" /><br/>
            Num2: <input type="text" name="n2" value="${param.n2}" /><br/>

            <c:catch var="ex">
                <c:if test="${not empty param.n1 and not empty param.n2}">
                    <c:set var="result" value="${param.n1 / param.n2}"/>
                    Division: <c:out value="${result}"/><br/>
                </c:if><br/>
            </c:catch>

            <input type="submit" value="Divide" />

            <c:if test="${not empty ex}">
                Error occurred!<br/>
                <c:out value="${ex}"/>
            </c:if><br/>
        </form>

        <br/><b>c:choose demo</b><br/><br/>
        <form action="index.jsp">
            Number: <input type="text" name="num" value="${param.num}" />  
            <input type="submit" value="Check" /><br/>
            <c:set var="num" value="${param.num}" />
            <c:catch var="ex">
                <c:choose>
                    <c:when test="${empty param.num}"/>
                    <c:when test="${param.num%2 ne 0}">
                        ${param.num} is an odd number!<br/>
                    </c:when>
                    <c:when test="${param.num%2 eq 0}">
                        ${param.num} is an even number!<br/>
                    </c:when>
                </c:choose>
            </c:catch>

            <c:if test="${not empty ex}">
                Error occurred!<br/>
                <c:out value="${ex}"/>
            </c:if>
        </form>

        <br/><b>c:forEach and c:forTokens demo</b><br/><br/>
        <c:set var="names" value="Thien, Huong, Thanh. Tuan. Lam"/>
        <%! String[] places = {"Hoi An", "Hue", "Ha Noi", "Sai Gon"}; %>
        <!--c:forEach-->
        Places: 
        <c:forEach items="<%= places %>" var="place">
            <c:out value="${place}"/>  
        </c:forEach>
        <br/>
        <!--c:forToken-->
        Names:  
        <c:forTokens delims=".," items="${names}" var="name">
            <c:out value="${name}"/>  
        </c:forTokens>
        <br/>
        Counter:  
        <c:forEach begin="1" end="10" step="1" var="count">
            <c:out value="${11 - count}"/>
        </c:forEach>
        
        <br/><b>c:import and c:redirect demo</b><br/><br/>
        
        <c:url var="nextPage" value="nextPage.jsp">
            <c:param name="user" value="Thien"/>
        </c:url>
        <a href="${nextPage}">Click here to go to the next page</a>
        
    </body>
</html>
