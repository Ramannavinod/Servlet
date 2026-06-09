package org.com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello/*")
public class Reportservlet extends HttpServlet{
	
	private static Map<Integer, JsonObject> inmemory=new HashMap();
	Gson gson=new Gson();
	
//	@Override
//	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
//		res.setContentType("text/html");
//		PrintWriter writer=res.getWriter();
//		 Gson gson=new Gson();
//         BufferedReader reader = req.getReader();
//         StringBuilder json = new StringBuilder();
//         String line;
//         
//         while((line=reader.readLine())!=null) { //Read the request one by one like {,name,vinod,}
//        	 json.append(line);//add the value to the line object
//         }
//         
//         JsonObject obj=gson.fromJson(json.toString(), JsonObject.class);
//         
//         String name=obj.get("name").getAsString();
//         int age=obj.get("age").getAsInt();
//         
//         JsonArray arr=obj.getAsJsonArray("address");
//         
//         JsonObject response=new JsonObject();
//         response.addProperty("Name", name);
//         response.addProperty("Age", age);
//         response.add("Address", arr);
////         
////         String xml="<employee>"
////         		+ "<name>"+name+"</name>"
////         		+ "<age>"+age+"</age>"
////         		+ "</employee>";
//        		 
//        		 
//         
//         writer.print(response);
//         
	//Performing CRUD operation
         @Override
         protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        	        throws ServletException, IOException {
                PrintWriter wri=resp.getWriter();
        	    JsonObject obj = gson.fromJson(req.getReader(), JsonObject.class);

        	    int id = obj.get("id").getAsInt();

        	    inmemory.put(id, obj);
        	    wri.print("Data is Created");
       }
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	   PrintWriter wri=resp.getWriter();
    	   int id=Integer.parseInt(req.getParameter("id"));
    	   JsonObject ret=inmemory.get(id);
    	   
    	   if(ret!=null) {
    		   wri.print(ret);
    	   }
    	   else {
    		   wri.print("User not Found");
    	   }
    }
       @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter wir=resp.getWriter();
    	   int id=Integer.parseInt(req.getParameter("id"));
    	inmemory.remove(id);
    	wir.print("User is removed");
    }
}
