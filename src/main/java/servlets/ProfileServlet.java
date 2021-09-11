package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		req.getRequestDispatcher("link.html").include(req, resp);
		Cookie ck[]=req.getCookies();
		if(ck!=null) {
			String name=ck[0].getValue();
			if(!name.equals("")) {
				out.print("<b>Welcome to Profile</b>");
				out.print("<br Welcome, "+name);
			} 
			} else  {
				out.print("Please Login First!");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		
		out.close();
	}
	
}
