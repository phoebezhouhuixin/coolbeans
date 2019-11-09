package Admin;
import java.util.*;

import General.*;
import fileDb.FileDb;

public class ModifyMovie { // call the setters of General.Movie.java
    int numberOfMovies = 0;
//    Scanner sc2 = new Scanner(System.in);
    ArrayList<Movie> allMovies;
    public void createMovie(ArrayList<Movie> allMovies){
    	Scanner sc2 = new Scanner(System.in);
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
        System.out.println("3: Now showing");
        System.out.println("4: End of showing");
        int theStatus = sc2.nextInt();
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
        sc2.close();
    }
    public void addNewMovieToArray(Movie newMovie , ArrayList<Movie> allMovies){
        this.numberOfMovies+=1;
        allMovies.add(newMovie);
        String cast = "";
        for (String castMember : newMovie.getCast()) {
        	cast += (castMember+";");
        }

        FileDb movieDb = new FileDb();        
        movieDb.setDbName("movies");
        String [] recordToAddToMovieDb = new String[] {newMovie.getTitle(), newMovie.getSynopsis(), newMovie.getDirector(), newMovie.getLanguage(), newMovie.getType(), newMovie.getPGrating(), newMovie.getOverallRating().toString(), cast };
        movieDb.addRecord(recordToAddToMovieDb);
        this.allMovies = allMovies;
    }
    public void updateExistingMovieInArray(String check_by_title, ArrayList<Movie> allMovies){
    	Scanner sc2 = new Scanner(System.in);
        int update_choice=0;
        for (int i =0; i < allMovies.size(); i+=1){
            if (allMovies.get(i).getTitle().equals(check_by_title)) {
                System.out.println("What do you wish to change: 1.Title 2.Director 3.Synopsis 4.Showing Status 5.Language 6.Type 7. PGRating 8.Exit");
                update_choice = sc2.nextInt();
                while (update_choice != 7){
                    switch (update_choice) {
                        case 1:
                            allMovies.get(i).setTitle();
                            System.out.println("Successfully updated! ");
                            break;
                        case 2:
                            allMovies.get(i).setDirector();
                            System.out.println("Successfully updated!");
                            break;
                        case 3:
                            allMovies.get(i).setSynopsis();
                            System.out.println("Successfully updated!");
                            break;
                        case 4:
                            System.out.println("Enter movie showing status: ");
                            System.out.println("1: Coming soon");
                            System.out.println("2: Preview");
                            System.out.println("3: Now showing");
                            System.out.println("4: End of showing");
                            int theStatus = sc2.nextInt();
                            allMovies.get(i).setShowingStatus(theStatus);
                            System.out.println("Successfully updated!");
                            break;
                        case 5:
                            allMovies.get(i).setLanguage();
                            System.out.println("Successfully updated!");
                            break;
                        case 6:
                        	allMovies.get(i).setType();
                            System.out.println("Successfully updated!");
                            break;
                        case 7:
                        	allMovies.get(i).setPGrating();;
                            System.out.println("Successfully updated!");
                            break;
                        default:
                            System.out.println("Invalid choice. Choose between 1 to 5.");
                    }
                    System.out.println("What do you wish to change: 1.Title 2.Director 3.Synopsis 4.Showing Status 5.Language 6.Type 7. PGRating 8.Exit");
                    update_choice = sc2.nextInt();
                }

            }

        }
        this.allMovies = allMovies;
        sc2.close();
    }
    
    public ArrayList<Movie> getAllMovies(){
    	return this.allMovies;
    }
    
    public void removeMovieInArray(String check_by_title, ArrayList<Movie> allMovies) {
        for (int i = 0; i < numberOfMovies; i += 1) {
            if (allMovies.get(i).getTitle().equals(check_by_title)) {
            	allMovies.get(i).setShowingStatus(4);
            }
        }
        this.allMovies = allMovies;
    }
    public void displayMovieRanking(ArrayList<Movie> allMovies){
    	Scanner sc2 = new Scanner(System.in);
        int display_choice = 0;
        System.out.println("Enter ranking criteria: 1.Ticket Sales 2.Review Ratings ");
        display_choice = sc2.nextInt();
        switch(display_choice){
            case 1:
                // TODO after booking history
            case 2:
                Map <String, Double> map = new HashMap<String, Double>();
                for (int i = 0; i<= allMovies.size(); i++){
                    Movie aMovie = allMovies.get(i);
                    map.put(aMovie.getTitle(), aMovie.calcOverallRating(aMovie.getReviewArray()));
                }
        }
        this.allMovies = allMovies;
        sc2.close();
    }
}