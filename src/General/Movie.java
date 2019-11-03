package General;

import java.util.Scanner;
import java.util.ArrayList;

public class Movie {
    Scanner sc3 = new Scanner(System.in);
    private String title, synopsis, director,language;
    private ArrayList<String> castArray = new ArrayList<String>();
    private StatusEnum showingStatus;
    private int runtime;

    // not in the constructor
    private ArrayList<Review> reviewArray = new ArrayList<Review>(); // created by default every time we create a new movie.
    private double overallrating;

    // implement all the constructors, getters and setters later
    // constructor
    public Movie(String theTitle){
         title = theTitle;
    }
    public void setCast(ArrayList<String> theNames){
        castArray = theNames;
    }
    public void setTitle(){
        System.out.println("Enter the movie title: ");
        title = sc3.nextLine();
        this.title = title;
    }
    public void setSynopsis(){
        System.out.println("Enter the movie synopsis: ");
        synopsis = sc3.nextLine();
        this.synopsis = synopsis;
    }
    public void setDirector(){
        System.out.println("Enter the movie director: ");
        director = sc3.nextLine();
        this.director = director;
    }
    public void setRuntime(){
        System.out.println("Enter the movie runtime: ");
        runtime = sc3.nextInt();
        this.runtime = runtime;
    }
    public void setShowingStatus(int theStatus){

        showingStatus = StatusEnum.values()[theStatus-1];
    }
    public void setLanguage(){
        System.out.println("Enter the movie language");
        language = sc3.nextLine();
    }
    public String getTitle(){
        return title;
    }
    public StatusEnum getShowingStatus(){
        return showingStatus;
    }
    public String getSynopsis(){
        return synopsis;
    }
    public String getDirector(){
        return director;
    }
    public int getRuntime(){
        return runtime;
    }
    public ArrayList<String> getCast(){
        return castArray;
    }
    public ArrayList<Review> getReviewArray() {
        return reviewArray;
    }
    public double calcOverallRating(ArrayList<Review> reviewArray){
        int sum = 0;
        for (Review aReview: reviewArray){
            sum+= aReview.getRating();
        }
        overallrating= sum/reviewArray.size();
        return overallrating;
    }

}
