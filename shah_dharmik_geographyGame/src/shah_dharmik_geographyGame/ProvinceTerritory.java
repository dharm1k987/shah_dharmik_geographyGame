package shah_dharmik_geographyGame;

public class ProvinceTerritory {
	private String provinceTerritory;
	private String capital;

	/**
	 * Constructor. Initializes two variables.
	 * 
	 * @param provinceTerritory
	 *            is the province/territory in the file
	 * @param capital
	 *            is the capital that is beside the province/territory in the
	 *            file
	 */
	public ProvinceTerritory(String provinceTerritory, String capital) {
		this.provinceTerritory = provinceTerritory;
		this.capital = capital;

	}

	/**
	 * Accessor method
	 * 
	 * @return the province/territory
	 */
	public String getProvinceTerritory() {
		return provinceTerritory;
	}

	/**
	 * Accessor method
	 * 
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * Checks to see if the user supplied answer is correct
	 * 
	 * @param answer
	 *            is the variable the user has provided input into
	 * @return true or false
	 */
	public boolean correct(String answer) {

		if (answer.equalsIgnoreCase(capital)) {
			return true;
		}
		return false;
	}

}
