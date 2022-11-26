package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgrammaEventiUnici {

	public static class TitleComparator implements Comparator<Evento>{
		
		public int compare(Evento e1, Evento e2) {
			
			if(e1.getTitolo().length() > e2.getTitolo().length()) return -1;
			
			return 0;
		}
	}
	
	
	
	private String titolo;
	private Set<Evento> eventi;
	
	
	public ProgrammaEventiUnici(String titolo) {
		
		setTitolo(titolo);
		setEventi(new HashSet<>());
	}
	
	
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Set<Evento> getEventi() {
		return eventi;
	}
	
	public void setEventi(Set<Evento> eventi) {
		this.eventi = eventi;
	}
	
	
	//altri metodi
	
	public void addEvent(Evento e) {
		
		this.eventi.add(e);
	}
	
	public Set<Evento> eventsInDate(LocalDate thisDate){
		
		Set<Evento> res = new HashSet<>();
		for(Evento e: this.eventi) {
			
			if(e.getData().isEqual(thisDate)) {
				
				res.add(e);
			}
		}
		
		return res;
	}
	
	public Set<Evento> equals(Evento e){
		
		Set<Evento> equalsEvents = new HashSet<>();
		
		for(Evento event: this.eventi) {
			
			if(event.getData().equals(e.getData()) && event.getTitolo().equals(e.getTitolo()) && (event != e)) {
				
				equalsEvents.add(event);
			}
		}
		
		
		return equalsEvents;
	}
	
	public int countEvents() {
		
		return this.eventi.size();
	}
	
	public boolean clearEvents() {
		
		if(this.eventi.size() <= 0) return false;
		
		
		this.eventi.clear();
		return true;
	}
	
	
	//milestone3
	//`getMaxPostiTotaliEvento`: restituisce l'evento con il 
	//numero *massimo* di posti totali
	
	public Evento getMaxPostiTotaliEvento() throws Exception {
		
		Evento eMax = null;
		int iMax = Integer.MIN_VALUE;
		
		for(Evento e: this.eventi) {
			
			if(e.getNumeroPostiTot() > iMax) {

				iMax = e.getNumeroPostiTot();
				eMax = e;
			}
		}
		
		return eMax;
	}
	
	public Evento getMinPostiTotaliEvento() throws Exception {
		
		Evento eMin = null;
		int iMin = Integer.MAX_VALUE;
		
		for(Evento e: this.eventi) {
			
			if(e.getNumeroPostiTot() < iMin) {

				iMin = e.getNumeroPostiTot();
				eMin = e;
			}
		}
		
		return eMin;
	}
	
	
	//`orderedPrint`: stampa tutti gli eventi in ordine di 
	// lunghezza del titolo (titolo piu' lungo prima)
	
	public String orderedPrint(){
		
		ArrayList<Evento> ordList = new ArrayList<>(this.eventi);
		ordList.sort(new TitleComparator());
		String output = "Lista ordinata di eventi per lunghezza del nome \n";
		
		for(Evento e: ordList) {
			
			String toConcat = e.toString();
			output += "○ " + toConcat + "\n";
		}
		
		return output;
		
	}
	
	
	
	
	@Override
	public String toString() {
		
		String res = getTitolo() + "\n";
		
		for(Evento e : this.eventi) {
			
			String toConcat = e.toString();
			res += "○ " + toConcat + "\n";
		}
		
		
		return res;
	}
	
	
}
