package Customer;
import General.*;

import java.util.ArrayList;

public class BookingHistory {
    // TODO instantiate ArrayList<Movie> allMovies in main() function
    public void addReview(Movie movieTitle, ArrayList<Movie> allMovies){
        for (Movie aMovie : allMovies){ // i.e. "for movie in the arraylist of all movies"
            if (aMovie.getTitle().equals(movieTitle)) {
                aMovie.getReviewArray().add(new Review());
                return;
            }
        }
    }
}
