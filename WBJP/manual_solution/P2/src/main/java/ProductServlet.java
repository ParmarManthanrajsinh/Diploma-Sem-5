import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    @Override
    public void init() throws ServletException {
        dbUrl = getServletConfig().getInitParameter("dbUrl");
        dbUser = getServletConfig().getInitParameter("dbUser");
        dbPassword = getServletConfig().getInitParameter("dbPassword");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Product Selection</title></head><body>");
        out.println("<h2>Select a Product to view its Price:</h2>");
        out.println("<form method='get' action='ProductServlet'>");
        out.println("<select name='product'>");

        // Display product options
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT name FROM products")) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    out.println("<option value='" + name + "'>" + name + "</option>");
                }
            }
        } catch (Exception e) {
            out.println("<p>Error loading products: " + e.getMessage() + "</p>");
        }

        out.println("</select>");
        out.println("<input type='submit' value='Get Price'>");
        out.println("</form>");

        // Display selected product price
        String selectedProduct = request.getParameter("product");
        if (selectedProduct != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                        PreparedStatement stmt = conn.prepareStatement("SELECT price FROM products WHERE name = ?")) {

                    stmt.setString(1, selectedProduct);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            double price = rs.getDouble("price");
                            out.println("<h2>You selected: " + selectedProduct + "</h2>");
                            out.println("<h3>Price: " + price + "</h3>");
                        } else {
                            out.println("<h3>Product not found!</h3>");
                        }
                    }
                }
            } catch (Exception e) {
                out.println("<p>Error fetching price: " + e.getMessage() + "</p>");
            }
        } else {
            out.println("<h3>Please select a product.</h3>");
        }

        out.println("</body></html>");
        out.close();
    }
}
