package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {
	
	private String titolo;
	private LocalDate data;  //da mettere local date
	private int numeroPostiTot;
	private int numeroPostiPrenotati;
	
	
	public Evento(String titolo, int d, int mo, int y, int numeroPostiTot) throws Exception {
		
		setTitolo(titolo);
		setData(d, mo, y);
		setNumeroPostiTot(numeroPostiTot);
		this.numeroPostiPrenotati = 0;
	}


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		
		if(titolo.length() < 2) {
			
			throw new Exception("Il nome deve contenere almeno 2 caratteri");
		}
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(int d, int mo, int y) throws Exception {
		
		if(d < 0 || d > 31 || mo < 0 || mo > 12 || y > 2030) {
			
			throw new Exception("Valore non consentito (data non valida)");
		}	
		
		LocalDate data = LocalDate.of(y, mo, d);
		
		
		if(LocalDate.now().isAfter(data)) {
			throw new Exception("La data inserita non è valida in quanto già passata");
		}
		
		this.data = data;
	}

	public int getNumeroPostiTot() {
		return numeroPostiTot;
	}
	
	private void setNumeroPostiTot(int numeroPostiTot) throws Exception {
		
		if(numeroPostiTot < 0) {
			
			throw new Exception("Il numero di posti deve essere maggiore di 0");
		}
		
		this.numeroPostiTot = numeroPostiTot;
	}

	public int getNumeroPostiPrenotati() {
		return numeroPostiPrenotati;
	}
	
	
	
	public int prenota() throws Exception {
		
		if(getNumeroPostiPrenotati() >= getNumeroPostiTot() || LocalDate.now().isAfter(data)) {
			
			throw new Exception("Impossibile inserire la quantità digitata");
		}
		
		return this.numeroPostiPrenotati += 1;
	}
	
	public int disdici() throws Exception {
		
		if(getNumeroPostiPrenotati() <= 0 || LocalDate.now().isAfter(data)) {
			
			throw new Exception("Impossibile disdire la quantità digitata");
		}
		
		return this.numeroPostiPrenotati -= 1;
	}
	
	
	@Override
	public String toString() {
		//formattazione data
		DateTimeFormatter formatter = DateTimeFormatter.
				ofPattern("dd.MM.yyyy",Locale.ITALY).withZone(ZoneId.of("Europe/Rome"));
		
		return getData().format(formatter) + " - " + getTitolo();
	}
	
	
}
