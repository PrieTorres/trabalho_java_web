package com.webProject.objetos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.WallpaperNext.model.foto;
import br.com.foto.dao.FotoDAO;

@WebServlet("/inserir-foto")
public class inserirFoto extends HttpServlet{

	private static final long serialVersionUID = 1L;
	FotoDAO FotoDAO = new FotoDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dentro do post");
		
		String link = (String)request.getParameter("link");
		String descricao = (String)request.getParameter("descricao");
		String FK_pasta = (String)request.getParameter("FK_pasta");
		String nome_pasta = (String)request.getParameter("nome_pasta");
		
		System.out.println("link: "+link+" desc: "+descricao+" FK: "+FK_pasta+" pasta: "+nome_pasta);
		
		int fk = Integer.parseInt(FK_pasta);
		
		foto novafoto = new foto();
		
		novafoto.setLink(link);
		novafoto.setDescricao(descricao);
		novafoto.setFK_pasta(fk);
		
		String url = "/fotos?FK_pasta="+fk+"&&nome-pasta="+nome_pasta;
		
		try {	
			FotoDAO.save(novafoto);
			request.setAttribute("foto-criada", novafoto);
			request.setAttribute("FK_pasta", FK_pasta);
			RequestDispatcher rd = request.getRequestDispatcher("pasta-user-aberta.jsp");
			rd.forward(request, response);
			
		}
		catch(Exception  e){
			 e.printStackTrace();
		}
	}

}
