package security;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/New1")
public class New1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public New1() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno =request.getParameter("empno");
		String ename =request.getParameter("ename");
		String mgrno =request.getParameter("mgrno");
		String deptno =request.getParameter("deptno");
		String sal =request.getParameter("sal");
		String age =request.getParameter("age");
		
    	PrintWriter out = response.getWriter();


	try {
		
		System.out.println("start loading driver");
		  
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("end loading driver");
		
		System.out.println("start connection");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
		
		System.out.println("completed connection");
		
		System.out.println("create statement");
		
		PreparedStatement statement = con.prepareStatement("select * from emp where empno=? ");
		PreparedStatement statement1 = con.prepareStatement("insert into emp (empno,ename,mgrno,deptno,sal,age) values(?,?, ?,?,?,?)");
		PreparedStatement statement2 = con.prepareStatement("update emp set ename=?,mgrno=?,deptno=?,sal=?,age=? where empno=?");
		
		statement.setString(1, empno);
		ResultSet  rs = statement.executeQuery();
	
		if(rs.next()){
			
			statement2.setString(6, empno);
			statement2.setString(1, ename);
			statement2.setString(2, mgrno);
			statement2.setString(3, deptno);
			statement2.setString(4, sal);
			statement2.setString(5, age);				
		
			statement2.executeUpdate();
			out.println("record updated successfully");
			
			
		} else{
		
		statement1.setString(1, empno);
		statement1.setString(2, ename);
		statement1.setString(3, mgrno);
		statement1.setString(4, deptno);
		statement1.setString(5, sal);
		statement1.setString(6, age);
		
		
		statement1.executeUpdate();
		out.println("record inserted successfully");
		
		}
		
		} catch (ClassNotFoundException e) {
			out.println("data is  not added succefully");
			e.printStackTrace();
			
		} catch (SQLException e) {
			out.println("data is  not added succefully");
       		e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
