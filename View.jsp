<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1">
				<tr>
					<th>firstname</th>
					<th>lastname</th>
					<th>username</th>
					<th>password</th>
				
				
				</tr>

<%
Connection con =null;
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
}catch(ClassNotFoundException e){
	e.printStackTrace();
}
try{
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","irf","irf"); 
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery("select * from emp");
	
	while(r.next()){
%>
 		<tr>
 			<td><%=r.getString("Firstname") %></td>
 			<td><%=r.getString("Lastname") %></td>
 			<td><%=r.getString("username") %></td>
 			<td><%=r.getString("password") %></td> 		
 		</tr>
<%
	}
}catch(SQLException e){
	e.printStackTrace();
}

%>
</table>
</center>
</body>
</html>