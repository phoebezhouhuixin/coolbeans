package Moviegoer;
import General.Movie;

import java.util.ArrayList;
import java.util.Map;

import fileDb.FileDb;

public class Search {
	public void display(){
		FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
    	ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
		System.out.println("The movies featured in cineplex are: ");
		System.out.println("Movie Name"+"\t"+"Showing Status");
		for (Map<String, String> per_movie : movies) {
			System.out.println(per_movie.get("title")+"\t"+per_movie.get("status"));
		}
	}
}
