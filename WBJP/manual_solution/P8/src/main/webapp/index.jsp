<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="home.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required /><br/><br/>
        
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required /><br/><br/>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required /><br/><br/>
        
        <input type="submit" value="Register" />
    </form>
</body>
</html>