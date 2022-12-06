package com.webProject.objetos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.WallpaperNext.model.pasta;
import br.com.pasta.dao.PastaDAO;

@WebServlet("/criar-pasta")
public class criarPasta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PastaDAO pastaDAO = new PastaDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dentro do post");
		
		String nome_pasta = (String)request.getParameter("name");
		String descricao = (String)request.getParameter("descricao");
		String criador = (String)request.getParameter("criador");
		
		pasta novaPasta = new pasta();
		
		novaPasta.setCriador(criador);
		novaPasta.setDescricao(descricao);
		novaPasta.setNome(nome_pasta);
		
		try {	
			pastaDAO.save(novaPasta);
			request.setAttribute("pasta-criada", novaPasta);
			RequestDispatcher rd = request.getRequestDispatcher("suasPastas.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception  e){
			 e.printStackTrace();
		}
	}

}