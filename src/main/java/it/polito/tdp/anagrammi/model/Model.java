package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	AnagrammaDAO dao=new AnagrammaDAO();
	List<String> lista;
	
	public Model() {
		this.lista = new LinkedList<String>();
	}

	
	public List<String> anagrammi(String s) {
		lista.clear();
		anagrammi_ricorsiva("", 0, s);
		return lista;
	}

	public void anagrammi_ricorsiva(String parziale, int L, String rimanenti) {
		if(rimanenti.length()==0) {
			lista.add(parziale);
		} else {
			for(int i=0;i<rimanenti.length();i++) {
				String nuovo_parziale=parziale+rimanenti.charAt(i);
				String nuovo_rimanenti=rimanenti.substring(0,i)+rimanenti.substring(i+1);
				anagrammi_ricorsiva(nuovo_parziale, L+1, nuovo_rimanenti);
			}
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return dao.isCorrect(anagramma);
	}
}
