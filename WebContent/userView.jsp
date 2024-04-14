<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.chargingstation.DbConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>the view of database table</title>
</head>
<body
BGCOLOR="grey">
<center>
<h1>the view of database table</h1>
 <% 
  Connection con=DbConnection.connect(); 
try{
	PreparedStatement pstmt=con.prepareStatement("select * from user");
	ResultSet resultset=pstmt.executeQuery();
%>
<table border="1">
<tr>
<th>u_id</th>
<th>name</th>
<th>email</th>
<th>mobile</th>
<th>password</th>

</tr>
<% 
while(resultset.next()){ %>
<tr>
 <td><%=resultset.getInt(1) %></td>
<td><%=resultset.getString(2) %></td>
<td><%=resultset.getString(3) %></td>
<td><%=resultset.getInt(4) %></td>
<td><%=resultset.getString(5) %></td>

</tr>
<% }
}catch(Exception e){
	
	e.printStackTrace();
	}%>
		
</centre>

</table>
</body>

</html>

