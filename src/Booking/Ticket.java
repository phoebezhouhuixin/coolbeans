package Booking;
import Booking.Cineplex;

import java.util.Scanner;

public class Ticket {
	public String name, phNo, email;
	private Double[] typecinema;
	private Double[] typemovie;
	private Double[] typeage;
	private Double[] typeday;
	private Double ticketPrice;
	
	Cineplex c;

	Scanner sc = new Scanner(System.in);

	public Ticket(Cineplex c) {
		this.c=c;
		typecinema = new Double[] { 10.0, 12.0, 15.0 };
		typemovie = new Double[] { 4.0, 5.0, 6.0 };
		typeage = new Double[] { 2.0, 3.0, 4.0 };
		typeday = new Double[] { 4.0, 5.0, 6.0 };
		
		setTicketPriceAndInfo();
	}
	
	public Double getTicketPrice() {
		return this.ticketPrice;
	}
	
	public void setTicketPriceAndInfo() {
		Scanner sc = new Scanner(System.in);
		//get movie type
		int movietype_choice = 0;
		System.out.println("Which movie type:");
		System.out.println("1.2-D  2.3-D 3.Blockbuster ");
		movietype_choice = sc.nextInt()-1; //-1 for index
		//cinema choice
		String type = c.cinema.cinematype;
		int cinema_choice = 0;
		if(type.equals("Silver")) cinema_choice = 0;
		if(type.equals("Gold")) cinema_choice = 0;
		if(type.equals("Platinum")) cinema_choice = 0;
		
//		System.out.println("Which cinema type:");
//		System.out.println("1.Silver  2.Gold  3.Platinum ");
//		cinema_choice = sc.nextInt()-1;
		//age choice
		int age_choice = 0;
		System.out.println("Which age group:");
		System.out.println("1.Child 2.Senior 3.Student");
		age_choice = sc.nextInt()-1;
		//day choice
		int day_choice = 0;
		System.out.println("Which day:");
		System.out.println("1.Weekdays 2.Weekends 3.Holidays");
		day_choice = sc.nextInt()-1;
		
		sc.nextLine(); //clearing scanner's input buffer
		
		this.ticketPrice = typecinema[movietype_choice] + typemovie[cinema_choice] + typeage[age_choice] + typeday[day_choice];
		
		System.out.println("Enter name: ");
		this.name = sc.nextLine();
		System.out.println("Enter phone number: ");
		this.phNo = sc.next();
		System.out.println("Enter email:");
		this.email = sc.next();
		sc.close();
	}
}
