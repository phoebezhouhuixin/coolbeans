package General;


import java.util.Scanner;
import java.util.ArrayList;

public class Movie {
//    Scanner sc3 = new Scanner(System.in);
    private String title, synopsis, director,language,type,PGrating;
    private ArrayList<String> castArray = new ArrayList<String>();
    private StatusEnum showingStatus;
    private int runtime,type_choice,PGrating_choice;
    Scanner sc = new Scanner (System.in);
    // not in the constructor
    private ArrayList<Review> reviewArray = new ArrayList<Review>(); // created by default every time we create a new movie.
    private Integer overallrating =0;

    // implement all the constructors, getters and setters later
    // constructor
    public Movie(String theTitle){
        title = theTitle;
    }
    public void setCast(ArrayList<String> theNames){
        castArray = theNames;
    }
    public void setTitle(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie title: ");
        this.title = sc.nextLine();
        //sc3.close();
    }
    public void setSynopsis(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie synopsis: ");
        this.synopsis = sc.nextLine();
        //sc3.close();
    }
    public void setType(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter number for choosing the movie type among: 1.2D  2.3D  3.Blockbuster: ");
        this.type_choice = sc.nextInt();
        switch(type_choice){
        case 1:
        	type = "TWO-D";
        	break;
        case 2:
        	type = "THREE-D";
        	break;
        case 3:
        	type = "BLOCKBUSTER";
        	break;
        }
        //sc3.close();
    }
    public void setPGrating(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter number for choosing the movie rating among 1.G  2.PG  3.PG-13 4.R");
        this.PGrating_choice = sc.nextInt();
        switch(PGrating_choice){
        case 1:
        	PGrating = "G";
        	break;
        case 2:
        	PGrating = "PG";
        	break;
        case 3:
        	PGrating = "PG-13";
        	break;
        case 4:
        	PGrating = "R";
        	break;
        }
        //sc3.close();
    }
    public void setDirector(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie director: ");
        this.director = sc.nextLine();
        //sc3.close();
    }
    public void setRuntime(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie runtime: ");
        this.runtime = sc.nextInt();
        //sc3.close();
    }
    public void setShowingStatus(int theStatus){

        showingStatus = StatusEnum.values()[theStatus-1];
    }
    public void setLanguage(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie language: ");
        this.language = sc.next();
        //sc3.close();
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
    public String getLanguage(){
        return language;
    }
    public String getType(){
        return type;
    }
    public String getPGrating(){
        return PGrating;
    }
    public Integer getOverallRating(){
        return overallrating;
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
