package Booking;
import Booking.Cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cineplex {
	public String cineplexLocation;
	public Cinema cinema;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructor for Cineplex class
	 * @param cineplex name of cineplex
	 */
	public Cineplex(String cineplex) {
		this.cineplexLocation = cineplex;
		//chooseCinema();
	}

	/**
	 * setter for current cineplex
	 * @param cineplex
	 */
	public void setCineplex(String cineplex) {
		this.cineplexLocation = cineplex;
	}
	
	/**
	 * Getter for current cineplex type
	 * @return
	 */
	public String getCineplex() {
		return this.cineplexLocation;
	}
	
}
