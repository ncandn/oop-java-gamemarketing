public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws IllegalArgumentException {

		if (day < 1 || day > 31)
			throw new IllegalArgumentException("Invalid day.");
		else if (month < 1 || month > 31)
			throw new IllegalArgumentException("Invalid month.");
		else if (year < 0 || year > 2500)
			throw new IllegalArgumentException("Invalid year.");
		else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	public Date() {
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}
}
