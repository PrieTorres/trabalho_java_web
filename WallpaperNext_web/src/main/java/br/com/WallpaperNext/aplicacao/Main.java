package br.com.WallpaperNext.aplicacao;

import java.util.List;

import br.com.WallpaperNext.model.foto;
import br.com.WallpaperNext.model.pasta;
import br.com.foto.dao.FotoDAO;
import br.com.pasta.dao.PastaDAO;

public class Main {
	
	public static void main(String[] args) {
		
		PastaDAO pastaDAO = new PastaDAO();
		FotoDAO fotoDAO = new FotoDAO();
		
		/*pasta pasta = new pasta();
		pasta.setNome("teste");
		pasta.setCriador("user");
		pasta.setDescricao("descricao teste");*/
		
		//pastaDAO.save(pasta);
		//List<pasta> pastas = pastaDAO.listarPastasProntas();
		
		//for(pasta p : pastaDAO.listarPastasProntas()) {
		//	System.out.println("pasta --> "+ p.getNome());
		//}
		
		/*for(foto f : fotoDAO.listarFotos(1)) {
			System.out.println("pasta --> "+ f.getLink());
		}*/
		
		
	}
	
}
