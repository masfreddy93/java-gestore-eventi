package org.generation.italy.eventi;

import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {		
		
		System.out.println("START");
		
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
		System.out.print("Inserire giorno evento: ");
		int giorno = sc.nextInt();
		System.out.print("Inserire mese evento: ");
		int mese = sc.nextInt();
		System.out.print("Inserire anno evento: ");
		int anno = sc.nextInt();
//		String[] dataStrArr = dataStr.split("-");
//		System.out.println(Arrays.toString(dataStrArr));
//		int[] dataIntArr = new int[3];
//		for(int i = 0; i < dataStrArr.length; i++) {
//			int el = Integer.parseInt(dataStrArr[i]);
//			dataIntArr[i] = el;
//		}
//		LocalDate data = LocalDate.of(dataIntArr[0], dataIntArr[1], dataIntArr[2]);
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
						
						System.err.println("Il numero inserito non è valido");
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
						
						System.err.println("Il numero inserito non è valido");
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
//		} finally {
//			
//			System.out.println("END");
//		}
		
		
		sc.close();
		System.out.println("END");
	}
}
