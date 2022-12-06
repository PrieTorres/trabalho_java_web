package com.webProject.objetos;

import java.io.IOException;

import br.com.WallpaperNext.model.pasta;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pasta.dao.PastaDAO;

@WebServlet("/listar-pastas-usuario")
public class carregarPastasUsuario extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PastaDAO pastaDAO = new PastaDAO();
		
		try {
			
			List<pasta> pastasUsuario = pastaDAO.listarPastasUsuario();
			
			request.setAttribute("pastas-usuario", pastasUsuario);
			RequestDispatcher rd = request.getRequestDispatcher("suasPastas.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception  e){
			 e.printStackTrace();
		}
		
		
		
	}
	
}
