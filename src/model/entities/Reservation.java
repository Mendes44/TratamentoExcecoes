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
	
	public long duration() {
		
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//AGORA A CLASSE VOLTA SER VOID. E INSTACIO A FUNÇÃO THROW NEW ILLEGALARGUMENTSEXCEPTION.
	public void updateDates (Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("DATA DA RESERVA TEM QUE SER DATAS FUTURAS! ");
		}
		if (!checkOut.after(checkIn)) {
			throw new IllegalArgumentException ("CHECK-OUT INFERIOR A CHECK-IN");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	
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
