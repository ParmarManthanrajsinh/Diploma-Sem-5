import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        List<Student> list = session.createQuery("from Student", Student.class).list();

        request.setAttribute("studentList", list);
        session.close();
        factory.close();

        RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
        rd.forward(request, response);
    }
}
