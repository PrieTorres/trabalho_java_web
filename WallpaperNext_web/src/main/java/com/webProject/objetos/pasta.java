package com.webProject.objetos;

import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/pastas")
public class pasta {
	
	Foto[] fotos = new Foto[100];
	pasta[] pasta_list = new pasta[100];
	public String nome;
	static public int quantidadePastas=0;
	public String descricao;
	public String criador; 
	
	public pasta(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadePastas++;
	}
	
	
	public pasta[] getPastas() {
		return pasta_list;
	}

}