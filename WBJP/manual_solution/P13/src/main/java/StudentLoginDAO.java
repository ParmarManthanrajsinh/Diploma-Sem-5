
import java.sql.*;

public class StudentLoginDAO {

    public StudentLoginModel validateStudent(StudentLoginModel student) {
        StudentLoginModel validatedStudent = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE name=? AND password=?");

            ps.setString(1, student.getUsername());
            ps.setString(2, student.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                validatedStudent = new StudentLoginModel();
                validatedStudent.setUsername(rs.getString("name"));
                validatedStudent.setPassword(rs.getString("password"));
                validatedStudent.setCourse(rs.getString("course"));
                validatedStudent.setLoginStatus(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validatedStudent;
    }
}