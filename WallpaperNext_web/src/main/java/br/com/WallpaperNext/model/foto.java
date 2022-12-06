package br.com.WallpaperNext.model;

public class foto {
	private String link;
	private int id;
	private String descricao;
	private int FK_pasta;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getFK_pasta() {
		return FK_pasta;
	}
	public void setFK_pasta(int fK_pasta) {
		FK_pasta = fK_pasta;
	}

}
