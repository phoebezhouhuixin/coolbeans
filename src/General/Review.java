package General;

import java.util.Scanner;

public class Review {
    private String comment;
    private int rating;
    Scanner sc4 = new Scanner(System.in);

    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }

    public Review() {
        setComment();
        setRating();
    }

    public String getComment() {
        return comment;
    }

    public void setComment() {
        System.out.println("Please enter your comments (in one parah) about the movie: ");
        comment = sc4.nextLine();
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating() {
        System.out.println("Please rate the movie from 1 to 5");
        rating = sc4.nextInt();
        while (rating<1 || rating>5){
            System.out.println("Please re-enter appropriate rating value beteen 1 to 5");
            rating = sc4.nextInt();
        }
        this.rating = rating;
    }
}
