package Admin;

import java.util.Scanner;
import java.util.EnumMap;
import General.CinemaTypes;
import General.MovieTypes;
import General.AgeTypes;
import General.DayTypes;

public class TicketPrice {
	/* No need the following, because the info is already stored
	 in our four EnumMaps (see imports above)
	private Double[] typecinema;
	private Double[] typemovie;
	private Double[] typeage;
	private Double[] typeday;*/
	private int user_choice;
	private double new_price1;
	private int cinema_choice = 0;
	private int ticketprice = 0;

	Scanner sc = new Scanner(System.in);

	/*public TicketPrice() {
		typecinema = new Double[] { 10.0, 12.0, 15.0 };
		typemovie = new Double[] { 4.0, 5.0, 6.0 };
		typeage = new Double[] { 2.0, 3.0, 4.0 };
		typeday = new Double[] { 4.0, 5.0, 6.0 };

	}*/

	/**
	 * Calculates the ticketprice for a particular movie, that is selected by the user
	 * @param moviePriceMap the price mapping using which we calculate movie price based on user's input.
	 */
	public void tpmovietype(EnumMap<MovieTypes, Double> moviePriceMap) {
		// double twod = 4.00, threed = 5.00, bb = 6.00;
		int movietype_choice = 0;
		System.out.println("Which movie type:");
		System.out.println("1.2-D  2.3-D 3.Blockbuster ");
		movietype_choice = sc.nextInt();
		switch (movietype_choice) {
			case 1:
				System.out.println("Current price is: "+ moviePriceMap.get(MovieTypes.TWOD)+", Enter the 2D ticket price: ");
				moviePriceMap.put(MovieTypes.TWOD, sc.nextDouble());
				// The method put will replace the value of an existing key and will create it if doesn't exist
				break;

			case 2:
				System.out.println("Current price is: "+ moviePriceMap.get(MovieTypes.THREED)+", Enter the 3D ticket price: ");
				moviePriceMap.put(MovieTypes.THREED, sc.nextDouble());
				break;

			case 3:
				System.out.println("Current price is: "+ moviePriceMap.get(MovieTypes.BLOCKBUSTER)+", Enter the blockbuster ticket price: ");
				moviePriceMap.put(MovieTypes.BLOCKBUSTER, sc.nextDouble());
				break;
		}
		/*typemovie[0] = twod;
		typemovie[1] = threed;
		typemovie[2] = bb;
		for(Double x : typemovie) {
			System.out.print(x.toString()+" ");
		}*/
		for(MovieTypes theType: MovieTypes.values()){
        	System.out.println(theType.name()+ moviePriceMap.get(theType));
        }
 
		System.out.println();
	}

	/**
	 * Calculates the ticketprice for a particular cinema, that is selected by the user (one of the factors used to calculate overall ticket price)
	 * @param cinemaPriceMap the price mapping using which we calculate price associated with a particular cinema input.
	 */
	public void tpcinema(EnumMap<CinemaTypes, Double> cinemaPriceMap) {
		// double GoldExtra = 12.00, SilverExtra = 10.00, PlatinumExtra = 15.00;

		System.out.println("Which cinema type:");
		System.out.println("1.Silver  2.Gold  3.Platinum ");
		cinema_choice = sc.nextInt();
		switch (cinema_choice) {
			case 1:
				System.out.println("Current price is: "+ cinemaPriceMap.get(CinemaTypes.SILVER)+", Enter the silver ticket price: ");
				cinemaPriceMap.put(CinemaTypes.SILVER, sc.nextDouble());
				break;

			case 2:
				System.out.println("Current price is: "+ cinemaPriceMap.get(CinemaTypes.GOLD)+", Enter the gold ticket price: ");
				cinemaPriceMap.put(CinemaTypes.GOLD, sc.nextDouble());
				break;

			case 3:
				System.out.println("Current price is: "+ cinemaPriceMap.get(CinemaTypes.PLATINUM)+", Enter the platinum ticket price: ");
				cinemaPriceMap.put(CinemaTypes.PLATINUM, sc.nextDouble());
				break;
			}
			for(CinemaTypes theType: CinemaTypes.values()){
				System.out.println(theType.name()+ cinemaPriceMap.get(theType));
			}
			System.out.println();
	}

	/**
	 * Calculates the age price for a particular cinema, that is selected by the user (one of the factors used to calculate overall ticket price)
	 * @param agePriceMap the price mapping using which we calculate price associated with a particular age.
	 */
	public void tpage(EnumMap<AgeTypes, Double> agePriceMap) {
		//double student = 4.00, senior = 3.00, child = 2.00;
		int age_choice = 0;
		System.out.println("Which age group:");
		System.out.println("1.Child 2.Senior 3.Student");
		age_choice = sc.nextInt();
		switch (age_choice) {
		case 1:
			System.out.println("Current price is: "+ agePriceMap.get(AgeTypes.CHILD)+", Enter the child ticket price: ");
			agePriceMap.put(AgeTypes.CHILD, sc.nextDouble());
			break;

		case 2:
			System.out.println("Current price is: "+ agePriceMap.get(AgeTypes.SENIOR)+", Enter the senior ticket price: ");
			agePriceMap.put(AgeTypes.SENIOR, sc.nextDouble());
			break;

		case 3:
			System.out.println("Current price is: "+ agePriceMap.get(AgeTypes.STUDENT) +", Enter the student ticket price: ");
			agePriceMap.put(AgeTypes.STUDENT, sc.nextDouble());
			break;
		}
		for(AgeTypes theType: AgeTypes.values()){
        	System.out.println(theType.name()+ agePriceMap.get(theType));
        }
		System.out.println();
	}

	/**
	 * Calculates the day price for a particular cinema, that is selected by the user (one of the factors used to calculate overall ticket price)
	 * @param dayPriceMap the price mapping using which we calculate price associated with a particular day.
	 */
	public void tpday(EnumMap<DayTypes, Double> dayPriceMap) {
		// double weekdays = 4.00, weekends = 5.00, holidays = 6.00;
		int day_choice = 0;
		System.out.println("Which day:");
		System.out.println("1.Weekdays 2.Weekends 3.Holidays");
		day_choice = sc.nextInt();
		switch (day_choice) {
			case 1:
				System.out.println("Current price is: "+ dayPriceMap.get(DayTypes.WEEKDAY)+", Enter the weekday ticket price: ");
				dayPriceMap.put(DayTypes.WEEKDAY, sc.nextDouble());
				break;
			case 2:
				System.out.println("Current price is: "+ dayPriceMap.get(DayTypes.WEEKEND)+", Enter the weekend ticket price: ");
				dayPriceMap.put(DayTypes.WEEKEND, sc.nextDouble());
				break;
			case 3:
				System.out.println("Current price is: "+ dayPriceMap.get(DayTypes.HOLIDAY)+", Enter the holiday ticket price: ");
				dayPriceMap.put(DayTypes.HOLIDAY, sc.nextDouble());
				break;
			}
			for(DayTypes theType: DayTypes.values()){
				System.out.println(theType.name()+ dayPriceMap.get(theType));
			}
			System.out.println();
	}
}
