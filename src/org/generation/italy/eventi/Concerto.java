package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private BigDecimal prezzo;
	
	
	public Concerto(String titolo, int d, int mo, int y, int numeroPostiTot, int h, int m, BigDecimal prezzo) throws Exception {
		
		super(titolo, d, mo, y, numeroPostiTot);
		
		setOra(h, m);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(int h, int m) throws Exception {
		
		if(h < 0 || h > 24 || m < 0 || m > 60) {
			
			throw new Exception("Valore non consentito (orario non valido)");
		}	
		
		LocalTime hour = LocalTime.of(h, m);
		this.ora = hour;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) throws Exception {
		
		if(prezzo.compareTo(new BigDecimal(0)) == -1) {
			
			throw new Exception("Valore non consentito (il prezzo deve essere maggiore o uguale a 0)");
		}
		
		this.prezzo = prezzo;
	}
	
	
	public LocalDateTime formatDateTime() {
		
		return LocalDateTime.of(getData(), getOra());
	}
	
	
	public String formatPrice() {
		
		DecimalFormat df = new DecimalFormat();
        
		df.setMaximumFractionDigits(2);          
		df.setMinimumFractionDigits(2);      
		df.setGroupingUsed(false);

		String result = df.format(getPrezzo());
		return result;
	}
	
	//formattazione data
	DateTimeFormatter formatter = DateTimeFormatter.
			ofPattern("dd.MM.yyyy HH:mm", Locale.ITALY).withZone(ZoneId.of("Europe/Rome"));

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return formatDateTime().format(formatter).toString().replace("T", " ")
				+ " - " + getTitolo() 
				+ " - " + formatPrice() + "€";
	}
	
}
