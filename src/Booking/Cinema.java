package Booking;

import java.util.Scanner;
import General.CinemaTypes;
import java.util.EnumMap;

public class Cinema {
	/**
	 * Keeps track of current cinema type
	 */
	public String cinematype;
	/**
	 * Keeps track of current cinema cost
	 */
	public Double cost;
	
	Scanner sc = new Scanner(System.in);
	/**
	 * Constructor which gets the particular cinema type from our CinemaType enum, and sets the cost for the particular cinema.
	 * @param cinema
	 * @param cinemaPriceMap
	 */
	public Cinema(CinemaTypes cinema, EnumMap<CinemaTypes,Double> cinemaPriceMap) {
		cinematype = cinema.getCinemaTypeName();
		this.cost = cinemaPriceMap.get(cinema);
	}
	
	/**
	 * Setter for current cinema type
	 * @param cinema
	 */
	public void setCinema(CinemaTypes cinema) {
		this.cinematype = cinema.getCinemaTypeName();
	}
	/**
	 * getter for current cinema type
	 * @return
	 */
	public String getCinemaType() {
		return cinematype;
	}
}
