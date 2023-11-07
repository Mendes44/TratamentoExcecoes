package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int quarto = sc.nextInt();
			System.out.print("DATA DE CHECK-IN (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("DATA DE CHECK-OUT (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reserva = new Reservation(quarto,checkIn,checkOut);
			System.out.println("RESERVA: " + reserva);
			
			System.out.println();
			System.out.println("Entre com dados de atualização da reserva: ");
			System.out.print("DATA DE CHECK-IN (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("DATA DE CHECK-OUT (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
					
			reserva.updateDates(checkIn, checkOut);
			
			System.out.println("RESERVA: " + reserva);
		}	
		catch (ParseException error1) {
			System.out.println("FORMATO DA DATA INVALIDO!!!");
		}
		catch(DomainException erro2) {
			System.out.println("ERRO NA RESERVA: " + erro2.getMessage());
		}
		catch(RuntimeException erro3) {
			System.out.println("******** ERRO INESPERADO!!! ********");
		}

		sc.close();
		
		/*
		 * - AGORA TRATAMENTO DE EXCEÇÕES BOM E PERSONALIZADO.
		 * - RUNTIME = O COPILADOR NÃO OBRIGA A TRATAR.
		 * - PROGRAMAÇÃO DEFENSIVA - BOA PRATICA.
		 * - UPCASTING NA RUNTIMEEXCEPTION.
		 * - CODIGO LIMPO.
		 */
	}
}
