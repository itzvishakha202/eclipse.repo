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
 * Servlet implementation class charging_station_approved
 */
public class charging_station_approved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public charging_station_approved() {
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
		String status=request.getParameter("status");
		
		System.out.println("id"+cid);
		System.out.println("status"+status);
		try{
			Connection con=DbConnection.connect();
			
			PreparedStatement pstmt=con.prepareStatement("update chargingstation set status=? where cid=?");
			pstmt.setInt(1,cid);
			pstmt.setString(2,status);
			
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("admin1.html");
			}
			else{
				response.sendRedirect("chargingstation_approved.html");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			}	
		}
		}


