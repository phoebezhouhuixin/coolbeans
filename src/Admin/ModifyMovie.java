package Admin;
import java.util.*;

import General.*;
import fileDb.FileDb;

import java.text.ParseException;
import java.util.Map.Entry;

public class ModifyMovie { 
    int numberOfMovies = 0;
    Scanner sc2 = new Scanner(System.in);
    ArrayList<Movie> allMovies;
    
    public ModifyMovie(ArrayList<Movie> allMovies) {
    	this.allMovies = allMovies;
    }

    /**
     * Creates a new movie (to be done by the staff).
     * @param allMovies stores the new movie that was just created.
     */
    public void createMovie(ArrayList<Movie> allMovies){
        System.out.println("Enter movie title: ");
        String theTitle = sc2.nextLine();
        Movie newMovie = new Movie(theTitle);
        newMovie.setSynopsis();
        newMovie.setDirector();
        newMovie.setRuntime();
        newMovie.setLanguage();
        newMovie.setType();
        newMovie.setPGrating();
        


        System.out.println("Enter movie showing status: ");
        System.out.println("1: Coming soon");
        System.out.println("2: Preview");
        System.out.println("3: Now Showing");
        System.out.println("4: End of showing");
        int theStatus = sc2.nextInt();
        sc2.nextLine();
        newMovie.setShowingStatus(theStatus);


        System.out.println("Enter movie cast names one by one, and 0 to stop: ");
        String theName;
        ArrayList<String> theNames = new ArrayList<String>();
        do {
            theName = sc2.nextLine();
            if (theName.equals("0")==false)
                theNames.add(theName);
            else break;
        } while (theName.equals("0")==false);
        
        newMovie.setCast(theNames);
        addNewMovieToArray(newMovie,allMovies);
        this.allMovies = allMovies;
    }
    /**
     * Adds New movie to the global reference of all movies.
     * @param newMovie The movie that is added to allMovies
     * @param allMovies stores all the current movies, previously loaded from a database.
     */
    public void addNewMovieToArray(Movie newMovie , ArrayList<Movie> allMovies){
        this.numberOfMovies+=1;
        allMovies.add(newMovie);
        String cast = "";
        for (String castMember : newMovie.getCast()) {
        	cast += (castMember+";");
        }

        FileDb movieDb = new FileDb();        
        movieDb.setDbName("movies");
        String [] recordToAddToMovieDb = new String[] {newMovie.getTitle(), newMovie.getSynopsis(), newMovie.getDirector(), newMovie.getLanguage(), newMovie.getType().getMovieTypeName(), newMovie.getPGrating(),newMovie.getShowingStatus().toString(), newMovie.getOverallRating().toString(), cast };
        movieDb.addRecord(recordToAddToMovieDb);
        this.allMovies = allMovies;
    }
    
    /**
     * Updates an existing movie, both in the allMovie global reference and in the database.
     * @param check_by_title the title of the movie that needs to be changed
     * @param allMovies stores all the current movies, previously loaded from a database.
     */
    public void updateExistingMovieInArray(String check_by_title, ArrayList<Movie> allMovies){
    	FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
    	ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
    	System.out.println(movies.toString());
        int update_choice=0;
        
        for (Map<String,String> movie : movies){
        	String[] currentRecord = new String[] {movie.get("title"),movie.get("synopsis"),movie.get("director"),movie.get("language"),movie.get("type"),movie.get("PGrating"),movie.get("status"), movie.get("overallRating"),movie.get("cast"),};
        	
            if (movie.get("title").equals(check_by_title)) {
                System.out.println("What do you wish to change: 1.Title 2.Director 3.Synopsis 4.Showing Status 5.Language 6.Type 7. PGRating 8.Exit");
                update_choice = sc2.nextInt();
                sc2.nextLine();
                while (update_choice != 8){
                    switch (update_choice) {
                        case 1:
                        	Movie temp = new Movie("temp");
                            temp.setTitle();
                            currentRecord[0] = temp.getTitle();
                            System.out.println("Successfully updated! ");
                            break;
                        case 2:
                        	Movie temp2 = new Movie("temp");
                            temp2.setDirector();
                            currentRecord[2] = temp2.getDirector();
                            System.out.println("Successfully updated!");
                            break;
                        case 3:
                        	Movie temp3 = new Movie("temp");
                            temp3.setSynopsis();
                            currentRecord[1] = temp3.getSynopsis();
                            System.out.println("Successfully updated!");
                            break;
                        case 4:
                            System.out.println("Enter movie showing status: ");
                            System.out.println("1: Coming soon");
                            System.out.println("2: Preview");
                            System.out.println("3: Now Showing");
                            System.out.println("4: End of showing");
                            Integer theStatus = sc2.nextInt();
                            sc2.nextLine();
                            currentRecord[6] = StatusEnum.values()[theStatus-1].toString();
                            System.out.println("Successfully updated!");
                            break;
                        case 5:
                        	Movie temp4 = new Movie("temp");
                            temp4.setLanguage();
                            currentRecord[3] = temp4.getLanguage();
//                            allMovies.get(i).setLanguage();
                            System.out.println("Successfully updated!");
                            break;
                        case 6:
                        	Movie temp5 = new Movie("temp");
                            temp5.setType();
                            currentRecord[4] = temp5.getType().getMovieTypeName();
//                        	allMovies.get(i).setType();
                            System.out.println("Successfully updated!");
                            break;
                        case 7:
                        	Movie temp6 = new Movie("temp");
                            temp6.setPGrating();
                            currentRecord[5] = temp6.getPGrating();
//                        	allMovies.get(i).setPGrating();;
                            System.out.println("Successfully updated!");
                            break;
                        default:
                            System.out.println("Invalid choice. Choose between 1 to 5.");
                    }
                    System.out.println("What do you wish to change: 1.Title 2.Director 3.Synopsis 4.Showing Status 5.Language 6.Type 7. PGRating 8.Exit");
                    update_choice = sc2.nextInt();
                    sc2.nextLine();
                }
                movieDb.removeEntry("title", check_by_title);
                movieDb.addRecord(currentRecord);
            }

        }
        this.allMovies = allMovies;
    }
    
    /**
     * Getter for the allmovies reference.
     * @return
     */
    public ArrayList<Movie> getAllMovies(){
    	return this.allMovies;
    }
    
    /**
     * removes a movie from allMovies and the database
     * @param check_by_title title of the movie to be removed.
     * @param allMovies stores all the current movies, previously loaded from a database.
     */
    public void removeMovieInArray(String check_by_title, ArrayList<Movie> allMovies) {
    	String temp_cast=null;
    	FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
    	ArrayList<Map<String, String>> moviesData = movieDb.readDataBase("movies");
    	check_by_title = check_by_title.strip();
    	System.out.println("Title is =>"+check_by_title);
    	
    	for (Map<String,String> movie: moviesData) {
    		if (check_by_title.equals(movie.get("title"))){
    			temp_cast = movie.get("cast");
    		}
    	}
    	
        for (int i = 0; i < allMovies.size(); i += 1) {
        	System.out.println(allMovies.get(i).getTitle() + "-"+check_by_title);
            if (allMovies.get(i).getTitle().equals(check_by_title)) {
                Movie newMovie = allMovies.get(i);
                String [] recordToAddToMovieDb = new String[] {newMovie.getTitle(), newMovie.getSynopsis(), newMovie.getDirector(), newMovie.getLanguage(), newMovie.getType().getMovieTypeName(), newMovie.getPGrating(),StatusEnum.END_SHOWING.toString(), newMovie.getOverallRating().toString(), temp_cast };
                movieDb.removeEntry("title", check_by_title);
                movieDb.addRecord(recordToAddToMovieDb);
            	allMovies.get(i).setShowingStatus(4);        
        
            }
        }
        this.allMovies = allMovies;
    }

    /**
     * Prompts and displays movies by desired ranking scheme.
     * @param allMovies
     */
    public void displayMovieRanking(ArrayList<Movie> allMovies){
//    	Scanner sc2 = new Scanner(System.in);
        int display_choice = 0;
        System.out.println("Enter ranking criteria: 1.Ticket Sales 2.Review Ratings ");
        display_choice = sc2.nextInt();
        sc2.nextLine();
        FileDb movieDb = new FileDb();
    	movieDb.setDbName("movies");
    	ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
    	/*FileDb salesDb = new FileDb();
    	salesDb.setDbName("sales");
    	ArrayList<Map<String, String>> sales = salesDb.readDataBase("sales");*/
        switch(display_choice){
            case 1:
            	int check1=1;
            	Movie obj = new Movie("temp");
                Map <Double, String> map1 = new HashMap<Double, String>();
            	for (Map<String,String> movie : movies){
                    obj.calcTicketSales(movie.get("title"));
                }
            	FileDb sales_refreshedDb = new FileDb();
            	sales_refreshedDb.setDbName("sales");
            	ArrayList<Map<String, String>> sales_new = sales_refreshedDb.readDataBase("sales");
            	for(int i=0; i<sales_new.size(); i++){
            		for(int j=0; j<sales_new.size()-1; j++){
            			Map<String, String> currentSale = sales_new.get(j);
            			Map<String, String> nextSale = sales_new.get(j+1);
            			if (Double.parseDouble(currentSale.get("sales")) < Double.parseDouble(nextSale.get("sales"))){
            				Collections.swap(sales_new, j, j+1);
            			}
            		}
            	}
            	for (Map<String, String> per_sale : sales_new){
            		System.out.println(per_sale);
                }
            	break;
            case 2:
            	int check2=1;
                Map <Double, String> map2 = new HashMap<Double, String>();
                for(int i=0; i<movies.size(); i++){
            		for(int j=0; j<movies.size()-1; j++){
            			Map<String, String> currentRating = movies.get(j);
            			Map<String, String> nextRating = movies.get(j+1);
            			if (Double.parseDouble(currentRating.get("overallRating")) < Double.parseDouble(nextRating.get("overallRating"))){
            				Collections.swap(movies, j, j+1);
            			}
            		}
            	}
            	for (Map<String, String> per_movie : movies){
            		System.out.println(per_movie.get("title")+"==>"+per_movie.get("overallRating"));
//                    map1.put(Double.parseDouble(per_sale.get("sales")),per_sale.get("title"));
                }
                break;
        }
        this.allMovies = allMovies;
    }
    
    public void createShowtimes() {
    	System.out.println("Enter movie title: ");
        String theTitle = sc2.nextLine();
        System.out.println("Enter cineplex name: ");
        String cineplexName = sc2.nextLine();
        System.out.println("Enter movie type 1.2D 2.3D 3.Blockbuster: ");
        String type_of_movie = sc2.nextLine();
        System.out.println("Enter cinema type 1.Silver 2.Gold 3.Platinum: ");
        String type_of_cinema = sc2.nextLine();
        System.out.println("Enter day when movie is played: ");
        String day_of_showing = sc2.nextLine();
        System.out.println("Enter time when movie is played: ");
        String time_of_showing = sc2.nextLine();
        System.out.println("Enter day type 1.Weekday 2.Weekend 3.Holiday: ");
        String day_type = sc2.nextLine();
        FileDb showtimeDb = new FileDb();
        showtimeDb.setDbName("showtimes");
        String[] recordToAddToShowtimesDb = new String[] {theTitle, cineplexName, type_of_movie, type_of_cinema, day_of_showing, time_of_showing, day_type};
        showtimeDb.addRecord(recordToAddToShowtimesDb);
        System.out.println("New showtime successfully created!");
        sc2.nextLine();
    }
    
    public void updateShowtimes() {
    	FileDb showtimes = new FileDb();
    	showtimes.setDbName("showtimes");
		ArrayList<Map<String, String>> showtimesData = showtimes.readDataBase("showtimes");
		for (Integer i = 0; i<showtimesData.size(); i+=1) {
			Map<String, String> current = showtimesData.get(i);
			System.out.println(i.toString() + " : " + current );
		}
		System.out.println("Enter row you would like to modify: ");
		int choice = sc2.nextInt();
		sc2.nextLine();
		Map<String, String> toModify = showtimesData.get(choice);
		//TODO : get user input for these
		System.out.println("Enter attribute you would like to modify: ");
		String colName = sc2.nextLine();
		System.out.println("Enter new value of attribute: ");
		String changeTo = sc2.nextLine();
//		String colName = "dayType";
//		String changeTo = "PublicHoliday";
		
		toModify.remove(colName);
		toModify.put(colName, changeTo);
		String [] recToAdd = new String[] {toModify.get("movieTitle"),toModify.get("cineplex"),toModify.get("movieType"),toModify.get("cinemaType"),toModify.get("day"),toModify.get("time"),toModify.get("dayType"),};
		
		showtimes.removeEntryByIndex(choice+1); //+1 because it's not counting col names row
		showtimes.addRecord(recToAdd);
		System.out.println("Updated!");
    }
    public void removeShowtimes() {
    	FileDb showtimes = new FileDb();
    	showtimes.setDbName("showtimes");
		ArrayList<Map<String, String>> showtimesData = showtimes.readDataBase("showtimes");
		for (Integer i = 0; i<showtimesData.size(); i+=1) {
			Map<String, String> current = showtimesData.get(i);
			System.out.println(i.toString() + " : " + current );
		}
		System.out.println("Enter row you would like to remove: ");
		int choice = sc2.nextInt();
		sc2.nextLine();
		showtimes.removeEntryByIndex(choice+1); //+1 because it's not counting col names row
		System.out.println("Removed!");
    }
}