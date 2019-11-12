package Moviegoer;
import java.util.ArrayList;
import java.util.Scanner;

import General.Movie;
import General.Review;

public class ViewDetails {
	public void displaydetails(ArrayList<Movie> allMovies){
		String input_title;
		int detail_choice=0;
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Enter the title of the movie whose details you wish to view: ");
		input_title = sc5.nextLine();
		for (int i =0; i < allMovies.size(); i+=1){
            if (allMovies.get(i).getTitle().equals(input_title)){
            	System.out.println("Enter your choice to view: ");
            	System.out.println("1. Director 2. Showing Status");
            	System.out.println("3. Synopsis 4. Cast");
            	System.out.println("5. Overall Review Ratings 6. Type of Movie");
            	System.out.println("7. Movie PG Rating 8. Exit");
            	detail_choice = sc5.nextInt();
            	while (detail_choice!=8){
	            	switch (detail_choice){
	            	case 1: 
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Director: "+allMovies.get(i).getDirector());
	            		break;
	            	case 2:
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Showing Status: "+allMovies.get(i).getShowingStatus());
	            		break;
	            	case 3:
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Synopsis: "+allMovies.get(i).getSynopsis());
	            		break;
	            	case 4:
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Cast: "+allMovies.get(i).getCast());
	            		break;
	            	case 5:
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Reviews: "+allMovies.get(i).getReviewArray());
	            		break;
	            	case 6:
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Type of movie: "+allMovies.get(i).getType());
	            		break;
	            	case 7:
	            		System.out.println("Movie: "+allMovies.get(i).getTitle());
	            		System.out.println("Movie PG Rating: "+allMovies.get(i).getPGrating());
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
