package com.webProject.objetos;

import java.io.IOException;

import br.com.WallpaperNext.model.foto;
import br.com.WallpaperNext.model.pasta;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.foto.dao.FotoDAO;

@WebServlet("/fotos-user")
public class carregarFotosUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FotoDAO fotoDAO = new FotoDAO();
		String FK_pasta = req.getParameter("FK_pasta");
		String nome_pasta = req.getParameter("nome-pasta");
		int fk = Integer.parseInt(FK_pasta);
		
		System.out.println("fk: "+FK_pasta+" nome: "+nome_pasta);
		
		try {
			List<foto> listaFotos = fotoDAO.listarFotos(fk);
			
			req.setAttribute("fotos", listaFotos);
			req.setAttribute("nome-pasta", nome_pasta);
			req.setAttribute("FK_pasta", FK_pasta);
			RequestDispatcher rd = req.getRequestDispatcher("pasta-user-aberta.jsp");
			rd.forward(req, resp);
			
		}
		catch(Exception  e){
			 e.printStackTrace();
		}
	}

}
