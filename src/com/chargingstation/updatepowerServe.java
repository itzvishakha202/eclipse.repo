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
 * Servlet implementation class updatepowerServe
 */
public class updatepowerServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepowerServe() {
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
		String power=request.getParameter("power");
		String power1=null;
		String power2;
		System.out.println("station_id"+cid);
		System.out.println("power"+power);
		
		try{
			
			Connection con=DbConnection.connect();
			
			PreparedStatement pstmt=con.prepareStatement("select * from chargingstation where cid=?");
			pstmt.setInt(1,cid);
			ResultSet rs=pstmt.executeQuery();
			int i=0;
			while(rs.next())
			{
			power1=rs.getString(12);
				
			}
			power2=power+power1;
			System.out.println("update power"+power2);
			PreparedStatement pstmt1=con.prepareStatement("update chargingstation set power=? where cid=?");
			pstmt1.setInt(1,cid);
			pstmt1.setString(2,power);
			int i1=pstmt1.executeUpdate();
			if(i1>0)
			{
				response.sendRedirect("chargingstation_view.jsp");
			}
			
			
		
	}
catch(SQLException e)
		{
	e.printStackTrace();
		}
		}
}
