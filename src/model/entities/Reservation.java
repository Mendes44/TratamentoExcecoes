package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	//OPERAÇÃO PARA SABER A DURAÇÃO DE TEMPO - DADO DO TIPO LONG POIS E UM NUMERO INTEIRO MAIS LONGO ONDE
	//SERA NECESSARIO PARA CONSEGUIR FAZER A COMPARAÇÃO E CONVERSÃO DA DATA.
	public long duration() {
		//Para começar a calcular, vou usar o metodo mais natual da plataforma java, calcular em milisegundos
		//diff = variavel local (diferença)
		long diff = checkOut.getTime() - checkIn.getTime();
		//Para converter milisegundos para dias usarei o TimeUnit.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//Implementando a atualização de datas.
	public void updateDates (Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//Implementando o toString
	@Override
	public String toString() {
		return "Quarto: "
				+ roomNumber
				+ ", Check-in: "
				+ sdf.format(checkIn)
				+ " -- Check-out: "
				+ sdf.format(checkOut)
				+ " --> "
				+ duration()
				+ " Noites";
	}
	
}
