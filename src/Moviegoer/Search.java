package Moviegoer;
import General.Movie;

import java.util.ArrayList;
import java.util.Map;

import fileDb.FileDb;

public class Search {
	/**
	* Displays every movie from database and their respective title and showing status
	*/
	public void display(){
		FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
    	ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
		System.out.println("The movies featured in cineplex are: ");
		System.out.println(String.format("    %7s %20s", "Movie Name", "Showing Status"));
		Integer counter2 = 1;
		for (Map<String, String> per_movie : movies) {
			System.out.println(counter2.toString() + " : " + String.format("%7s %20s",per_movie.get("title"),per_movie.get("status")));
		}
	}
}
