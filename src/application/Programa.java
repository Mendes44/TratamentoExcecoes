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
		
		if (!checkOut.after(checkIn)) {
			System.out.println("ERRO NA RESERVA! - CHECK-OUT INFERIOR A CHECK-IN");
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
			
			//Tratamento muito ruim de erro - Logica esta no programa principal.
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("ERRO NA RESERVA!!! --> DATA DA RESERVA TEM QUE SER DATAS FUTURAS! ");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("ERRO NA RESERVA! - CHECK-OUT INFERIOR A CHECK-IN");
			}
			else {
				//Responsavel por chamar o metodo de atualização das datas.
				reserva.updateDates(checkIn, checkOut);
				System.out.println("RESERVA: " + reserva);
			}
			
		}
		
		
		
		
		
		
		sc.close();

	}

}
