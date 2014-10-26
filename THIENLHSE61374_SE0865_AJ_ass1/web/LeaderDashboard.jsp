<%--
    Document   : LeaderDashboard
    Created on : Oct 17, 2014, 10:17:15 PM
    Author     : thienlh
--%>

<%@page import="sample.student.StudentDTO"%>
<%@page import="sample.student.StudentDAO"%>
<%@page import="java.util.List"%>
<%@page import="sample.personnel.personnelDAO"%>
<%@page import="sample.account.AccountDAO"%>
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

        <%--Get Semester and block --%>
        <%! AccountDAO dao = new AccountDAO();%>
        <%! personnelDAO personnelDao = new personnelDAO();%>
        <%! StudentDAO stDao = new StudentDAO();%>
        <% personnelDao.getBlockSemester();%>
        <form action="CenterServlet">
        Semester: <select name="ddlSemester">
            <option>All</option>
            <%
                List<String> semesterList = personnelDao.getSemesterList();
                for (int i = 0; i < semesterList.size(); i++) {
                    out.println("<option>"
                            + semesterList.get(i)
                            + "</option>");
                }
            %>
        </select><br/>
        Block: <select name="ddlBlock">
            <option>All</option>
            <%
                List<String> blockList = personnelDao.getBlockList();
                for (int i = 0; i < blockList.size(); i++) {
                    out.println("<option>"
                            + blockList.get(i)
                            + "</option>");
                }
            %>
        </select><br/>
        <input type="submit" value="Search" name="btAction"/>
        </form>

        <h2>Search Result</h2><br/>
        <%
            String username = (String) session.getAttribute("USER");
            String classID = dao.getClassID(username);
            String block = request.getParameter("ddlBlock");
            String semester = request.getParameter("ddlSemester");

            List<StudentDTO> result = stDao.search(classID, block, semester);
            
            %>
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Enrollment</th>
                        <th>Full name</th>
                        <th>Avg</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                        for (int i=0; i < result.size(); i++) {
                            StudentDTO reg = result.get(i);
                            %>
                            <td><=(i+1)%></td>
                            <td>
                                <%=reg.getStudentID()%>
                            </td>
                        <%
                        }
                        %>
                    </tr>
                </tbody>
            </table>

        <%
        %>
    </body>
</html>
