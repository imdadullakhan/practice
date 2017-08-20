<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<head><title>Enter to database</title></head>
<table>

<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*;" %>
<% 

java.sql.Connection con;
java.sql.Statement s;
java.sql.ResultSet rs;
java.sql.PreparedStatement pst;

con=null;
s=null;
pst=null;
rs=null;

// Remember to change the next line with your own environment 
//String ur1=getInitParameter("LoginSecond");
String un= "username";
String pwd = "password";
try{

Class.forName("oracle.jdbc.driver.OracleDriver");
con = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "imdad", "khan8374");

}catch(ClassNotFoundException cnfex){
cnfex.printStackTrace();

}
String sql = "select top 10 * from tbl_sys_user";
try{
s = con.createStatement();
rs = s.executeQuery(sql);
%>

<%
while( rs.next() ){
%><tr>
<td><%= rs.getString("cust_id") %></td>
<td><%= rs.getString("rdate") %></td>
<td><%= rs.getString("email") %></td>
</tr>
<%
}
%>

<%

}
catch(Exception e){e.printStackTrace();}
finally{
if(rs!=null) rs.close();
if(s!=null) s.close();
if(con!=null) con.close();
}

%>

</body>
</html>