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
	/**
	 * Displays the moviegoer's booking history of all their past movie ticket purchases
	 * @param un username to identify the user from booking history database
	 * @param pw password to validate the user from booking history database
	 */
	public void view(String un, String pw){
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
	/**
	 * Adds the Moviegoer's review: comment and rating for the movie of their choice
	 * @param movieTitle the movie that the MovieGoer wishes to review
	 */
	public void leaveReview(String movieTitle){
		String user_review;
		Integer user_rating;
		/*if (allMovies==null)
			System.out.println("No movies");
        for (Movie aMovie : allMovies){ // i.e. "for movie in the arraylist of all movies"
            if (aMovie.getTitle().equals(movieTitle)) {
            	System.out.println("Movie found");
                aMovie.getReviewArray().add(new Review());
                return;
            }
        }*/
		System.out.println("Enter your rating for the movie for an integer value between 0 to 5");
		user_rating = sc8.nextInt();
		sc8.nextLine();
		System.out.println("Enter your review for the movie under double quotes");
		user_review = sc8.nextLine();
		FileDb reviewDb = new FileDb();        
        reviewDb.setDbName("reviews");
        String [] reviewToAddToReviewDb = new String[] {movieTitle, user_rating.toString(), user_review };
		reviewDb.addRecord(reviewToAddToReviewDb);
		Movie m = new Movie(movieTitle);
		Double new_overall = m.getOverallRating();
		FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
		ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
		for (Map<String,String> movie : movies){
			if (movie.get("title").equals(movieTitle)){
				String[] currentRecord = new String[] {movie.get("title"),movie.get("synopsis"),movie.get("director"),movie.get("language"),movie.get("type"),movie.get("PGrating"),movie.get("status"), new_overall.toString(),movie.get("cast"),};
				movieDb.removeEntry("title", movieTitle);
                movieDb.addRecord(currentRecord);
			}
			
		}
    }
}
