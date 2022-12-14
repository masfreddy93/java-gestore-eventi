package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {		
		
		System.out.println("START");
		
		System.out.println("------------");
		System.out.println("ProgrammaEventiUnici");
		
		ProgrammaEventiUnici peu = new ProgrammaEventiUnici("MyEvents");

		try {
			//prove varie stampate a schermo
			Evento e1 = new Evento("panino", 26, 12, 2022, 200);
			Evento e3 = new Evento("pinocchio", 28, 12, 2022, 100);
			Evento e4 = new Evento("topo gigio", 28, 12, 2022, 20);
			Evento e6 = new Evento("anacleto", 12, 12, 2028, 10);
			Evento e5 = new Evento("panino", 26, 12, 2022, 200);
			peu.addEvent(e5);
			peu.addEvent(e1);
			peu.addEvent(e3);
			peu.addEvent(e4);
			peu.addEvent(e6);
			
//			System.out.println(p.getEventi());
			
			System.out.println("\nLista di eventi in data '28-12-2022: \n" +peu.eventsInDate(LocalDate.of(2022, 12, 28)));
			
			System.out.println("\nNr. eventi presenti: " + peu.countEvents());
			
			System.out.println("\nLista non ordinata di eventi: \n" + peu.toString());
			
			System.out.println("Eventi EQUALS a 'panino-26.12.2022': " +peu.equals(e1));
			
//			System.out.println("\nRisultato test clear: " + peu.clearEvents());
//			System.out.println("Nr. eventi presenti dopo il clear: " + peu.countEvents());
			
			System.out.println("\n\n\nNUOVI METODI");
			System.out.println("\nEvento con maggior numero di posti totali: " + peu.getMaxPostiTotaliEvento());
			System.out.println("I posti sono: " + peu.getMaxPostiTotaliEvento().getNumeroPostiTot());
			System.out.println("\nEvento con minor numero di posti totali: " + peu.getMinPostiTotaliEvento());
			System.out.println("I posti sono: " + peu.getMinPostiTotaliEvento().getNumeroPostiTot());
			System.out.println("\n" + peu.orderedPrint());
			System.out.println("\nPrimo evento in ordine temporale: " + peu.getFirstEvent());
			System.out.println("\nUltimo evento in ordine temporale: " + peu.getLastEvent());
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("------------");
		System.out.println("ProgrammaEventi");
		
		ProgrammEventi p = new ProgrammEventi("MyEvents");

		try {
			//prove varie stampate a schermo
			Evento e1 = new Evento("panino", 26, 12, 2022, 200);
			Evento e3 = new Evento("pinocchio", 28, 12, 2022, 100);
			Evento e4 = new Evento("topo gigio", 28, 12, 2022, 20);
			Evento e6 = new Evento("anacleto", 12, 12, 2028, 10);
			Evento e5 = new Evento("panino", 26, 12, 2022, -5);
			p.addEvent(e5);
			p.addEvent(e1);
			p.addEvent(e3);
			p.addEvent(e4);
			p.addEvent(e6);
			
//			System.out.println(p.getEventi());
			
			System.out.println("\nLista di eventi in data '28-12-2022: \n" +p.eventsInDate(LocalDate.of(2022, 12, 28)));
			
			System.out.println("\nNr. eventi presenti: " + p.countEvents());
			
			System.out.println("\n" + p.sortByDate());
			
			System.out.println("Eventi EQUALS a 'panino-26.12.2022': " +p.equals(e1));
			
			p.clearEvents();
			System.out.println("\nNr. eventi presenti dopo il clear: " + p.countEvents());
			
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("------------");
		System.out.println("Concerto");
		
		Concerto c;
		try {
			
			c = new Concerto("Noyz", 28, 12, 2023, 200, 22, 30, new BigDecimal(3));
			System.out.println(c.toString());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println("------------");
		System.out.println("Evento");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire nome evento: ");
		String nome = sc.nextLine();
		System.out.print("Inserire giorno evento (dd): ");
		int giorno = sc.nextInt();
		System.out.print("Inserire mese evento (MM): ");
		int mese = sc.nextInt();
		System.out.print("Inserire anno evento (yyyy): ");
		int anno = sc.nextInt();
		System.out.print("Inserire numero posti totali: ");
		int numeroPostiTotali = sc.nextInt();
		
		Evento e2;
		
			
		try {
			e2  = new Evento(nome, giorno, mese, anno, numeroPostiTotali);
			
			System.out.println(e2.toString());
			
			
			sc.nextLine();	//per togliere iul bug del nextint()
			System.out.print("Vuoi effetturare una prenotazione? (y/n) ");
			String res = sc.nextLine().toLowerCase();
			if(res.equals("y")) {
				
				int check = 0;
				int num = 0;
				
				while(check == 0) {
					
					System.out.print("Quanti biglietti vuoi prenotare? ");
					String numStr = sc.nextLine();
					num = Integer.parseInt(numStr);
					
					if(num > 0) {
						
						for(int i = 0; i < num; i++) {
							
							e2.prenota();
						}
						
						check = 1;
						
					} else {
						
						System.err.println("Il numero inserito non ?? valido");
					}
					
				}
				
				
				
				System.out.println(e2.toString() 
						+ "\n\nNumeri posti prenotati: " + e2.getNumeroPostiPrenotati()
						+ "\nNumeri posti totali: " + e2.getNumeroPostiTot()
						);
				
			}				
			
			
			System.out.print("Vuoi disdire una prenotazione? (y/n) ");
			String res2 = sc.nextLine().toLowerCase();
			if(res2.equals("y")) {
				
				int check = 0;
				int num = 0;
				
				while(check == 0) {
					
					System.out.print("Quanti biglietti vuoi disdire? ");
					String numStr = sc.nextLine();
					num = Integer.parseInt(numStr);
					
					if(num > 0) {
						
						for(int i = 0; i < num; i++) {
							
							e2.disdici();
						}
						
						check = 1;
						
					} else {
						
						System.err.println("Il numero inserito non ?? valido");
					}
					
				}
				
				
				System.out.println(e2.toString() 
						+ "\n\nNumeri posti prenotati: " + e2.getNumeroPostiPrenotati()
						+ "\nNumeri posti totali: " + e2.getNumeroPostiTot()
						);
				
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		sc.close();
		
		
		System.out.println("------------");
		System.out.println("END");
	}
}
