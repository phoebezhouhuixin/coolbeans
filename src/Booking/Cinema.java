package Booking;

import java.util.Scanner;

public class Cinema {
	public String cinematype;
	public Double cost;
	public String day;
	public String time;
	
	
	public Cinema(String cinema, double cost) {
		this.cinematype = cinema;
		this.cost = cost;
		getDayTime();
	}
	
	public void setCinema(String cinema) {
		this.cinematype = cinema;
	}
	
	public String getCinemaType() {
		return cinematype;
	}
	
	public void getDayTime() {
		System.out.print("Enter Day : ");
		Scanner sc = new Scanner(System.in);
		this.day = sc.next();
		System.out.println();
		
		System.out.print("Enter time : ");
		sc = new Scanner(System.in);
		this.time = sc.next();
		System.out.println();
	}
}
