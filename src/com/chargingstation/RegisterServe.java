package com.chargingstation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterServe
 */
public class RegisterServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServe() {
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
		
		
		try{
			
			int u_id=Integer.parseInt(request.getParameter("u_id"));
			String name=request.getParameter("name");
			String email =request.getParameter("email");
			int mobile=Integer.parseInt(request.getParameter("mobile"));
			String password=request.getParameter("password");
			
			
			System.out.println("u_id"+u_id);
			System.out.println("name"+name);
			System.out.println("email"+email);
			System.out.println("mobile"+mobile);
			System.out.println("password"+password);
						Connection con=DbConnection.connect();
		  PreparedStatement pstmt=con.prepareStatement("insert into user values (?,?,?,?,?) ");
		                  pstmt.setInt(1,u_id);
		                   pstmt.setString(2,name);
		                   pstmt.setString(3,email);
		                   
		                   pstmt.setInt(4,mobile);
		                   pstmt.setString(5,password);
		                   
		                   
		                 int i=pstmt.executeUpdate();
		             
		                
		                 
		                 if(i>0)
		                 {
		                 response.sendRedirect("dashboard.html");	

		                 }else{
		                 response.sendRedirect("register.html");
		                 }
		                 }catch(SQLException e)
		                 {
		                  e.printStackTrace();	
		                 }
		}

		}

	