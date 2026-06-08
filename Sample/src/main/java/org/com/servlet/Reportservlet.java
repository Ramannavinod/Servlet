package org.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class Reportservlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<h1>Welcome to Servlet World....</h1>");
		
		System.out.println("Reportservlet doGet method called");
	}

}
