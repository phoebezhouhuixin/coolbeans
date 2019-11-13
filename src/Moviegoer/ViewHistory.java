package Moviegoer;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import General.Movie;
import General.Review;
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
	public void leaveReview(String movieTitle, ArrayList<Movie> allMovies){
		if (allMovies==null)
			System.out.println("No movies");
        for (Movie aMovie : allMovies){ // i.e. "for movie in the arraylist of all movies"
            if (aMovie.getTitle().equals(movieTitle)) {
            	System.out.println("Movie found");
                aMovie.getReviewArray().add(new Review());
                return;
            }
        }
    }
}
