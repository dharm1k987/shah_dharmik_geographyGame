package shah_dharmik_geographyGame;

import java.util.Scanner;

public class ProvinceGameDriver {

	public static void main(String[] args) {

		welcomeMessage();
		Scanner in = new Scanner(System.in);
		String answer = "y";
		while (answer.equals("y")) {
			Game game1 = new Game();

			if (!game1.getFileStatus()) {
				System.out
						.println("Please locate the file and try to play again after.");
				answer = "n";
			} else {
				answer = inputChecker(in);
			}

		}

	}

	private static String inputChecker(Scanner in) {

		System.out.print("\n\nWould you like to play again (y/n): ");
		String temp = in.nextLine();

		while ((!temp.equalsIgnoreCase("y")) && (!temp.equalsIgnoreCase("n"))) {
			System.out.print("Sorry this input is invalid. Please try again: ");
			temp = in.nextLine();
		}
		System.out.println("\n\n");
		if (temp.equalsIgnoreCase("y")) {
			welcomeMessage();
		} else {
			System.out.println("Okay thank you for playing!");
		}
		return temp;

	}

	private static void welcomeMessage() {
		System.out.println("***********************");
		System.out.println("Canadian Geography Game");
		System.out.println("***********************");
	}

}
