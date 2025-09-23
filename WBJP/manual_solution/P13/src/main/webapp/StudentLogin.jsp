<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Login</title>
</head>
<body>
    <h2>Student Login</h2>
    
    <form action="StudentLoginController" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form>
    
    <% 
        String status = request.getParameter("status");
        if ("failed".equals(status)) {
            out.println("<p style='color:red;'>Invalid username or password. Please try again.</p>");
        } else if ("success".equals(status)) {
            String username = request.getParameter("username");
            out.println("<p style='color:green;'>Welcome " + username + "! You have been successfully logged in.</p>");
        }
    %>
</body>
</html>