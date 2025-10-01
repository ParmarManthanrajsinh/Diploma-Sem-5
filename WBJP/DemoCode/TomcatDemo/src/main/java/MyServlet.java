
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie c = new Cookie("name", request.getParameter("name"));
        c.setMaxAge(3600);
        response.addCookie(c);

        String myname = getServletConfig().getInitParameter("myname");

        out.println("<html><body>");
        out.println("<h1>Hello " + c.getValue() + " from " + myname + "!</h1>");
        out.println("</body></html>");
    }
}
