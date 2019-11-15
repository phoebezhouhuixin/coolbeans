package Customer;
import General.*;

import java.util.ArrayList;

public class BookingHistory {
    /**
     * Adds the moviegoer's review to the review array based on the movie chosen by them
     * @param movieTitle the movie chosen by the user to review
     * @param allMovies array list of all movies
     */
    public void addReview(Movie movieTitle, ArrayList<Movie> allMovies){
        for (Movie aMovie : allMovies){ // i.e. "for movie in the arraylist of all movies"
            if (aMovie.getTitle().equals(movieTitle)) {
                aMovie.getReviewArray().add(new Review());
                return;
            }
        }
    }
}
