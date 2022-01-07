package org.com.gen17;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("connection ready");
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","S##48k@qirt");
	//pw.println(con);

		PreparedStatement ps=con.prepareStatement(
		"select * from register1 where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,pass);
		//pw.println(ps);
		ResultSet rs=ps.executeQuery();
		//pw.println(rs);
		boolean i=rs.next();
		//pw.println(i);
		if(i==true)
		{
		pw.print("you are not successfully login");
		}
		else
		{
		pw.print("you are successfully login");
		}



		}catch(Exception e){



		pw.println(e);
		}

		}
		}

