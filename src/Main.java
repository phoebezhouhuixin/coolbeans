import java.util.*;



//General imports
import General.Movie;
import General.CinemaTypes;
import General.MovieTypes;
import General.AgeTypes;
import General.DayTypes;
import Moviegoer.Search;
import Moviegoer.ViewDetails;
import Moviegoer.ViewHistory;
//Admin imports
import Admin.Login;
import Admin.ModifyMovie;
import Admin.TicketPrice;

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
		FileDb moviesDb = new FileDb();
		moviesDb.setDbName("movies");
		ArrayList<Map<String, String>> moviesData = moviesDb.readDataBase("movies");
		// TODO: add the movies from the movies.txt file into the ArrayList
		// TODO: add an array for Reviews and for Cast
		for (Map<String, String> theMovie : moviesData) {
			allMovies.add(new Movie(theMovie.get("title"), theMovie.get("synopsis"),
					theMovie.get("director"), theMovie.get("language"), theMovie.get("type"),
					theMovie.get("PGrating"), theMovie.get("status"), theMovie.get("overallRating"), theMovie.get("cast")));
		}

		// Define the EnumMaps that dictate the price for each type of cinema,
		// price each type of movie, price for each age group, price for each day (holiday or not).
		EnumMap<CinemaTypes, Double> cinemaPriceMap = new EnumMap<CinemaTypes, Double>(CinemaTypes.class);
		cinemaPriceMap.put(CinemaTypes.SILVER, 10.00);
		cinemaPriceMap.put(CinemaTypes.GOLD, 12.00);
		cinemaPriceMap.put(CinemaTypes.PLATINUM, 15.00);

		EnumMap<MovieTypes, Double> moviePriceMap = new EnumMap<MovieTypes, Double>(MovieTypes.class);
		moviePriceMap.put(MovieTypes.TWOD, 4.00);
		moviePriceMap.put(MovieTypes.THREED, 5.00);
		moviePriceMap.put(MovieTypes.BLOCKBUSTER, 6.00);

		EnumMap<AgeTypes, Double> agePriceMap = new EnumMap<AgeTypes, Double>(AgeTypes.class);
		agePriceMap.put(AgeTypes.STUDENT, 4.00);
		agePriceMap.put(AgeTypes.SENIOR, 3.00);
		agePriceMap.put(AgeTypes.CHILD, 2.00);
		agePriceMap.put(AgeTypes.ADULT, 0.00);

		EnumMap<DayTypes, Double> dayPriceMap = new EnumMap<DayTypes, Double>(DayTypes.class);
		dayPriceMap.put(DayTypes.WEEKDAY, 4.00);
		dayPriceMap.put(DayTypes.WEEKEND, 5.00);
		dayPriceMap.put(DayTypes.HOLIDAY, 6.00);


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
				System.out.println("1. Create movie listing/Update movie listing/Remove movie listing/ View ranking of movies");
				System.out.println("2. Create/Update/Remove cinema show times and movie to be shown");
				System.out.println("3. Configure system settings");
				System.out.println("4. View list of all movies");
				System.out.println("5. Quit");
				choice1 = sc1.nextInt();
				sc1.nextLine();
				switch (choice1) {
					case 1:
						System.out.println("What do you wish to do: 1.Create 2.Update 3.Remove 4.View ranking");
						choice2 = sc1.nextInt();
						sc1.nextLine();
						switch (choice2) {
							case 1:
								modify.createMovie(allMovies);
								System.out.println("Movie listing created!");
								break;
							case 2:
								System.out.println("Enter the name of the movie that you wish to update: ");
								check_by_title = sc1.nextLine();
								modify.updateExistingMovieInArray(check_by_title, allMovies);
								break;
							case 3:
								System.out.println("Enter the name of the movie that you wish to remove: ");
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
								tp.tpmovietype(moviePriceMap);
								System.out.println("Price has been changed!");
								break;
							case 2:
								tp.tpcinema(cinemaPriceMap);
								System.out.println("Price has been changed!");
								break;
							case 3:
								tp.tpage(agePriceMap);
								System.out.println("Price has been changed!");
								break;
							case 4:
								tp.tpday(dayPriceMap);
								System.out.println("Price has been changed!");
								break;
						}

					case 4:
						FileDb movieDb = new FileDb();
						movieDb.setDbName("movies");
						ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
						System.out.println(String.format("    %7s %15s %10s %15s %9s %10s %20s %15s %7s", "title", "synopsis", "director", "language", "type", "PGrating", "status", "overallRating", "cast"));
						Integer counter = 1;
						for (Map<String, String> movie : movies) {
							System.out.println(counter.toString() + " : " + String.format("%7s %15s %10s %15s %9s %10s %20s %15s %7s", movie.get("title"), movie.get("synopsis"), movie.get("director"), movie.get("language"), movie.get("type"), movie.get("PGrating"), movie.get("status"), movie.get("overallRating"), movie.get("cast")));//movie.get("title")+", "+movie.get("synopsis"))+", "+movie.get("director")+", "+movie.get("language")+", "+movie.get("type")+", "+movie.get("PGrating")+", "+movie.get("status")+ ", "+movie.get("overallRating")+", "+movie.get("cast"));
							counter += 1;
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
			while (true) {
				System.out.println("\n\nWhat do you wish to do? 1. Book movie 2. View History 3.Leave Review 4.Quit ");
				int choice = sc2.nextInt();

				// 2. Viewing history
				if (choice == 2) {

					ViewHistory vh = new ViewHistory();
					vh.view(username, password);

				} else if (choice == 3) {
					String movie_to_review;
					ViewHistory vh = new ViewHistory();
					FileDb movieDb = new FileDb();
					movieDb.setDbName("movies");
					ArrayList<Map<String, String>> movies = movieDb.readDataBase("movies");
					System.out.println("The movies you can review are: ");
					System.out.println("Movie Name" + "\t" + "Showing Status");
					for (Map<String, String> per_movie : movies) {
						if (per_movie.get("status").equals("Now Showing") || per_movie.get("status").equals("Preview"))
							System.out.println(per_movie.get("title") + "\t\t" + per_movie.get("status"));
					}
					System.out.println("Enter the name of the movie you wish to leave a review about: ");
					movie_to_review = sc2.next();
					vh.leaveReview(movie_to_review);
					System.out.println("Your review has been recorded!");
				}

				// 1. choose movie
				else if (choice == 1) {
					System.out.println("Welcome to movie booking system!");
					System.out.println("Do you wish to: 1.Movies overview 2.View single movie details 3. Start booking now ");
					int subchoice = sc2.nextInt();
					switch (subchoice) {
						case 1: 
							Search s = new Search();
							s.display();
							break;

						case 2: 
							ViewDetails v = new ViewDetails();
							v.displaydetails();
							break;
						case 3: // start booking
							// step 1: choose the movie
							ArrayList<String> seatsChosenList = new ArrayList<String>();
							String moviechoice;

							Integer i = 1;
							for (Movie theMovie : allMovies) {
								System.out.println("Movie " + i.toString() + ": " + theMovie.getTitle());
								i++;
							}

							moviechoice = allMovies.get(sc2.nextInt() - 1).getTitle();

							// find the available cineplexes for that movie, using showtimes.txt
							FileDb showtimesDb = new FileDb();
							showtimesDb.setDbName("showtimes");
							ArrayList<Map<String, String>> showtimesData = showtimesDb.readDataBase("showtimes");

							ArrayList<Map<String, String>> relevantData = new ArrayList<Map<String, String>>();
							// The relevantData ArrayList will contain only the showtimes for the user's selected movie
							// We can display the contents of the relevantData ArrayList after each step of selection by the user.

							for (Map<String, String> theShow : showtimesData) {
								if (theShow.get("movieTitle").equals(moviechoice)) {
									Map<String, String> copy = new HashMap<>();
									for (Map.Entry<String, String> entry : theShow.entrySet()) {
										copy.put(entry.getKey(), entry.getValue());
									}
									relevantData.add(copy);
								}
							}

							// Define the EnumMaps that dictate the price for each type of cinema,
							// price each type of movie, price for each age group, price for each day (holiday or not).;
							// step 2: select the showtime
							i = 1;
							System.out.println("Select an option number");
							System.out.format("%12s%12s%12s%12s%12s%12s%12s%12s%n", " ", "Day type", "Movie type", "Cinema type", "Cineplex", "Time", "Movie title", "Day");
							//System.out.println("\t Movie title \t Cineplex \t Movie type \t Cinema type \t Day \t Time \t Day type ");
							for (Map<String, String> theShow : relevantData) {
								System.out.printf("%9s %d:", "Movie", i);
								for (Map.Entry<String, String> entry : theShow.entrySet()) {
									System.out.printf("%12s", entry.getValue());
								}
								System.out.println();
								i++;
							}
							int showtimechoice = sc2.nextInt();
							Map<String, String> selectedShow = relevantData.get(showtimechoice - 1);
							Cineplex cineplex = new Cineplex(selectedShow.get("cineplex"));

							// step 3: choose seat

							while (true) {
								SeatSelector ss = new SeatSelector(seatsChosenList);
								String seatChosen = ss.getSelectedSeat();
								seatsChosenList.add(seatChosen);
								System.out.println("Seat chosen:" + seatChosen);

								// step 4: get the user info and output the final ticket price
								Ticket t = new Ticket(selectedShow, cinemaPriceMap, moviePriceMap, agePriceMap, dayPriceMap);
								System.out.println("Ticket price is :" + t.getTicketPrice().toString());
								FileDb history = new FileDb();
								history.setDbName("history");
								String[] record = new String[]{username, password, t.name, t.phNo, t.email,
										t.cinemaType.getCinemaTypeName(), t.movieType.getMovieTypeName(), t.ageType.getAgeName(),
										t.dayType.getDayName(), t.getTicketPrice().toString(), t.transactionID};
								System.out.println("Thank you for booking! You are watching:");
								System.out.println(selectedShow.get("movieTitle"));
								System.out.println("Venue: " + selectedShow.get("cineplex") + "\t" + selectedShow.get("cinemaType"));
								System.out.println("When: " + selectedShow.get("day") + "\t" + selectedShow.get("time"));
								System.out.println("Paid: " + t.getTicketPrice().toString());
								history.addRecord(record);

								sc2.nextLine(); // clear input buffer
								System.out.println("Book another seat? (y/n):");
								String cfm = sc2.nextLine();
								if (cfm.toLowerCase().equals("n")) {
									break;
								}
							}
							break;
					}					
				}
				if (choice == 4) {
					break;
				}
			}

			sc2.close();
		}
		
	}
}
