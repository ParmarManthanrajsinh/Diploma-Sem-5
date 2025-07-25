
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    @Override
    public void init() throws ServletException {
        dbUrl = getServletConfig().getInitParameter("dbUrl");
        dbUser = getServletConfig().getInitParameter("dbUser");
        dbPassword = getServletConfig().getInitParameter("dbPassword");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Connecting to database...</h1>");

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            out.println("<p>Creating connection...</p>");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            out.println("<p>Connection successful!</p>");

            stmt = conn.createStatement();

            String sql = "SELECT id, name FROM emp";
            ResultSet rs = stmt.executeQuery(sql);

            out.println("<h2>Query Results:</h2>");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                out.println("<p>ID: " + id + ", Name: " + name + "</p>");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace(out);
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                // ignore
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                // ignore
            }
        }

        out.println("</body></html>");
    }
}
