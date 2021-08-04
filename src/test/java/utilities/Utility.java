package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Utility {
	
	public String  getCurrentDate(String format) throws ParseException {
		String currentDate = LocalDate.now().toString();
		
		SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = oldFormat.parse(currentDate);
//		SimpleDateFormat newFormat = new SimpleDateFormat("MM-dd-yyyy");
		SimpleDateFormat newFormat = new SimpleDateFormat(format);
		String dateFormatted = newFormat.format(date);
		return dateFormatted;
	}
}