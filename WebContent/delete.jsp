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
System.out.println("id"+cid);
try{
	PreparedStatement pstmt=con.prepareStatement("delete from chargingstation where cid=?");
	pstmt.setInt(1,cid);
	int i=pstmt.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("delete_chargingstation.jsp");
	}
}
catch(SQLException e){
	e.printStackTrace();
}
%>
</body>
</html>