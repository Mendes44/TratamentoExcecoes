package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int quarto = sc.nextInt();
		System.out.print("DATA DE CHECK-IN (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("DATA DE CHECK-OUT (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		//PERMANECE O TRATAMENTO DE EXCEÇÃO AQUI AINDA POIS ESSE PARA COLOCAR NA CLASSE RESERVATION, DEVERIA 
		//SER NO COLOCADO NO CONSTRUTOR E NO CONSTRUTOR NÃO POSSO COLOCAR PRA VOLTAR UM STRING.
		if (!checkOut.after(checkIn)) {
			System.out.println("ERRO NA RESERVA: CHECK-OUT INFERIOR A CHECK-IN");
		}
		else {
			Reservation reserva = new Reservation(quarto,checkIn,checkOut);
			System.out.println("RESERVA: " + reserva);
			
			System.out.println();
			System.out.println("Entre com dados de atualização da reserva: ");
			System.out.print("DATA DE CHECK-IN (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("DATA DE CHECK-OUT (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//Tratamento ruim de erro - Logica esta agora na classe reservation.
			String error = reserva.updateDates(checkIn, checkOut);
			
			if (error != null) {
				System.out.println("ERRO NA RESERVA: " + error);
			}
			else {				
				System.out.println("RESERVA: " + reserva);
			}
		}

		sc.close();

	}

}
