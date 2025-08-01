<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String maths = request.getParameter("maths");
    String science = request.getParameter("science");
    String english = request.getParameter("english");
    String history = request.getParameter("history");
    String geography = request.getParameter("geography");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Grade</title>
</head>
<body>
    <h1>Enter Your Marks</h1>
    <form action="" method="post">
        <label>Maths</label>
        <input type="number" id="marks" name="maths" maxlength="100">

        <br>
        <label>Science</label>
        <input type="number" id="science" name="science" maxlength="100">

        <br>
        <label>English</label>
        <input type="number" id="english" name="english" maxlength="100">
        
        <br>
        <label>History</label>
        <input type="number" id="history" name="history" maxlength="100">
        
        <br>
        <label>Geography</label>
        <input type="number" id="geography" name="geography" maxlength="100">
        
        <br>
        <button type="submit">Submit</button>
    </form>

<%
    if (maths != null && science != null && english != null && history != null && geography != null) {
        try {
            int mathsMarks = Integer.parseInt(maths);
            int scienceMarks = Integer.parseInt(science);
            int englishMarks = Integer.parseInt(english);
            int historyMarks = Integer.parseInt(history);
            int geographyMarks = Integer.parseInt(geography);

            int totalMarks = mathsMarks + scienceMarks + englishMarks + historyMarks + geographyMarks;
            double averageMarks = totalMarks / 5.0;

            String grade;
            if (averageMarks >= 90) {
                grade = "A";
            } else if (averageMarks >= 80) {
                grade = "B";
            } else if (averageMarks >= 70) {
                grade = "C";
            } else if (averageMarks >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            out.println("<h2>Total Marks: " + totalMarks + "</h2>");
            out.println("<h2>Average Marks: " + averageMarks + "</h2>");
            out.println("<h2>Grade: " + grade + "</h2>");
        } catch (NumberFormatException e) {
            out.println("<h2>Please enter valid numeric marks.</h2>");
        }
    }
%>
</body>
</html>