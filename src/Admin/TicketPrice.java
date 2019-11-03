package Admin;

import java.util.Scanner;

public class TicketPrice {
	private Double[] typecinema;
	private Double[] typemovie;
	private Double[] typeage;
	private Double[] typeday;
	private int user_choice;
	private double new_price1;
	private int cinema_choice = 0;
	private int ticketprice = 0;

	Scanner sc = new Scanner(System.in);

	public TicketPrice() {
		typecinema = new Double[] { 10.0, 12.0, 15.0 };
		typemovie = new Double[] { 4.0, 5.0, 6.0 };
		typeage = new Double[] { 2.0, 3.0, 4.0 };
		typeday = new Double[] { 4.0, 5.0, 6.0 };

	}

	public void tpmovietype() {
		double twod = 4.00, threed = 5.00, bb = 6.00;
		int movietype_choice = 0;
		System.out.println("Which movie type:");
		System.out.println("1.2-D  2.3-D 3.Blockbuster ");
		movietype_choice = sc.nextInt();
		switch (movietype_choice) {
		case 1:
			System.out.println("Current price is: "+twod+", Enter the 2D ticket price: ");
			twod = sc.nextDouble();
			break;

		case 2:
			System.out.println("Current price is: "+threed+", Enter the 3D ticket price: ");
			threed = sc.nextDouble();
			break;

		case 3:
			System.out.println("Current price is: "+bb+", Enter the blockbuster ticket price: ");
			bb = sc.nextDouble();
			break;
		}
		typemovie[0] = twod;
		typemovie[1] = threed;
		typemovie[2] = bb;
		for(Double x : typemovie) {
			System.out.print(x.toString()+" ");
		}
		System.out.println();
	}

	public void tpcinema() {
		double GoldExtra = 12.00, SilverExtra = 10.00, PlatinumExtra = 15.00;

		System.out.println("Which cinema type:");
		System.out.println("1.Silver  2.Gold  3.Platinum ");
		cinema_choice = sc.nextInt();
		switch (cinema_choice) {
		case 1:
			System.out.println("Current price is: "+SilverExtra+", Enter the silver extra ticket price: ");
			SilverExtra = sc.nextDouble();
			break;

		case 2:
			System.out.println("Current price is: "+GoldExtra+", Enter the gold extra ticket price: ");
			GoldExtra = sc.nextDouble();
			break;

		case 3:
			System.out.println("Current price is: "+PlatinumExtra+", Enter the platinum extra ticket price: ");
			PlatinumExtra = sc.nextDouble();
			break;
		}
		typecinema[0] = SilverExtra;
		typecinema[1] = GoldExtra;
		typecinema[2] = PlatinumExtra;
		for(Double x : typecinema) {
			System.out.print(x.toString()+" ");
		}
		System.out.println();
	}

	public void agecinema() {
		double student = 4.00, senior = 3.00, child = 2.00;

		System.out.println("Which age group:");
		System.out.println("1.Child 2.Senior 3.Student");
		cinema_choice = sc.nextInt();
		switch (cinema_choice) {
		case 1:
			System.out.println("Current price is: "+child+", Enter the Child price: ");
			student = sc.nextDouble();
			break;

		case 2:
			System.out.println("Current price is: "+senior+", Enter the Senior price: ");
			senior = sc.nextDouble();
			break;

		case 3:
			System.out.println("Current price is: "+student+", Enter the Student price: ");
			child = sc.nextDouble();
			break;
		}
		typeage[0] = child;
		typeage[1] = senior;
		typeage[2] = student;
		for(Double x : typeage) {
			System.out.print(x.toString()+" ");
		}
		System.out.println();
	}

	public void daycinema() {
		double weekdays = 4.00, weekends = 5.00, holidays = 6.00;

		System.out.println("Which day:");
		System.out.println("1.Weekdays 2.Weekends 3.Holidays");
		cinema_choice = sc.nextInt();
		switch (cinema_choice) {
		case 1:
			System.out.println("Current price is: "+weekdays+", Enter the Weekdays price: ");
			weekdays = sc.nextDouble();

		case 2:
			System.out.println("Current price is: "+weekends+", Enter the Weekends price: ");
			weekends = sc.nextDouble();

		case 3:
			System.out.println("Current price is: "+holidays+", Enter the Holidays price: ");
			holidays = sc.nextDouble();
		}
		typeday[0] = weekdays;
		typeday[1] = weekends;
		typeday[2] = holidays;
		for(Double x : typeday) {
			System.out.print(x.toString()+" ");
		}
		System.out.println();
	}
}
