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
 * Servlet implementation class chargingstation_register_servelet
 */
public class chargingstation_register_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargingstation_register_servelet() {
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
			
			int cid=Integer.parseInt(request.getParameter("cid"));
			String station_name=request.getParameter("station_name");
			String address =request.getParameter("address");
			String city =request.getParameter("city");
			String taluka =request.getParameter("taluka");
			String district=request.getParameter("district");
			String opentime =request.getParameter("opentime");
			String closetime=request.getParameter("closetime");
			int mobileno=Integer.parseInt(request.getParameter("mobileno"));
			String lattitude=request.getParameter("lattitude");
			String longitude=request.getParameter("longitude");
			String power =request.getParameter("power");
			String password=request.getParameter("password");
			String status=request.getParameter("status");
			
			
			System.out.println("cid"+cid);
			System.out.println("station_name"+station_name);
			System.out.println("address"+address);
			System.out.println("city"+city);
			System.out.println("taluka"+taluka);
			System.out.println("district"+district);
			System.out.println("opentime"+opentime);
			System.out.println("closetime"+closetime);
			System.out.println("mobileno"+mobileno);
			System.out.println("lattitude"+lattitude);
			System.out.println("longitude"+longitude);
			System.out.println("power"+power);
			System.out.println("password"+password);
			System.out.println("status"+status);
			
			
			
			
			
			
						Connection con=DbConnection.connect();
		  PreparedStatement pstmt=con.prepareStatement("insert into chargingstation values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		                  pstmt.setInt(1,cid);
		                   pstmt.setString(2,station_name);
		                   pstmt.setString(3,address);
		                   pstmt.setString(4,city);
		                   pstmt.setString(5,taluka);
		                   pstmt.setString(6,district);
		                   
		                   pstmt.setString(7,opentime);
		                   pstmt.setString(8,closetime);
		                   pstmt.setInt(9,mobileno);
		                   pstmt.setString(10,lattitude);
		                   pstmt.setString(11,longitude);
		                   pstmt.setString(12,power);
		                   pstmt.setString(13,password);
		                   pstmt.setString(14,status);
		                  
		                   
		                  
		                   
		                   
		                 int i=pstmt.executeUpdate();
		             
		                
		                 
		                 if(i>0)
		                 {
		                 response.sendRedirect("admin1.html");	

		                 }else{
		                 response.sendRedirect("chargingstationRegistration.html");
		                 }
		                 }catch(SQLException e)
		                 {
		                  e.printStackTrace();	
		                 }
		}

		}

	
		
		