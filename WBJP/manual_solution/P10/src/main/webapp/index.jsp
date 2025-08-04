<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="db.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
</head>
<body>
<h2>Student Management System</h2>

<%
    // --- Handle Insert ---
    String action = request.getParameter("action");

    if("insert".equals(action)) {
        String name = request.getParameter("name");
        String course = request.getParameter("course");

        if(name != null && course != null && !name.isEmpty() && !course.isEmpty()) {
            try(Connection con = DBConnection.getConnection()) {
                String sql = "INSERT INTO students(name, course) VALUES(?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, course);
                int rows = ps.executeUpdate();
                if(rows > 0){
                    out.println("<p style='color:green'>Record Inserted Successfully!</p>");
                }
            } catch(Exception e) {
                out.println("<p style='color:red'>Error inserting record: " + e.getMessage() + "</p>");
            }
        }
    }

    // --- Handle Update ---
    else if("update".equals(action)) {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String course = request.getParameter("course");

        if(idStr != null && name != null && course != null) {
            try(Connection con = DBConnection.getConnection()) {
                String sql = "UPDATE students SET name=?, course=? WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, course);
                ps.setInt(3, Integer.parseInt(idStr));
                int rows = ps.executeUpdate();
                if(rows > 0){
                    out.println("<p style='color:green'>Record Updated Successfully!</p>");
                } else {
                    out.println("<p style='color:red'>No record found to update.</p>");
                }
            } catch(Exception e) {
                out.println("<p style='color:red'>Error updating record: " + e.getMessage() + "</p>");
            }
        }
    }

    // --- Handle Delete ---
    else if("delete".equals(action)) {
        String idStr = request.getParameter("id");
        if(idStr != null) {
            try(Connection con = DBConnection.getConnection()) {
                String sql = "DELETE FROM students WHERE id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(idStr));
                int rows = ps.executeUpdate();
                if(rows > 0){
                    out.println("<p style='color:green'>Record Deleted Successfully!</p>");
                } else {
                    out.println("<p style='color:red'>No record found to delete.</p>");
                }
            } catch(Exception e) {
                out.println("<p style='color:red'>Error deleting record: " + e.getMessage() + "</p>");
            }
        }
    }
%>

<!-- Display Student Table -->
<table border="1" cellpadding="5" cellspacing="0">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Course</th>
    <th>Action</th>
</tr>
<%
    try(Connection con = DBConnection.getConnection()) {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");
        int count = 1;

        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String course = rs.getString("course");
%>
<tr>
    <td><%= count++ %></td>
    <td><%= name %></td>
    <td><%= course %></td>
    <td>
        <!-- Delete Button -->
        <form action="index.jsp" method="post" style="display:inline;">
            <input type="hidden" name="id" value="<%= id %>">
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Delete" onclick="return confirm('Delete this record?')">
        </form>

        <!-- Update Button (opens edit form) -->
        <form action="index.jsp" method="get" style="display:inline;">
            <input type="hidden" name="editId" value="<%= id %>">
            <input type="submit" value="Edit">
        </form>
    </td>
</tr>
<%
        }
    } catch (SQLException e) {
        out.println("<tr><td colspan='4'>Error: " + e.getMessage() + "</td></tr>");
    }
%>
</table>

<hr>

<%
    // Show Edit Form if editId is provided
    String editId = request.getParameter("editId");
    if(editId != null) {
        try(Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(editId));
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
%>
<h3>Edit Student</h3>
<form action="index.jsp" method="post">
    <input type="hidden" name="id" value="<%= editId %>">
    <input type="hidden" name="action" value="update">

    <label>Name:</label>
    <input type="text" name="name" value="<%= rs.getString("name") %>" required><br>

    <label>Course:</label>
    <input type="text" name="course" value="<%= rs.getString("course") %>" required><br>

    <input type="submit" value="Update Student">
</form>
<%
            }
        }
    }
%>

<hr>

<!-- Insert Form -->
<h3>Add New Student</h3>
<form action="index.jsp" method="post">
    <input type="hidden" name="action" value="insert">

    <label>Name:</label>
    <input type="text" name="name" required><br>

    <label>Course:</label>
    <input type="text" name="course" required><br>

    <input type="submit" value="Add Student">
</form>

</body>
</html>
