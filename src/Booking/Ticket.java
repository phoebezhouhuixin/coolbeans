package Booking;
import Booking.Cineplex;
import General.AgeTypes;
import General.CinemaTypes;
import General.DayTypes;
import General.MovieTypes;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Ticket {
	
	/* all the following are taken from EnumMaps now, and hecne not used
	private Double[] cinema_prices;
	private Double[] movietype_prices;
	private Double[] age_prices;
	private Double[] day_prices;
	
	private String[] movietype_names = new String[] {"2D", "3D", "Blockbuster"};
	private String[] age_names = new String[] {"child", "senior", "student"};
	private String[] day_names = new String[] {"weekday", "weekend", "holiday"};
	*/
	public String name, phNo, email;
	public CinemaTypes cinemaType;
	public MovieTypes movieType;
	public AgeTypes ageType;
	public DayTypes dayType;
	public String transactionID;
	private Double ticketPrice;
	
	Cineplex c;

	Scanner sc = new Scanner(System.in);

	public Ticket(Map<String, String> selectedShow, EnumMap<CinemaTypes, Double> cinemaPriceMap, EnumMap<MovieTypes,
			Double> moviePriceMap, EnumMap<AgeTypes, Double> agePriceMap, EnumMap<DayTypes, Double> dayPriceMap){
		for (CinemaTypes cinemaType: CinemaTypes.values()){
			if (cinemaType.getCinemaTypeName().equals(selectedShow.get("cinemaType")))
				this.cinemaType = cinemaType;
		}
		for (MovieTypes movieType: MovieTypes.values()){
			if (movieType.getMovieTypeName().equals(selectedShow.get("movieType")))
				this.movieType = movieType;
		}
		for (DayTypes dayType: DayTypes.values()){
			if (dayType.getDayName().equals(selectedShow.get("dayType")))
				this.dayType = dayType;
		}

		c = new Cineplex(selectedShow.get("cineplex"));
		ageType = getAgeType();

		ticketPrice = cinemaPriceMap.get(cinemaType) + moviePriceMap.get(movieType) - agePriceMap.get(ageType);

		sc.nextLine(); //clearing scanner's input buffer

		System.out.println("Enter name: ");
		this.name = sc.nextLine();
		System.out.println("Enter phone number: ");
		this.phNo = sc.next();
		System.out.println("Enter email:");
		this.email = sc.next();

		setTransactionId(c);

	}
	
	public Double getTicketPrice() {
		return this.ticketPrice;
	}
	
	public AgeTypes getAgeType() {

		//age choice
		int age_choice = 0;
		System.out.println("Which age group:");
		System.out.println("1.Child 2.Senior 3.Student 4.Adult");
		age_choice = sc.nextInt();
		if (age_choice == 1) return AgeTypes.CHILD;
		else if (age_choice == 2) return AgeTypes.SENIOR;
		else if (age_choice == 3) return AgeTypes.STUDENT;
		else return AgeTypes.ADULT;
	}
	public void setTransactionId(Cineplex c) {
		String cinemaId = c.cineplexLocation.substring(0, 3); // using first 3 letters of cinema name as cinema ID
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");  
		LocalDateTime now = LocalDateTime.now();
		this.transactionID = cinemaId+dtf.format(now);		
	}
}
