package p1;

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

@WebServlet("/UpdateData")

public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public UpdateData() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno= request.getParameter("empno");
		String ename= request.getParameter("ename");
		String mgrno= request.getParameter("mgrno");
		String deptno= request.getParameter("deptno");
		
		PrintWriter out = response.getWriter();

		try {
			
			System.out.println("start loading driver");
			  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("end loading driver");
			
			System.out.println("start connection");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
			
			System.out.println("completed connection");
			
			System.out.println("create statement");
			
			PreparedStatement insert = con.prepareStatement("insert into emp (empno,ename,mgrno,deptno) values(?,?, ?,?)");
			PreparedStatement updt = con.prepareStatement("update emp set ename=?,mgrno=?,deptno=? where empno=?");			
			PreparedStatement statement = con.prepareStatement("select * from emp where empno=? ");

			statement.setString(1, empno);
			ResultSet  rs = statement.executeQuery();
		
			if(rs.next()){
				
				updt.setString(4, empno);
				updt.setString(1, ename);
				updt.setString(2, mgrno);
				updt.setString(3, deptno);
			
				updt.executeUpdate();
				out.println("record updated successfully");
			
			} else{
			
		       insert.setString(1, empno);
			   insert.setString(2, ename);
			   insert.setString(3, mgrno);
			   insert.setString(4, deptno);
			
			   insert.executeUpdate();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
