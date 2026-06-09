package org.com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello/*")
public class Reportservlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		res.setContentType("text/html");
		PrintWriter writer=res.getWriter();
		 Gson gson=new Gson();
         BufferedReader reader = req.getReader();
         StringBuilder json = new StringBuilder();
         String line;
         
         while((line=reader.readLine())!=null) { //Read the request one by one like {,name,vinod,}
        	 json.append(line);//add the value to the line object
         }
         
         JsonObject obj=gson.fromJson(json.toString(), JsonObject.class);
         
         String name=obj.get("name").getAsString();
         int age=obj.get("age").getAsInt();
         
         JsonObject response=new JsonObject();
         response.addProperty("Name", name);
         response.addProperty("Age", age);
         
         writer.print(response);
         
         

}
}