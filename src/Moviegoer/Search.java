package Moviegoer;
import General.Movie;
import java.util.ArrayList;

public class Search {
	public void display(ArrayList<Movie> allMovies){
		System.out.println("The movies featured in cineplex are: ");
		System.out.println("Movie Name"+"\t"+"Showing Status");
		for (Movie movie : allMovies) {
			System.out.println(movie.getTitle()+"/t"+movie.getShowingStatus());
		}
	}
}
