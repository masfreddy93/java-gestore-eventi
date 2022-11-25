package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {

	
	/*
	 * Creare una classe ProgrammEventi con i seguenti attributi
	● titolo: String
	● eventi: List<Evento>
	Nel costruttore valorizzare il titolo, passato come parametro, e inizializzare la lista di eventi come una nuova ArrayList
	Aggiungere i seguenti metodi:
	● un metodo che aggiunge alla lista un Evento, passato come parametro
	● un metodo che restituisce una lista con tutti gli eventi presenti in una certa data
	● un metodo che restituisce quanti eventi sono presenti nel programma
	● un metodo che svuota la lista di eventi
	● un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli
	eventi ordinati per data nella forma:
	○ data1 - titolo1
	○ data2 - titolo2
	○ data3 - titolo3
	○...
	 */
	
	private String titolo;
	private List<Evento> eventi;
	
	
	public ProgrammEventi(String titolo) {
		
		setTitolo(titolo);
		setEventi(new ArrayList<>());
	}


	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	
	public void addEvent(Evento e) {
		
		this.eventi.add((Evento) e);
	}
	
//	public List<Evento> sortByDate(){
//		
//		
//	}
	
	public int countEvents() {
		
		return this.eventi.size();
	}
	
	public void clearEvents() {
		
		this.eventi.clear();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		ProgrammEventi p = new ProgrammEventi("titolone");
		System.out.println(p.getTitolo());
		Evento e1 = new Evento("panino", LocalDate.of(2022, 11, 26), 200);
		p.addEvent(e1);
		Evento e3 = new Evento("pinocchio", LocalDate.of(2023, 12, 28), 100);
		p.addEvent(e3);

		System.out.println(p.getEventi());
		
		System.out.println("n. eventi presenti: " + p.countEvents());
		
		p.clearEvents();
		System.out.println("n. eventi presenti: " + p.countEvents());
	}
	
}
