<%-- 
    Document   : index
    Created on : Oct 15, 2014, 2:04:45 AM
    Author     : thienlh
--%>
<%@taglib uri="/WEB-INF/tlds/MyTaglib.tld" prefix="thien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <thien:ClassicEmptyTag/></br>
        Sau khi goi tag!
        <h2>Classic /w Attribute Tag Support</h2>
        co attribute <thien:ClassicAttributeTagSupport count="10"/><br/>
        Co att nhung khong co value <thien:ClassicAttributeTagSupport count=""/><br/>
        Khong co att <thien:ClassicAttributeTagSupport/><br/>
        co att nhung value sai <thien:ClassicAttributeTagSupport count="a"/><br/>
       
    </body>
</html>
