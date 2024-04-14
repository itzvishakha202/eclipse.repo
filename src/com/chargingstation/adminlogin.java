package com.chargingstation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminlogin
 */
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("username"+username);
		System.out.println("password"+password);
		try{
		Connection con=DbConnection.connect();
	  PreparedStatement pstmt=con.prepareStatement("select * from admin where username=? and password=?");
	                   
	                   pstmt.setString(1,username);
	                   pstmt.setString(2,password);
	                  
	                   ResultSet rs=pstmt.executeQuery();
	                   int i=0;
	                 while(rs.next())
	                 {
	                 i=1;
	                 }
	                 if(i>0)
	                 {
	                 response.sendRedirect("admin1.html");	

	                 }else{
	                 response.sendRedirect("adminlogin.html");
	                 }
	                 }catch(SQLException e)
	                 {
	                  e.printStackTrace();	
	                 }
	}
}