import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

//General imports
import General.Movie;
import Moviegoer.ViewHistory;
//Admin imports
import Admin.Login;
import Admin.ModifyMovie;
import Admin.TicketPrice;
import Booking.ChooseMovie;
//Booking imports
import Booking.Cineplex;
import Booking.SeatSelector;
import Booking.Ticket;
//fileDb import
import fileDb.FileDb;

// TODO : close all the scanner objs

public class Main {

	public static void main(String[] args) {
		/*
		 * 1.ask if movieGoer or staff 2. staff -> staff login -> staff control
		 * options[update movie/cinema details, change ticket details] 3. movieGoer ->
		 * movieGoer login -> options[see history, leave review, book]
		 */

		ArrayList<Movie> allMovies = new ArrayList<Movie>();
//		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		login.setusername();
		login.setpassword();
		String username = login.getusername();
		String password = login.getpassword();
		System.out.println(username + " : " + password);
		// verification of username and password received from db
		FileDb authDb = new FileDb();
		authDb.setDbName("authentication");
		ArrayList<Map<String, String>> authData = authDb.readDataBase("authentication");
		boolean auth = false;
		boolean staff = false;
		for (Map<String, String> user : authData) {
			if (user.get("username").equals(username) && user.get("password").equals(password)) {
				auth = true;
				if (user.get("type").equals("moviegoer")) {
					staff = false;
					System.out.println("MovieGoer authenticated");
				}
				if (user.get("type").equals("staff")) {
					staff = true;
					System.out.println("Staff authenticated");
				}

				break;
			}
		}
		if (auth == false) {
			System.out.println("Invalid username and/or password :( Try again");
		}
//		sc.close();

		if (staff == true && auth) {
			Scanner sc1 = new Scanner(System.in);
			// assuming staff
			int choice1 = 0, choice2 = 0, choice3 = 0;
			ModifyMovie modify = new ModifyMovie();
			TicketPrice tp = new TicketPrice();
			boolean loopCtrl = true;
			while (loopCtrl) {
				String check_by_title;
				System.out.println("What do you wish to do:");
				System.out.println("1. Create/Update/Remove/View ranking Movie listing");
				System.out.println("2. Create/Update/Remove cinema show times and movie to be shown");
				System.out.println("3. Configure system settings");
				System.out.println("4. view allmovies arraylist");
				System.out.println("5. Quit");
				choice1 = sc1.nextInt();
				switch (choice1) {
				case 1:
					System.out.println("What do you wish to do: 1.Create 2.Update 3.Remove 4.View ranking");
					choice2 = sc1.nextInt();
					switch (choice2) {
					case 1:
						modify.createMovie(allMovies);
						System.out.println("Movie listing created!");
						break;
					case 2:
						System.out.println("Enter the name of the movie that you wish to update: ");
//						sc = new Scanner(System.in);
						check_by_title = sc1.nextLine();
						modify.updateExistingMovieInArray(check_by_title, allMovies);
						break;
					case 3:
						System.out.println("Enter the name of the movie that you wish to remove: ");
//						sc = new Scanner(System.in);
						check_by_title = sc1.nextLine();
						modify.removeMovieInArray(check_by_title, allMovies);
						break;
					case 4:
						modify.displayMovieRanking(allMovies);
						break;
					}
					break;
				case 3:
					System.out.println(
							"Do you wish to change the price for: 1. Type of movie 2. Type of cinema 3. Type of movie goer 4. Type of day ");
					choice3 = sc1.nextInt();
					switch (choice3) {
					case 1:
						tp.tpmovietype();
						System.out.println("Price has been changed!");
						break;
					case 2:
						tp.tpcinema();
						System.out.println("Price has been changed!");
						break;
					case 3:
						tp.agecinema();
						System.out.println("Price has been changed!");
						break;
					case 4:
						tp.daycinema();
						System.out.println("Price has been changed!");
						break;
					}

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
			sc1.close();
		}

		if (staff == false && auth) {
			Scanner sc2 = new Scanner(System.in);
			// assuming it's the moviegoer
			/*
			 * Moviegoer 1. Book movie (movie -> cineplex -> cinema -> details[day, time] ->
			 * seat -> enter personal details -> confirmation[add movie to db for history
			 * access]) 2. View history (from historydb) 3. Leave Reviews (only for movies
			 * seen already by user)
			 */

			System.out.println("What do you wish to do? 1. Book movie 2. View History 3.Leave Review ");
			int choice = sc2.nextInt();
			
			// 2. Viewing history
			if(choice == 2) {
				int choice3 = 0;
				System.out.println("What do you wish to do? 1. Book Tickets 2. View History 3.Leave Review ");
				choice3 = sc2.nextInt();
				sc2.nextLine();
				if (choice3 == 2) {
					ViewHistory vh = new ViewHistory();
					vh.view();
				}
			}
			
			// 1. choose movie
			else if (choice == 1) {
				ArrayList<String> seatsChosenList = new ArrayList<String>();
				System.out.println("Welcome to movie booking system!");

				ChooseMovie choiceofmovie = new ChooseMovie();
				choiceofmovie.choice(allMovies);
				// 2. choose cineplex, cinema, get daytime
				// loading cineplex locations from db
				FileDb cineplexDb = new FileDb();
				cineplexDb.setDbName("cineplexLocations");
				Map<String, String> cpData = cineplexDb.readDataBase("cineplexLocations").get(0);

				String[] cineplexLocations = new String[] { cpData.get("Location1"), cpData.get("Location2"),
						cpData.get("Location3"), cpData.get("Location4") }; // TODO : load locations from db
				System.out.println("Choose cineplex location");
				for (Integer i = 1; i <= cineplexLocations.length; i += 1) {
					System.out.println(i.toString() + ") " + cineplexLocations[i - 1]);
				}

				int choice4 = sc2.nextInt();
				sc2.nextLine();
				// TODO : error message if incorrect choice
				Cineplex cineplex = new Cineplex(cineplexLocations[choice4 - 1]);
				while (true) {
					// 5. get seat
					SeatSelector ss = new SeatSelector(seatsChosenList);
					String seatChosen = ss.getSelectedSeat();
					seatsChosenList.add(seatChosen);

					System.out.println(cineplex.cineplexLocation + ", " + cineplex.cinema.cinematype + ", "
							+ cineplex.cinema.cost.toString() + ", " + cineplex.cinema.day + ", " + cineplex.cinema.time);
					System.out.println("Seat chosen:" + seatChosen);

					// ticket class, which gets the user info and sets the price
					Ticket t = new Ticket(cineplex);
					Double ticketPrice = t.getTicketPrice();
					System.out.println("Ticketprice is :" + ticketPrice.toString());
					FileDb history = new FileDb();
					history.setDbName("history");
					String[] record = new String[] { username, password, t.name, t.phNo, t.email, t.cinemaType,choiceofmovie.selected_movie, t.movieType, t.ageType, t.dayType, t.getTicketPrice().toString(),t.transactionID };
					history.addRecord(record);

					System.out.println("Book another seat? (y/n):");
//					while (!sc2.hasNext()) {
//						//wait until it has next
//					}
					String cfm = sc2.nextLine();
					if (cfm.toLowerCase().equals("n")) {
						break;
					}
				}
			}

			
			sc2.close();
		}

	}
}
