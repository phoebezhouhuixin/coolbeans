package Customer;
import General.*;

import java.util.ArrayList;

public class BookingHistory {
    public void addReview(Movie movieTitle, ArrayList<Movie> allMovies){
    	/**
    	 * allows MovieGoer to add a review to the reviews array
    	 */
        for (Movie aMovie : allMovies){ // i.e. "for movie in the arraylist of all movies"
            if (aMovie.getTitle().equals(movieTitle)) {
                aMovie.getReviewArray().add(new Review());
                return;
            }
        }
    }
}
