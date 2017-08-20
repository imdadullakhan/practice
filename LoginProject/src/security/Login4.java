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

@WebServlet("/Login4")
public class Login4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login4() {
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
			response.getWriter().append("passwords does not match");
	
	}
	
	try {
		
		System.out.println("start loading driver");
		  
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("end loading driver");
		
		System.out.println("start connection");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
		
		System.out.println("completed connection");
		
		System.out.println("create statement");
		
		PreparedStatement statement = con.prepareStatement("insert into emp (empno,ename,mgrno,deptno,sal,age) values(?,?, ?,?,?,?)");

		
		statement.setInt(1, 14);
		statement.setString(2, "Basheer");
		statement.setInt(3, 1);
		statement.setInt(4, 1);
		statement.setInt(5, 10000);
		statement.setInt(6, 35);

		int countofRecord  = statement.executeUpdate();
		
        ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()){
			response.getWriter().append("Welcome User :" + un + "\n");
		} else {
			response.getWriter().append("password is incorrect :" + un + "\n");
		}
		
		response.getWriter().append("Served at: userName  "   +  un  + " password  " +  pwd  + " password1 " + pwd1 ).append(request.getContextPath());
		
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
			
		} catch (SQLException e) {
			
       		e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
