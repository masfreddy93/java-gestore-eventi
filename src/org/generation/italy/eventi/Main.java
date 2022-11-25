package org.generation.italy.eventi;

import java.time.LocalDate;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("START");
		
		Evento e1;
//		LocalDate str = LocalDate.of(2022, 12, 12);
		
		try {
			e1  = new Evento("Pinocchio", LocalDate.of(2022, 11, 26), 3);
			e1.prenota();
			e1.prenota();
			e1.prenota();
			e1.disdici();
			e1.prenota();
			e1.disdici();
			e1.disdici();
			e1.disdici();
			
			System.out.println(e1.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END");
	}
}
