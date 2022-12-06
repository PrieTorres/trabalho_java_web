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

// @WebServlet("WallpaperNext_web/pastas-prontas.html")
@SuppressWarnings("serial")
@WebServlet("/listar-pastas-prontas")
public class carregarPastasProntas extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PastaDAO pastaDAO = new PastaDAO();
		
		try {
			
			List<pasta> pastasProntas = pastaDAO.listarPastasProntas();
			
			request.setAttribute("pastas-prontas", pastasProntas);
			RequestDispatcher rd = request.getRequestDispatcher("pastasProntas.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception  e){
			 e.printStackTrace();
		}
		
		
		
	}

}
