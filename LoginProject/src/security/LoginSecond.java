package security;

import java.sql.Connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/LoginSecond")


public class LoginSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
    public LoginSecond() {
        super();
        // TODO Auto-generated constructor stub
    }
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String un = request.getParameter("userName");
			String pwd = request.getParameter("pwd");
			
			PrintWriter out = response.getWriter();
			
			if(un==pwd){
				out.println("Welcome : " + un);
			} else {
				out.println("Getout :" + un);
			}
				
			//out.append("Served at: user Name " +  un  + " Password" + pwd ).append(request.getContextPath());
		}
	
		 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				doGet(request, response);
			}
	
     } 
