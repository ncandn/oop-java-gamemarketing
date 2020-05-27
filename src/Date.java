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
		this.day = 1;
		this.month = 1;
		this.year = 2020;

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

	
	
	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String tempString = "";
		
		if((String.valueOf(year)).length() == 1)
		{
			tempString += "0";
		}
		tempString += year + "-";
		
		if((String.valueOf(month)).length() == 1)
		{
			tempString += "0";
		}
	    tempString += month + "-";
		
		if((String.valueOf(day)).length() == 1)
		{
			tempString += "0";
		}
	   tempString += day;
		
		return tempString;
	}
	
	
	
}
