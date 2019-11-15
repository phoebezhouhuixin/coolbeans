package Booking;

import java.util.Scanner;
import General.CinemaTypes;
import java.util.EnumMap;

public class Cinema {
	public String cinematype;
	public Double cost;
	
	Scanner sc = new Scanner(System.in);
	
	public Cinema(CinemaTypes cinema, EnumMap<CinemaTypes,Double> cinemaPriceMap) {
		cinematype = cinema.getCinemaTypeName();
		this.cost = cinemaPriceMap.get(cinema);
	}
	
	public void setCinema(CinemaTypes cinema) {
		this.cinematype = cinema.getCinemaTypeName();
	}
	
	public String getCinemaType() {
		return cinematype;
	}
}
