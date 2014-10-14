<%-- 
    Document   : declarative
    Created on : Oct 13, 2014, 1:15:25 AM
    Author     : thienlh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSP Life cycle!</h1>
        <%!
            int num;

            public void jspInit() {
                System.out.println("jspInit is invoked!");
                num = 10;
            }

            public void jspDestroy() {
                System.out.println("jspDestroy is invoked!");
                num = 10;
            }

            public int add(int n) {
                System.out.println("add is called!");
                num += n;
                return num;
            }

            public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
                    throws java.io.IOException, javax.servlet.ServletException {
                System.out.println("This is service!");
            }
        %>

        Init number <%=num%></br>
        <%out.println("Result of add is " + add(5));%>
    </body>
</html>
