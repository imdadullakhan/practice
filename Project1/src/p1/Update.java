package p1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;

  public class Update{
			
			public static void main(String args[]) {
			
				try {
					
					System.out.println("Start Loading Driver ");
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					System.out.println("End Loading Driver ");
					
					System.out.println("Start Connection ");
					
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");
					
					System.out.println("Completed Connection ");
				
					System.out.println("Create Statment  ");
					
					//PreparedStatement ps1 = con.prepareStatement("insert into emp (empno,ename,mgrno,deptno,sal,age) values(?,?, ?,?,?,?)");
					//PreparedStatement ps = con.prepareStatement("delete from emp where empno=?");
					PreparedStatement ps= con.prepareStatement("update emp set sal=? where empno = ?");
		

					ps.setInt(1, 4500);					
					ps.setInt(2,5);
					int countofRecord = ps.executeUpdate();
					
					System.out.println("Record Inserted " + countofRecord);
				
					con.close();

				} catch (SQLException e) {
					
					System.out.println(e);
				}

			}
		}	
