package security;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String un = request.getParameter("userName");
		String pwd = request.getParameter("password");
		String pwd1= request.getParameter("password1");
		
		if(pwd.equals(pwd1)){
			response.getWriter().append(" Password and Password1 is Same \n");
		} else {
			response.getWriter().append(" Passwor does not match \n");
		}
		
		
		System.out.println("Start Loading Driver ");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("End Loading Driver ");
			
		System.out.println("Start Connection ");		
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
		
		System.out.println("Completed Connection ");
		
		System.out.println("Create Statment  ");
		
		// TODO Auto-generated method stub
		
		//Statement statement = con.createStatement();
		PreparedStatement statment = con.prepareStatement("select * from emp where ename =?");
		statment.setString(1,un);
		
		ResultSet resultSet = statment.executeQuery();
		
		if(resultSet.next()){
			response.getWriter().append("Welcome User :" + un + "\n");
		} else {
			response.getWriter().append("Getout User :" + un + "\n");
		}
		
		response.getWriter().append("Served at: user Name " +  un  + " Password" + pwd + " Password 1  " + pwd1 ).append(request.getContextPath());
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
