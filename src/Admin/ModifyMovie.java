package Admin;
import java.util.Scanner;
import java.util.ArrayList;


import General.*;

public class ModifyMovie { // call the setters of General.Movie.java
    int numberOfMovies = 0;
    Scanner sc2 = new Scanner(System.in);
    // todo : create a main to initialize moviesarray
    MoviesArray movieObj = new MoviesArray();
    ArrayList<Movie> allMovies= movieObj.getMoviesArray();
    public void createMovie(MoviesArray allMovies){
        System.out.println("Enter movie title: ");
        String theTitle = sc2.nextLine();
        Movie newMovie = new Movie(theTitle);
        newMovie.setSynopsis();
        newMovie.setDirector();
        newMovie.setRuntime();
        newMovie.setShowingStatus();
        newMovie.setLanguage();

        /*
        System.out.println("Enter movie showing status: ");
        System.out.println("1: Coming soon");
        System.out.println("2: Preview");
        System.out.println("3: Now showing");
        System.out.println("4: End of showing");
        int theStatus = sc2.nextInt();


        System.out.println("Enter movie synopsis: ");
        String theSynopsis = sc2.nextLine();

        System.out.println("Enter movie director: ");
        String theDirector = sc2.nextLine();

        System.out.println("Enter movie language: ");
        String theLanguage = sc2.nextLine();*/

        System.out.println("Enter movie cast names one by one, and 0 to stop: ");
        String theName;
        ArrayList<String> theNames = new ArrayList<String>();
        do {
            theName = sc2.nextLine();
            if (theName != "0")
                theNames.add(theName);
        } while (theName != "0");
        newMovie.setCast(theNames);
        //Movie newMovie = new Movie(theTitle, theStatus, theSynopsis, theDirector, theLanguage, theNames);
        addNewMovieToArray(newMovie);
    }
    public void addNewMovieToArray(Movie newMovie){
        this.numberOfMovies+=1;
        allMovies.add(newMovie); // DO SOMETHING ABOUT THIS LOL
    }
    public void updateExistingMovieInArray(String check_by_title){
        int update_choice=0;
        for (int i =0; i<= numberOfMovies; i+=1){
            if (allMovies.get(i).getTitle() == check_by_title) {
                // todo : do the updation
                System.out.println("What do you wish to change: 1.Title 2.Director 3.Synopsis 4.Showing Status 5.Language 6.Exit");
                update_choice = sc2.nextInt();
                while (update_choice != 6){
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
                            allMovies.get(i).setShowingStatus();
                            System.out.println("Successfully updated!");
                            break;
                        case 5:
                            allMovies.get(i).setLanguage();
                            System.out.println("Successfully updated!");
                            break;
                        default:
                            System.out.println("Invalid choice. Choose between 1 to 5.");
                    }
                    update_choice = sc2.nextInt();
                }

            }

        }

    }
}
