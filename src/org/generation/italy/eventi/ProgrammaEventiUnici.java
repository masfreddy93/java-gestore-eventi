package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgrammaEventiUnici {

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
	
	public boolean clearEvents() {
		
		if(this.eventi.size() <= 0) return false;
		
		
		this.eventi.clear();
		return true;
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
