package General;


import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

import fileDb.FileDb;

public class Movie {
//    Scanner sc3 = new Scanner(System.in);
    private String title, synopsis, director,language,PGrating, cast;
    private ArrayList<String> castArray = new ArrayList<String>();
    private MovieTypes type;
    private StatusEnum showingStatus;
    private int runtime,type_choice,PGrating_choice;
    Scanner sc = new Scanner (System.in);
    // not in the constructor
    private double overallrating =0;

    // implement all the constructors, getters and setters later
    // constructor
    /**
     * Default constructor to initialize the Movie title
     * @param theTitle title of the movie
     */
    public Movie(String theTitle){
        title = theTitle;
    }

     // overload constructor
     /**
      * Parametrised constructor to initialize a movie by setting each attribute of a movie
      * @param title Title of the movie
      * @param synopsis Synopsis of the movie
      * @param director Director of the movie
      * @param language Language of the movie
      * @param type Movie type among 2D, 3D and blockbuster
      * @param PGrating MoviePG Rating PG, PG-13, G and R
      * @param status Showing status of the movie: Coming soon, Preview, Now showing or End of showing
      * @param overallRating Overall Rating of the movie based on past reviews
      * @param cast Cast of the movie
      */
    public Movie(String title, String synopsis, String director, String language,
                 String type, String PGrating, String status, String overallRating, String cast){
        this.title = title;
        this.synopsis = synopsis;
        this.director = director;
        this.language = language;
        for (MovieTypes theType: MovieTypes.values()){
            if (theType.getMovieTypeName().equals(type))
                this.type = theType;
        }
        this.PGrating = PGrating;
        for (StatusEnum theStatus: StatusEnum.values()){
            if (theStatus.toString().equals(status))
                this.showingStatus = theStatus;
        }
        this.overallrating  = Double.valueOf(overallRating);
        this.cast = cast;
        castArray.add(cast);
    }
    /**
     * Sets the cast featured in the movie
     * @param theNames Arraylist of the names of each cast member
     */
    public void setCast(ArrayList<String> theNames){
        castArray = theNames;
    }
    /**
     * Sets the title of the current movie
     */
    public void setTitle(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie title: ");
        this.title = sc.nextLine();
        //sc3.close();
    }
    /**
     * Sets the synopsis of the current movie 
     */
    public void setSynopsis(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie synopsis: ");
        this.synopsis = sc.nextLine();
        //sc3.close();
    }
    /**
     * Sets the Type of the current movie among: 2D, 3D and BlockBuster
     */
    public void setType(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter number for choosing the movie type among: 1.2D  2.3D  3.Blockbuster: ");
        this.type_choice = sc.nextInt();
        sc.nextLine();
        switch(type_choice){
            case 1:
                type = MovieTypes.TWOD;
                break;
            case 2:
                type = MovieTypes.THREED;
                break;
            case 3:
                type = MovieTypes.BLOCKBUSTER;
                break;
        }
        //sc3.close();
    }
    /**
     * Sets the current movie's PGRating among: G, PG, PG-13 and R
     */
    public void setPGrating(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter number for choosing the movie rating among 1.G  2.PG  3.PG-13 4.R");
        this.PGrating_choice = sc.nextInt();
        sc.nextLine();
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
    /**
     * Sets the director of the current movie
     */
    public void setDirector(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie director: ");
        this.director = sc.nextLine();
        //sc3.close();
    }
    /** 
     * Sets the runtime of the movie in  the form of integral hours  
     */
    public void setRuntime(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie runtime: ");
        this.runtime = sc.nextInt();
        sc.nextLine();
        //sc3.close();
    }
    /**
     * Sets the showing status of the current movie
     * @param theStatus status of the mvoie among: coming soon, now showing, preview and end of showing
     */
    public void setShowingStatus(int theStatus){
        showingStatus = StatusEnum.values()[theStatus-1];
    }
    /**
     * Sets the language of the current movie
     */
    public void setLanguage(){
    	//Scanner sc3 = new Scanner(System.in);
        System.out.println("Enter the movie language: ");
        this.language = sc.next();
        sc.nextLine();
        //sc3.close();
    }
    /**
     * Returns the title of the movie
     * @return movie title
     */
    public String getTitle(){
        return title;
    }
    /**
     * Returns the showing status
     * @return status of movie
     */
    public StatusEnum getShowingStatus(){
        return showingStatus;
    }
    /**
     * Returns the synopsis of the movie
     */
    public String getSynopsis(){
        return synopsis;
    }
    /**
     * Returns the language of the movie
     * @return language of movie
     */
    public String getLanguage(){
        return language;
    }
    /**
     * Returns the type of the movie among: 2D, 3D and Blockbuster
     */
    public MovieTypes getType(){
        return type;
    }
    /**
     * Returns the PGRating of the movie
     * @return PGRating of movie
     */
    public String getPGrating(){
        return PGrating;
    }
    /**
     * Returns the overall rating of the movie
     */
    public Double getOverallRating(){
    	return calcOverallRating(this.getTitle());
    }
    /**
     * Returns the director of the movie
     * @return movie director
     */
    public String getDirector(){
        return director;
    }
    /**
     * Returns the runtime of the movie
     * @return movie runtime
     */
    public int getRuntime(){
        return runtime;
    }
    /**
     * Returns the cast of the movie
     * @return arraylist of names of cast
     */
    public ArrayList<String> getCast(){
        return castArray;
    }
    /**
     * Calculates and returns the overall rating of the movie chosen by taking an average of all the ratings available for that movie 
     */
    public Double calcOverallRating(String movie_name){
        double sum = 0;
        double	count=0;
        FileDb reviewDb = new FileDb();
        reviewDb.setDbName("reviews");
		ArrayList<Map<String, String>> reviewData = reviewDb.readDataBase("reviews");
		for (Map<String, String> per_review : reviewData) {
			if (per_review.get("title").equals(movie_name)) {
				sum+= Integer.parseInt(per_review.get("rating"));
				count+=1;
			}
		}
		if (count==0)
			overallrating = 0;
		else
			overallrating= sum/count;
        return overallrating;
    }
    /**
     * Calculates and returns the overall sales of the movie chosen by taking an average of all the ratings available for that movie 
     */
    public void calcTicketSales(String movie_name){
        Double sales = 0.0;
        int count=0;
        FileDb history = new FileDb();
        history.setDbName("history");
		ArrayList<Map<String, String>> historyData = history.readDataBase("history");
		FileDb salesDb = new FileDb();        
		salesDb.setDbName("sales");
		ArrayList<Map<String, String>> salesData = salesDb.readDataBase("sales");
        //System.out.println("The history data is: "+historyData);
		for (Map<String, String> per_sale : historyData) {
			if (per_sale.get("movie").equals(movie_name)) {
				sales+= Double.parseDouble(per_sale.get("price"));
				count++;
			}
		}
		if (count==0)
			sales = 0.0;
		
		String [] addToSales = new String[]{movie_name, sales.toString()};
		//System.out.println(movie_name);
		//System.out.println(salesData);
		for (Map<String, String> sale : salesData) {
			if(sale.get("title").equals(movie_name)){
				salesDb.removeEntry("title", movie_name);				
			}
		}	
		salesDb.addRecord(addToSales);
		
    }

}
