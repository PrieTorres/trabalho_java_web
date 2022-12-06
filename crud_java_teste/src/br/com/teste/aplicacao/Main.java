package br.com.teste.aplicacao;

import java.util.List;

import br.com.pasta.dao.PastaDAO;
import br.com.teste.model.pasta;

public class Main {
	
	public static void main(String[] args) {
		
		PastaDAO pastaDAO = new PastaDAO();
		
		/*pasta pasta = new pasta();
		pasta.setNome("teste");
		pasta.setCriador("user");
		pasta.setDescricao("descricao teste");*/
		
		//pastaDAO.save(pasta);
		//List<pasta> pastas = pastaDAO.listarPastasProntas();
		
		for(pasta p : pastaDAO.listarPastasProntas()) {
			System.out.println("pasta --> "+ p.getNome());
		}
		
		
	}
	
}
