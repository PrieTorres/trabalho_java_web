package com.webProject.objetos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/insert-foto")
public class Foto extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			PrintWriter output = res.getWriter();
			
			output.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
