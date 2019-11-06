package Booking;

import java.util.Scanner;

public class SeatSelector {
	public String choice;
	
	public void showSeats() {
		Integer rows = 10, cols = 10;
		Integer A = 65, Z = 90;
		// print column listing
		System.out.print("\t");
		for (Integer i = 0; i < cols; i += 1) {
			System.out.print(i.toString() + "\t");
		}
		System.out.println();
		// print row listing
		for (int i = A; (i < A + rows) && (A + rows <= Z); i++) {
			System.out.print(Character.toString((char) i) + "\t");
			for (int j = 0; j < cols; j += 1) {
				System.out.print("[]" + "\t");
			}
			System.out.println();
		}
	}

	// function overloading for showSeats [diff parameter]
	public void showSeats(String choice) {
		int rowChoice = (int) choice.charAt(0);
		int colChoice = Character.getNumericValue(choice.charAt(1));

		Integer rows = 10, cols = 10;
		Integer A = 65, Z = 90;
		// print column listing
		System.out.print("\t");
		for (Integer i = 0; i < cols; i += 1) {
			System.out.print(i.toString() + "\t");
		}
		System.out.println();
		// print row listing
		for (int i = A; (i < A + rows) && (A + rows <= Z); i++) {
			System.out.print(Character.toString((char) i) + "\t");
			for (int j = 0; j < cols; j += 1) {
				if (i == rowChoice && j == colChoice) {
					System.out.print("[*]" + "\t");
				} else {
					System.out.print("[]" + "\t");
				}
			}
			System.out.println();
		}
	}
	
	public String getSelectedSeat() {
		// TODO : add functionality of selecting multiple seats (if required)
		while (true) {
			showSeats();
			Scanner sc = new Scanner(System.in);
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
			showSeats(choice);
			System.out.println("Confirm? (y/n):");
			String cfm = sc.next();
			if (cfm.toLowerCase().equals("y")) {
				break;
			}
			sc.close();
		}
//		System.out.println("You selected " + choice);
		
		return choice;
	}
}
