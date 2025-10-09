<%@ page import="java.util.*, Student" %>
<html>
    <head><title>Student List</title></head>

    <body>
    <h2>All Students</h2>
        <table border="1" cellpadding="5">
        <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Branch</th>
        </tr>

        <%
            List<Student> list = (List<Student>) request.getAttribute("studentList");
            for(Student s : list){
        %>

            <tr>
            <td><%= s.getStudent_id() %></td>
            <td><%= s.getStudent_name() %></td>
            <td><%= s.getStudent_branch() %></td>
            </tr>

        <% } %>
        </table>
    </body>
</html>
