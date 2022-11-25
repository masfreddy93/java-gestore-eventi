package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {

	public static class DateComparator implements Comparator<Evento>{
		
		public int compare(Evento e1, Evento e2) {
			
			if(e1.getData().isBefore(e2.getData())) return -1;
			
			return 0;
		}
	}
	
	
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
		
//		String titolo = e.getTitolo();
//		LocalDate data = e.getData();           //questi sono per i controlli
//		int capienza = e.getNumeroPostiTot();
//		int prenotazioni = e.getNumeroPostiPrenotati();
		
		this.eventi.add((Evento) e);
	}
	
	
	public List<Evento> eventsInDate(LocalDate thisDate){
		
		List<Evento> eventsSameDate = new ArrayList<>();
		for(int i = 0; i < this.eventi.size(); i++) {
			
			if(this.eventi.get(i).getData().isEqual(thisDate)) {
				
				eventsSameDate.add(this.eventi.get(i));
			}
		}
		
		return eventsSameDate;
	}
	
	public int countEvents() {
		
		return this.eventi.size();
	}
	
	public void clearEvents() {
		
		this.eventi.clear();
	}
	

	
	public String sortByDate() {
		
		this.eventi.sort(new DateComparator());
		String output = this.titolo + "\n";
		
		for(int i = 0; i < this.eventi.size(); i++) {
			
			String toConcat = this.eventi.get(i).toString();
			output += "○ " + toConcat + "\n";
		}
		
		
		return output;
	}
	

	public static void main(String[] args) throws Exception {
		
		ProgrammEventi p = new ProgrammEventi("titolone");
//		System.out.println(p.getTitolo());
		Evento e1 = new Evento("panino", LocalDate.of(2022, 11, 26), 200);
		p.addEvent(e1);
		Evento e3 = new Evento("pinocchio", LocalDate.of(2023, 12, 28), 100);
		p.addEvent(e3);
		Evento e4 = new Evento("topo gigio", LocalDate.of(2023, 12, 28), 20);
		p.addEvent(e4);
		Evento e6 = new Evento("anacleto", LocalDate.of(2028, 11, 12), 10);
		p.addEvent(e6);
		Evento e5 = new Evento("bombis", LocalDate.of(2022, 11, 26), 10);
		p.addEvent(e5);
		
		System.out.println(p.getEventi());
		
		
		System.out.println("\nLista di eventi in data '28-12-2023: " +p.eventsInDate(LocalDate.of(2023, 12, 28)));
		
		
		System.out.println("\nn. eventi presenti: " + p.countEvents());
	
//		p.getEventi().sort(new DateComparator());
//		System.out.println("\nEventi in ordine di data: " + p.getEventi());
		
		System.out.println("\n" + p.sortByDate());
		
		p.clearEvents();
		System.out.println("\nn. eventi presenti dopo il clear: " + p.countEvents());

		
	}
	
}
