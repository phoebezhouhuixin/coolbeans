package Moviegoer;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import fileDb.FileDb;
import General.Movie;
import General.Review;

public class ViewDetails {
	public void displaydetails(){
		FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
    	ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
		String input_title;
		int detail_choice=0;
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Enter the title of the movie whose details you wish to view: ");
		input_title = sc5.nextLine();
		for (Map<String, String> per_movie : movies) {
			if (per_movie.get("title").equals(input_title)) {
            	System.out.println("Enter your choice to view: ");
            	System.out.println("1. Director 2. Showing Status");
            	System.out.println("3. Synopsis 4. Cast");
            	System.out.println("5. Overall Review Ratings 6. Type of Movie");
            	System.out.println("7. Movie PG Rating 8. Reviews 9. Exit");
            	detail_choice = sc5.nextInt();
            	while (detail_choice!=9){
	            	switch (detail_choice){
	            	case 1: 
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Director: "+per_movie.get("director"));
	            		break;
	            	case 2:
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Showing Status: "+per_movie.get("status"));
	            		break;
	            	case 3:
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Synopsis: "+per_movie.get("synopsis"));
	            		break;
	            	case 4:
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Cast: "+per_movie.get("cast"));
	            		break;
	            	case 5:
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Overall Rating: "+per_movie.get("overallRating"));
	            		break;
	            	case 8:
	            		System.out.println("Movie: "+per_movie.get("title"));
//	            		System.out.println("Reviews: "+per_movie.get("review"));
	            		FileDb reviewDb = new FileDb();
	                    reviewDb.setDbName("reviews");
	            		ArrayList<Map<String, String>> reviewData = reviewDb.readDataBase("reviews");
	            		for (Map<String, String> per_review : reviewData) {
	            			if (per_review.get("title").equals(per_movie.get("title"))) {
	            				System.out.println(per_review);
	            			}
	            		}
	            		
	            		break;
	            	case 6:
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Type of movie: "+per_movie.get("type"));
	            		break;
	            	case 7:
	            		System.out.println("Movie: "+per_movie.get("title"));
	            		System.out.println("Movie PG Rating: "+per_movie.get("PGrating"));
	            		break;
	            	default:
	            		System.out.println("Invalid output");
            	
	            	}
	            System.out.println("Re-enter choice to continue: ");
	            detail_choice = sc5.nextInt();
            	
            	}
            }
		}
		sc5.close();
	}
	
}
