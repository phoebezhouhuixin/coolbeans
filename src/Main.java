import General.Movie;
import Admin.Login;
import Admin.ModifyMovie;
import java.util.Scanner;

import java.util.ArrayList;

// TODO : close all the scanner objs

public class Main {

	public static void main(String[] args) {
		/*
		 * 1.ask if movieGoer or staff 2. staff -> staff login -> staff control
		 * options[update movie/cinema details, change ticket details] 3. movieGoer ->
		 * movieGoer login -> options[see history, leave review, book]
		 */

		ArrayList<Movie> allMovies = new ArrayList<Movie>();
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		login.setusername();
		login.setpassword();
		String username = login.getusername();
		String password = login.getpassword();
		System.out.println(username + " : " + password);
		// TODO: verify username and password recieved

		// assuming staff
		int choice1 = 0, choice2 = 0;
		ModifyMovie modify = new ModifyMovie();
		boolean loopCtrl = true;
		while (loopCtrl) {
			String check_by_title;
			System.out.println("What do you wish to do:");
			System.out.println("1. Create/Update/Remove/View ranking Movie listing");
			System.out.println("2. Create/Update/Remove cinema show times and movie to be shown");
			System.out.println("3. Configure system settings");
			System.out.println("4. view allmovies arraylist");
			System.out.println("5. Quit");
			choice1 = sc.nextInt();
			switch (choice1) {
			case 1:				
				System.out.println("What do you wish to do: 1.Create 2.Update 3.Remove 4.View ranking");
				choice2 = sc.nextInt();
				switch (choice2) {
				case 1:
					modify.createMovie(allMovies);
					System.out.println("Movie listing created!");
					break;
				case 2:
					System.out.println("Enter the name of the movie that you wish to update: ");
					sc = new Scanner(System.in);
					check_by_title = sc.nextLine();
					modify.updateExistingMovieInArray(check_by_title, allMovies);
					break;
				case 3:
					System.out.println("Enter the name of the movie that you wish to remove: ");
					sc = new Scanner(System.in);
					check_by_title = sc.nextLine();
					modify.removeMovieInArray(check_by_title, allMovies);
					break;
				case 4:
					modify.displayMovieRanking(allMovies);
					break;
				}
				break;
			case 4:
				for (Movie movie : modify.getAllMovies()) {
					System.out.println(movie.getTitle());
				}
				System.out.println("-------------------------");
				for (Movie movie : allMovies) {
					System.out.println(movie.getShowingStatus());
				}
				break;
			case 5:
				loopCtrl = false;
				break;
			}
		}

	}
}
