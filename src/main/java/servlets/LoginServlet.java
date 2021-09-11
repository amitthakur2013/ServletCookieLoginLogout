package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		req.getRequestDispatcher("link.html").include(req, resp);
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		if(password.equals("admin123")) {
			out.print("You are successfully logged in!");
			out.print("<br>Welcome "+name);
			
			Cookie ck=new Cookie("name", name);
			resp.addCookie(ck);
			
		} else {
			out.print("sorry, username or password invalid!");
			req.getRequestDispatcher("login.html").include(req, resp);
			
		}
		
		out.close();
	}
}
