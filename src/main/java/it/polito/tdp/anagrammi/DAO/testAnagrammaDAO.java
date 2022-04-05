package it.polito.tdp.anagrammi.DAO;

public class testAnagrammaDAO {

	public static void main(String[] args) {
		AnagrammaDAO dao=new AnagrammaDAO();
		Boolean risultato = dao.isCorrect("prova");
		System.out.println(risultato);

	}
}
