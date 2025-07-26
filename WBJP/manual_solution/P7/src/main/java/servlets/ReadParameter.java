package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReadParameter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		if (session.getAttribute("password") != null) {
			out.println("<html><body>");
			out.println("You are already logged in.<br>");
			out.println("</body></html>");
			out.close();
			return;
		}
		
		out.println("<html><body>");
		out.println("<form method='post' action='ReadParameter'>");
		out.println("Name: <input type='text' name='name'><br>");
		out.println("Password: <input type='password' name='password'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");	
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		
		String name = request.getParameter("name");
        String password = request.getParameter("password");

		Cookie nameCookie = new Cookie("name", name);
		nameCookie.setMaxAge(60 * 60);
		response.addCookie(nameCookie);

		HttpSession session = request.getSession();
		session.setAttribute("password", password);
		
        out.print("Name: " + nameCookie.getValue() + "<br>");
        out.print("Password: " + session.getAttribute("password") + "<br>");
		out.println("</body></html>");

        out.close();
	}
}
