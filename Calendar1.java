
public class Calendar1 {
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2; // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	/**
	 * Prints the calendars of all the years in the 20th century. Also prints the
	 * number of Sundays that occured on the first day of the month during this
	 * period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999,
		// inclusive.
		// Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday,
		// prints "Sunday".
		// The following variable, used for debugging purposes, counts how many days
		// were advanced so far.
		int x = Integer.parseInt(args[0]);
		int stop = 0;
		int dayInTheWeek = 2;
		int yearCounter = year;
		int monthCounter = month;
		int dayCounter = dayOfMonth;
		int amazing = 0;

		while ((yearCounter < 2000) && (stop < x)) {

			advance(dayCounter, monthCounter, yearCounter, dayInTheWeek);
			if (dayCounter < nDaysInMonth(monthCounter, yearCounter)) {
				dayCounter++;
				dayInTheWeek++;
			} else {
				dayCounter = 1;
				dayInTheWeek++;

				if (monthCounter != 12) {
					monthCounter++;
				} else {
					monthCounter = 1;
					yearCounter++;
				}

				if ((dayCounter == 1) && (dayInTheWeek == 1)) {
					amazing++;
				}

			}
			if (dayInTheWeek == 8) {
				dayInTheWeek = 1;
			}
			if ((dayCounter == 1) && (dayInTheWeek == 1)) {
				amazing++;
			}
			stop++;
		}
		System.out.println("During the 20th century, " + amazing + " Sundays fell on the first day of the month");
	}

	// Advances the date (day, month, year) and the day-of-the-week.
	// If the month changes, sets the number of days in this month.
	// Side effects: changes the static variables dayOfMonth, month, year,
	// dayOfWeek, nDaysInMonth.
	private static void advance(int dayCounter, int monthCounter, int yearCounter, int dayInTheWeek) {
		if (dayInTheWeek == 1) {
			System.out.println(dayCounter + "/" + monthCounter + "/" + yearCounter + " Sunday");
		} else
			System.out.println(dayCounter + "/" + monthCounter + "/" + yearCounter);

	}

	// Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		if (year % 4 == 0)
			return true;
		else
			return false;

	}

	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
			return 30;
		} else if (month == 2) {
			if ((year % 4 == 0) && (year == 1990)) {
				return 29;
			} else
				return 28;
		} else
			return 31;
	}
}
