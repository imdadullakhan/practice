package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ABCServlet extends HttpServlet {
		 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub  
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

ServletConfig config = getServletConfig();
ServletContext context = getServletContext();

context.getInitParameter("Menu");
config.getInitParameter("TableName");
				
		PrintWriter out = resp.getWriter();
		out.print("<h1>Bismillah</h1>");
		super.doGet(req, resp);
	}

}
