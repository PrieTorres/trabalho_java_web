package br.com.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.WallpaperNext.aplicacao.setWallpaper;
import br.com.WallpaperNext.model.foto;
import br.com.WallpaperNext.model.pasta;
import br.com.foto.dao.FotoDAO;
import br.com.pasta.dao.PastaDAO;

@WebServlet("/set-configurations")
public class configuration extends HttpServlet {
	static configDAO configDao = new configDAO();
	static setWallpaper setWall = new setWallpaper();
	static FotoDAO fotoDao = new FotoDAO();
	static int index_foto = 0;
	List<Integer> list_alowed = configDao.getLista_FK_alowed();
	
	/*public static void main(String[] args) {
		List<String> lista_de_url = new ArrayList<String>();
		List<Integer> list_alowed = (List<Integer>) configDao.getLista_FK_alowed();
		
		for(Integer i : list_alowed) {
			List<foto> lista = (List<foto>)fotoDao.listarFotos(i);
			for(foto f : lista) {
				lista_de_url.add(f.getLink());
			}
		}
		
		Timer timer = new Timer(); 
		TimerTask task = new TimerTask() {
			public void run()
			{
				System.out.println("lista --> "+lista_de_url+"lista allow "+list_alowed);
				if(lista_de_url.size() > 0) {
					if(lista_de_url.get(index_foto).length()>0) {
						setWall.setWithUrl(lista_de_url.get(index_foto));
						if(index_foto < lista_de_url.size()) {
							index_foto++;
						}else {
							index_foto = 0;
						}
					}
				}
			} 
		}; 
		timer.schedule(task, 0L, 1000L * 3L);
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//main(null);
		configDAO conf = (configDAO)req.getAttribute("config");
		List<Integer> listaa = (List<Integer>)req.getAttribute("list_allow");
		
		List<String> lista_de_url = new ArrayList<String>();
		
		if(conf != null) {
			list_alowed = (List<Integer>) conf.getLista_FK_alowed();
			System.out.println("lista ----------> "+list_alowed);
		}
		if(listaa != null) {
			list_alowed = (List<Integer>)listaa;
			System.out.println("lista ----------> "+list_alowed);
		}
		
		for(Integer i : list_alowed) {
			List<foto> lista = (List<foto>)fotoDao.listarFotos(i);
			for(foto f : lista) {
				lista_de_url.add(f.getLink());
			}
		}
		
		Timer timer = new Timer(); 
		TimerTask task = new TimerTask() {
			public void run()
			{
				System.out.println("lista --> "+lista_de_url+"lista allow "+list_alowed);
				if(lista_de_url.size() > 0) {
					if(lista_de_url.get(index_foto).length()>0) {
						setWall.setWithUrl(lista_de_url.get(index_foto));
						if(index_foto < lista_de_url.size()) {
							index_foto++;
						}else {
							index_foto = 0;
						}
					}
				}
			} 
		}; 
		
		timer.schedule(task, 0L, 1000L * 3L);
		req.setAttribute("configuration", configDao);
		RequestDispatcher rd = req.getRequestDispatcher("bem-vindo.html");
		rd.forward(req, resp);
	}

}
