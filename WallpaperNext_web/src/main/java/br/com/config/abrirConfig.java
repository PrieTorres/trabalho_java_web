package br.com.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.WallpaperNext.model.pasta;
import br.com.pasta.dao.PastaDAO;

@WebServlet("/abrir-ajustes")
public class abrirConfig extends HttpServlet {
	configDAO configDao = new configDAO(); 
	PastaDAO pastaDao = new PastaDAO();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			List<pasta> lista = pastaDao.listarTodasPastas();
			req.setAttribute("all-pastas", lista);
			RequestDispatcher rd = req.getRequestDispatcher("ajustes.jsp");
			rd.forward(req, resp);
			
		}
		catch(Exception  e){
			 e.printStackTrace();
		}
	}

}
