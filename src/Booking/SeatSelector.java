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
		while (true) {
			showSeats();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter seat choice");
			choice = sc.next();
			choice = choice.toUpperCase();
			// TODO : check for valid seat choice
			showSeats(choice);
			System.out.println("Confirm? (y/n):");
			String cfm = sc.next();
			if (cfm.toLowerCase().equals("y")) {
				break;
			}
		}
//		System.out.println("You selected " + choice);
		return choice;
	}
}
