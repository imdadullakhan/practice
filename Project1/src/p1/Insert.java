package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Insert {
		
		public static void main(String args[]) {
		
			try {
				System.out.println("Start Loading Driver ");
				
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
				System.out.println("End Loading Driver ");
					
				System.out.println("Start Connection ");		
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
				System.out.println("Completed Connection ");
				
				System.out.println("Create Statment  ");
				PreparedStatement ps = con.prepareStatement("insert into emp (empno,ename,mgrno,deptno,sal,age) values(?,?, ?,?,?,?)");
				// ps = con.prepareStatement("delete from emp where empno=?");
				
				
				ps.setInt(1, 14);
				ps.setString(2, "Basheer");
				ps.setInt(3, 1);
				ps.setInt(4, 1);
				ps.setInt(5, 100000);
				ps.setInt(6, 35);
				
				int countofRecord = ps.executeUpdate();
				
				System.out.println("Record Inserted " + countofRecord);
			
				con.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		}
	}	
	
