package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Room nunber: ");
		int nunber = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)){
			System.out.println("Error in reservetion:"
					+ "ckeck-out date must be after "
					+ "check-in date ");
		}
		else {
		Reservation reservation = new Reservation(nunber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("check-in date (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: reservation date"
						+ " must be future dates!");
			}
			else if(!checkOut.after(checkIn)){
				System.out.println("Error in reservetion:"
						+ "ckeck-out date must be after "
						+ "check-in date ");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();
	}
}
