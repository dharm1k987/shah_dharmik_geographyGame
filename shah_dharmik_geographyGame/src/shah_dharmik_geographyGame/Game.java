package shah_dharmik_geographyGame;

import java.io.*;
import java.util.*;

public class Game {
	private boolean fileExists = true;
	private ArrayList<ProvinceTerritory> places = new ArrayList<ProvinceTerritory>();
	Scanner in = new Scanner(System.in);

	/**
	 * Constructor that calls the readFile() method
	 */
	public Game() {
		readFile();
	}

	/**
	 * Reads the file and creates instances of the class ProvinceTerritory to
	 * store in ArrayList
	 */
	public void readFile() {

		String dir = System.getProperty("user.dir");
		String fileName = dir + "\\places.csv";

		File x = new File(fileName);
		try {
			Scanner inFile = new Scanner(x);

			while (inFile.hasNextLine()) {
				String line = inFile.nextLine();
				StringTokenizer stk = new StringTokenizer(line, ",");
				String provinceTerritoryName = stk.nextToken();
				String capitalName = stk.nextToken();
				ProvinceTerritory location = new ProvinceTerritory(
						provinceTerritoryName, capitalName);
				places.add(location);

			}
			int sizeBeforeDeletion = places.size();
			playGame(sizeBeforeDeletion);
			inFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found.");
			fileExists = false;

		}

	}

	/**
	 * Chooses a random province/territory and displays it to the user. Checks
	 * if capital is right or wrong
	 * 
	 * @param sizeBeforeDeletion
	 *            is he original size of the ArrayList before modified
	 */
	public void playGame(int sizeBeforeDeletion) {
		
		Random rand = new Random();
		int score = 0;

		while (places.size() != 0) {

			int randomValue = rand.nextInt(places.size());

			System.out.printf("What is the capital of %s: ",
					places.get(randomValue).getProvinceTerritory());
			String answer = new String(in.nextLine());
			if (places.get(randomValue).correct(answer)) {
				System.out.print("Correct!");
				score++;
			} else {
				System.out.printf("Incorrect. The capital is %s.",
						places.get(randomValue).getCapital());
			}
			System.out.println("\n");

			places.remove(randomValue);

		}

		viewOutcome(score, sizeBeforeDeletion);
		

	}

	/**
	 * Checks to see how the user did
	 * 
	 * @param score
	 *            stores the number of correct capital answers the user gave
	 * @param sizeBeforeDeletion
	 *            is he original size of the ArrayList before modified
	 */
	public void viewOutcome(int score, int sizeBeforeDeletion) {
		System.out.printf("You got %d/%d points.", score, sizeBeforeDeletion);
		if (score == sizeBeforeDeletion) {
			System.out
					.println("You got a perfect score. You know your geography well.");
		}

		else if (score >= sizeBeforeDeletion - 4) {
			System.out
					.println("You know your geography, but there is still chance for improvement.");
		}

		else {
			System.out
					.println("You need to practise a lot more to perfect  your geography.");
		}
	}

	/**
	 * Accessor method
	 * 
	 * @return fileExists (true/false)
	 */
	public boolean getFileStatus() {
		return fileExists;
	}

}
