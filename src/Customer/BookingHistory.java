package Customer;
import General.*;

import java.util.ArrayList;

public class BookingHistory {
    MoviesArray movieObj = new MoviesArray();
    ArrayList<Movie> allMovies= movieObj.getMoviesArray();
    public void addReview(Movie movieTitle){
        for (Movie aMovie : allMovies){ // i.e. "for movie in the arraylist of all movies"
            if (aMovie.getTitle().equals(movieTitle)) {
                aMovie.getReviewArray().add(new Review());
                return;
            }
        }
    }
}
