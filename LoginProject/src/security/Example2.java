package security;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Example2")
public class Example2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Example2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String un=request.getParameter("userName");
		String pwd=request.getParameter("password");
		String pwd1=request.getParameter("password1");
		
		
		if(pwd.equals(pwd1)){
		 
			response.getWriter().append("passwords are equal");
	   
		}else{
			response.getWriter().append("passwords does not equal");
	
	}
	
	
	  System.out.println("start loading driver");
	  
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("end loading driver");
		System.out.println("start connection");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
		
		System.out.println("completed connection");
		
		System.out.println("create statement");
		
		PreparedStatement statement = con.prepareStatement("select * from emp where ename=?");
		
		statement.setString(1,un);
		
        ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()){
			response.getWriter().append("Welcome User :" + un + "\n");
		} else {
			response.getWriter().append("Getout User :" + un + "\n");
		}
		
		response.getWriter().append("Served at: user Name " +  un  + " password" + pwd + " password1  " + pwd1 ).append(request.getContextPath());
		
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (SQLException e) {
       		e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
