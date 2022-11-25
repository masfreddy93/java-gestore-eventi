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
	
	
	public Evento(String titolo, LocalDate data, int numeroPostiTot) throws Exception {
		
		setTitolo(titolo);
		setData(data);
		setNumeroPostiTot(numeroPostiTot);
		this.numeroPostiPrenotati = 0;
	}


	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		
		LocalDate oggi = LocalDate.now();
		if(oggi.isAfter(data)) {
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
			
			throw new Exception("Posti terminati");
		}
		
		return this.numeroPostiPrenotati += 1;
	}
	
	public int disdici() throws Exception {
		
		if(getNumeroPostiPrenotati() <= 0 || LocalDate.now().isAfter(data)) {
			
			throw new Exception("Non sono presenti prenotazioni");
		}
		
		return this.numeroPostiPrenotati -= 1;
	}
	
	//formattazione data
	DateTimeFormatter formatter = DateTimeFormatter.
            ofPattern("dd.MM.yyyy",Locale.ITALY).withZone(ZoneId.of("Europe/Rome"));
	
	@Override
	public String toString() {
		
		return getData().format(formatter) + " - " + getTitolo()
				+ "\n\n   Roba mia: "
				+ "\n   Data: " + getData()
				+ "\n   Posti totali: " + getNumeroPostiTot()
				+ "\n   Posti prenotati: " + getNumeroPostiPrenotati();
	}
	
	
}
