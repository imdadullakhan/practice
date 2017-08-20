	package p1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;

  public class UpdateAll{
			
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
					PreparedStatement ps= con.prepareStatement("update emp set ename=?,mgrno=?,deptno=?,sal=?,age=? where empno = ? ");
		

					ps.setString(1, "KHAN");
					ps.setInt(2, 2);
					ps.setInt(3, 5);
					ps.setInt(4, 55555);
					ps.setInt(5, 45);
					ps.setInt(6, 5);
					int countofRecord = ps.executeUpdate();
					
					System.out.println("Record Updated " + countofRecord);
				
					con.close();

				} catch (Exception e) {
					
					System.out.println("e");
				}
			}
		}	
