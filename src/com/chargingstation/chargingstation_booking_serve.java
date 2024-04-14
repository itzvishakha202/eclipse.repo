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
 * Servlet implementation class chargingstation_booking_serve
 */
public class chargingstation_booking_serve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargingstation_booking_serve() {
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
			int station_id=Integer.parseInt(request.getParameter("station_id"));
			int power=Integer.parseInt(request.getParameter("power"));
			String name=request.getParameter("name");
			String timeslot=request.getParameter("timeslot");

			
			System.out.println("id"+station_id);
			System.out.println("power"+power);
			System.out.println("name"+name);
			System.out.println("timeslot"+timeslot);
			
			Connection con=DbConnection.connect();
			
			PreparedStatement pstmt=con.prepareStatement("insert into booking values (?,?,?,?)");
			pstmt.setInt(1,0);
			pstmt.setInt(2,station_id);
			pstmt.setInt(3,power);
			pstmt.setString(4,name);
			pstmt.setString(5,timeslot);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("chargingstation_booking.jsp");
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
