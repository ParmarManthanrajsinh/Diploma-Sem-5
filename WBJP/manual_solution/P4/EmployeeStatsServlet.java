import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeStatsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // Aggregate queries using HQL
        Long totalEmployees = (Long) session.createQuery("select count(e) from Employee e").uniqueResult();
        Double maxSalary = (Double) session.createQuery("select max(e.salary) from Employee e").uniqueResult();
        Double minSalary = (Double) session.createQuery("select min(e.salary) from Employee e").uniqueResult();
        Double sumSalary = (Double) session.createQuery("select sum(e.salary) from Employee e").uniqueResult();
        Double avgSalary = (Double) session.createQuery("select avg(e.salary) from Employee e").uniqueResult();

        // Set attributes for JSP
        request.setAttribute("total", totalEmployees);
        request.setAttribute("max", maxSalary);
        request.setAttribute("min", minSalary);
        request.setAttribute("sum", sumSalary);
        request.setAttribute("avg", avgSalary);

        session.close();
        factory.close();

        RequestDispatcher rd = request.getRequestDispatcher("showStats.jsp");
        rd.forward(request, response);
    }
}
