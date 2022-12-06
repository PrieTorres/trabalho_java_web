package br.com.config;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class configDAO {
	
	static private int timeToChange=15;
	static private List<Integer> lista_FK_alowed = new ArrayList<Integer>();
	
	public int getTimeToChange() {
		return timeToChange;
	}
	public void setTimeToChange(int timeToChange) {
		this.timeToChange = timeToChange;
	}
	public List getLista_FK_alowed() {
		return lista_FK_alowed;
	}
	public void setLista_FK_alowed(int fk) {
		this.lista_FK_alowed.add(fk);
	}
	public void remove_from_lidt_fk (int fk) {
		this.lista_FK_alowed.remove(this.lista_FK_alowed.indexOf(fk));
	}
	
	
	

}
