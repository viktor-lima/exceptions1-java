package Model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNunber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer rooNunber, Date checkIn, Date checkOut) {
	
		this.roomNunber = rooNunber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRooNunber() {
		return roomNunber;
	}

	public void setRooNunber(Integer rooNunber) {
		this.roomNunber = rooNunber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	public long duration() {

		long diff = checkOut.getTime() - checkIn.getTime();
		//converter para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " 
				+ roomNunber  
				+", checkIn: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+" nights";
	}

	
	

	
	
}
