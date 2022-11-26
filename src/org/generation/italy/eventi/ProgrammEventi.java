package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public List<Evento> equals(Evento e){
		
		List<Evento> equalsEvents = new ArrayList<>();
		
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
}
