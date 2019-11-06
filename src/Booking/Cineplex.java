package Booking;
import Booking.Cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cineplex {
	public String cineplexLocation;
	public Cinema cinema;
	Scanner sc = new Scanner(System.in);
	
	public Cineplex(String cineplex) {
		this.cineplexLocation = cineplex;
		chooseCinema();
	}
	
	public void setCineplex(String cineplex) {
		this.cineplexLocation = cineplex;
	}
	
	public String getCineplex() {
		return this.cineplexLocation;
	}
	public void chooseCinema() {
		String[] cinematypesKeys = new String[] {"Platinum", "Gold", "Silver"};
		Map<String,Double> cinematypes = new HashMap<>();
		cinematypes.put("Platinum", 15.0);
		cinematypes.put("Gold", 12.0);
		cinematypes.put("Silver", 10.0);
		System.out.println("Choose Cinema");
		for (Integer i=1; i<= cinematypes.size(); i+=1) {
			System.out.println(i.toString() + ") "+ cinematypesKeys[i-1]);
		}		
		int choice = sc.nextInt();
		// TODO : error message if incorrect choice
		this.cinema = new Cinema(cinematypesKeys[choice-1], cinematypes.get(cinematypesKeys[choice-1]));
		
	}
	
}
