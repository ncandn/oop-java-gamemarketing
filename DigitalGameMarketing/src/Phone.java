
public class Phone {
	private String countrycode;
	private int citycode;
	private int number;
	private String type;

	public Phone(String countrycode, int citycode, int number, String type) throws IllegalArgumentException {
		if (9999999 < number || number < 1000000)
			throw new IllegalArgumentException("Invalid number!");
		else {
			this.countrycode = countrycode;
			this.citycode = citycode;
			this.number = number;
			this.type = type;
		}
	}

	public Phone(int citycode, int number, String type) throws IllegalArgumentException {
		if (9999999 < number || number < 1000000)
			throw new IllegalArgumentException("Invalid number!");
		else {
			this.countrycode = "+90";
			this.citycode = citycode;
			this.number = number;
			this.type = type;
		}

	}

	public int getCitycode() {
		return citycode;
	}

	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Phone [countrycode=" + countrycode + ", citycode=" + citycode + ", number=" + number + ", type= " + type
				+ "]";
	}

}
