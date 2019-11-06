package Booking;
import Booking.Cineplex;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Ticket {
	
	private Double[] cinema_prices;
	private Double[] movietype_prices;
	private Double[] age_prices;
	private Double[] day_prices;
	
	private String[] movietype_names = new String[] {"2D", "3D", "Blockbuster"};
	private String[] age_names = new String[] {"child", "senior", "student"};
	private String[] day_names = new String[] {"weekday", "weekend", "holiday"};
	
	public String name, phNo, email;
	public String cinemaType;
	public String movieType;
	public String ageType;
	public String dayType;
	public String transactionID;
	private Double ticketPrice;
	
	Cineplex c;

	Scanner sc = new Scanner(System.in);

	public Ticket(Cineplex c) {
		this.c=c;
		this.cinemaType = c.cinema.cinematype;
		cinema_prices = new Double[] { 10.0, 12.0, 15.0 };
		movietype_prices = new Double[] { 4.0, 5.0, 6.0 };
		age_prices = new Double[] { 2.0, 3.0, 4.0 };
		day_prices = new Double[] { 4.0, 5.0, 6.0 };
		
		setTicketPriceAndInfo();
		setTransactionId();
	}
	
	public Double getTicketPrice() {
		return this.ticketPrice;
	}
	
	public void setTicketPriceAndInfo() {
		//get movie type
		int movietype_choice = 0;
		System.out.println("Which movie type:");
		System.out.println("1.2-D  2.3-D 3.Blockbuster ");
		movietype_choice = sc.nextInt()-1; //-1 for index
		this.movieType = movietype_names[movietype_choice];
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
		this.ageType = age_names[age_choice];
		//day choice
		int day_choice = 0;
		System.out.println("Which day:");
		System.out.println("1.Weekdays 2.Weekends 3.Holidays");
		day_choice = sc.nextInt()-1;
		this.dayType = day_names[day_choice];
		
		sc.nextLine(); //clearing scanner's input buffer
		
		this.ticketPrice = cinema_prices[movietype_choice] + movietype_prices[cinema_choice] + age_prices[age_choice] + day_prices[day_choice];
		
		System.out.println("Enter name: ");
		this.name = sc.nextLine();
		System.out.println("Enter phone number: ");
		this.phNo = sc.next();
		System.out.println("Enter email:");
		this.email = sc.next();
	}
	
	public void setTransactionId() {
		String cinemaId = c.cineplexLocation.substring(0, 3); // using first 3 letters of cinema name as cinema ID
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");  
		LocalDateTime now = LocalDateTime.now();
		this.transactionID = cinemaId+dtf.format(now);		
	}
}
