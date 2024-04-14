<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
    <%@ page import="com.chargingstation.DbConnection" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection con=DbConnection.connect(); 

int cid=Integer.parseInt(request.getParameter("cid"));
String status="Approved";
System.out.println("id"+cid);
try{
	PreparedStatement pstmt=con.prepareStatement("update chargingstation set status=? where cid=?");
	pstmt.setString(1,status);
	pstmt.setInt(2,cid);
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("chargingstation_update.jsp");
	}
}
catch(SQLException e){
	e.printStackTrace();
}
%>
</body>
</html>