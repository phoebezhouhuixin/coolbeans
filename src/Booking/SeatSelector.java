package Booking;

import java.util.ArrayList;
import java.util.Scanner;

public class SeatSelector {
	/**
	 * keeps track of current seat chosen by user, if any.
	 */
	public String choice;
	Scanner sc = new Scanner(System.in);
	/**
	 * keeps track of previously chosen seats by user, if any.
	 */
	private ArrayList<String> seatsChosenList;
	
	/**
	 * Constructor 
	 * @param seatsChosenList keeps track of previously chosen seats by user, if any. 
	 */
	public SeatSelector(ArrayList<String> seatsChosenList) {
		this.seatsChosenList =seatsChosenList; 
	}
	
	/**
	 * Shows the seat selection menu, along with currently chosen seats
	 */
	public void showSeats() {
		Integer rows = 10, cols = 10;
		Integer A = 65, Z = 90;
		// print column listing
		System.out.print("\t");
		for (Integer i = 0; i < cols; i += 1) {
			if(i==4){
				System.out.print(i.toString() + "\t\t");
			}
			else{
				System.out.print(i.toString() + "\t");
			}
		}
		System.out.println();
		// print row listing
		for (int i = A; (i < A + rows) && (A + rows <= Z); i++) {
			System.out.print(Character.toString((char) i) + "\t");
			for (int j = 0; j < cols; j += 1) {
				for (String choice : this.seatsChosenList) {
					int rowChoice = (int) choice.charAt(0);
					int colChoice = Character.getNumericValue(choice.charAt(1));
					if (i == rowChoice && j == colChoice) {
						if (j == 4)
							System.out.print("[*]" + "\t\t");
						else
							System.out.print("[*]" + "\t");
						j+=1;
					}
				}
				if(j==4){
					System.out.print("[]" + "\t\t");
				}
				else{
					System.out.print("[]" + "\t");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Gets Seat of choice from the user, via prompts.
	 * Also performs error checking on validity of choice.
	 * @return
	 */
	public String getSelectedSeat() {
		while (true) {
			showSeats();			
			System.out.println("Enter seat choice");
			choice = sc.next();
			choice = choice.toUpperCase();
			//check for valid seat choice
			if (choice.charAt(0)<'A' || choice.charAt(0)>'Z'){
				System.out.println("Re-enter choice with rows between A to Z");
				choice = sc.next();
				choice = choice.toUpperCase();
			}
			else if (choice.charAt(1)<'0' ||choice.charAt(1)>'9'){
				System.out.println("Re-enter choice with rows between A to Z");
				choice = sc.next();
				choice = choice.toUpperCase();
			}
			this.seatsChosenList.add(choice);
			showSeats();
			System.out.println("Confirm? (y/n):");
			String cfm = sc.next();
			if (cfm.toLowerCase().equals("y")) {
				break;
			}
			else {
				this.seatsChosenList.remove(this.seatsChosenList.size()-1);
			}
		}
//		System.out.println("You selected " + choice);
		
		return choice;
	}
}
