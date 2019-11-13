package Booking;
import General.Movie;
import Moviegoer.Search;
import Moviegoer.ViewDetails;

import java.util.ArrayList;
import java.util.Scanner; 
// hello
public class ChooseMovie {
	public String selected_movie = null;
	Scanner sc7 = new Scanner(System.in);
	public void choice(ArrayList<Movie> allMovies){
		int choice1=0;		
		
		System.out.println("Do you wish to: 1.Search for movie 2.View movie details 3.Choose movie to book 4.Continue ");
		choice1 = sc7.nextInt();
		sc7.nextLine();
		while (choice1!=4){
			switch(choice1){
			case 1:
				// TODO : this doesn't do anything!
				Search s1 = new Search();
				s1.display();
				break;
			case 2:
				// TODO : this doesn't do anything!
				ViewDetails v1 = new ViewDetails();
				v1.displaydetails();
				break;
			case 3:
				System.out.println("Please enter the name of the movie you wish to watch: ");
				selected_movie = sc7.nextLine();
				System.out.println("The movie you have chosen is: "+selected_movie);
				break;
			}
			System.out.println("Do you wish to: 1.Search for movie 2.View movie details 3.Choose movie to book 4.Continue ");
			choice1 = sc7.nextInt();
			sc7.nextLine();
		}
//		while (sc7.hasNextLine()) {
//			sc7.nextLine();
//		}
	}
}

