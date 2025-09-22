

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StudentLoginController")
public class StudentLoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        StudentLoginModel student = new StudentLoginModel(username, password);
        StudentLoginDAO dao = new StudentLoginDAO();
        
        StudentLoginModel validatedStudent = dao.validateStudent(student);
        
        if (validatedStudent != null) {
            HttpSession session = request.getSession();
            session.setAttribute("student", validatedStudent);
            // Display success message on the same login page
            response.sendRedirect("StudentLogin.jsp?status=success&username=" + username);
        } else {
            response.sendRedirect("StudentLogin.jsp?status=failed");
        }
    }
}