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
 * Servlet implementation class chargingstationloginServe
 */
public class chargingstationloginServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargingstationloginServe() {
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
		

		int cid=Integer.parseInt(request.getParameter("cid"));
		String password=request.getParameter("password");
		System.out.println("cid"+cid);
		System.out.println("password"+password);
		try{
		Connection con=DbConnection.connect();
	  PreparedStatement pstmt=con.prepareStatement("select * from chargingstation where cid=? and password=?");
	                   
	                   pstmt.setInt(1,cid);
	                   pstmt.setString(2,password);
	                  
	                   ResultSet rs=pstmt.executeQuery();
	                   int i=0;
	                 while(rs.next())
	                 {
	                 i=1;
	                 }
	                 if(i>0)
	                 {
	                 response.sendRedirect("chargingstation1.html");	

	                 }else{
	                 response.sendRedirect("chargingstationlogin.html");
	                 }
	                 }catch(SQLException e)
	                 {
	                  e.printStackTrace();	
	                 }
	}
}

		
