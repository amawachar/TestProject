package utilsClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsDate {

	public static String getCurrentDay() {
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
		return dayFormat.format(new Date());
	}

	// Method to return the current month as a String
	public static String getCurrentMonth() {
		SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
		return monthFormat.format(new Date());
	}

	// Method to return the current year as a String
	public static String getCurrentYear() {
		SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
		return yearFormat.format(new Date());
	}

	// Method to return the formatted timestamp
	public static String getFormattedTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dateFormat.format(new Date());
	}

}
