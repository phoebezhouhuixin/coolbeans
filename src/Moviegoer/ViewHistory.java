package Moviegoer;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import fileDb.FileDb;
public class ViewHistory {
	String un,pw;
	Scanner sc8 = new Scanner(System.in);
	public void view(){
		System.out.println("Enter your username: ");
		un = sc8.nextLine();
		System.out.println("Enter your password: ");
		pw = sc8.nextLine();
		FileDb histDb = new FileDb();
		histDb.setDbName("history");
		ArrayList<Map<String, String>> histData = histDb.readDataBase("history");
		boolean auth = false;
		for (Map<String, String> user : histData) {
			if (user.get("username").equals(un) && user.get("password").equals(pw)) {
				auth = true;
				System.out.println("Movie: "+user.get("movie"));
				System.out.println("MovieType: "+user.get("movieType"));
				System.out.println("CinemaType: "+user.get("cinemaType"));
				System.out.println("Day: "+user.get("dayType"));
				System.out.println("Amount Paid: "+user.get("price"));
				System.out.println("Transaction Information: "+user.get("txnId"));
				
			}
		}
		if (auth == false) {
			System.out.println("Invalid username and/or password :( Try again");
		}
	}
}
