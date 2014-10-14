<%-- 
    Document   : index
    Created on : Oct 6, 2014, 11:35:29 PM
    Author     : thienle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form action="RequestServlet" method="post">
            username <input type="text" name="txtUsername"><br/>
            password <input type="password" name="txtPassword"><br/>
            <input type="submit" value="Login"><br/>
        </form>
    </body>
</html>
