import java.util.Calendar;

public class RentalAgreement {
	private static Calendar cal = Calendar.getInstance();
	
	public RentalAgreement(Tool theTool, int rentalDayCount, int discountPercent) {
		Tool aTool = theTool;
		
		
	}
	
	/*
	 * A weekend day is either Saturday or Sunday.
	 */
	public static boolean isWeekend(Calendar cal) {
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			return true;
		}
		return false;
	}
	
	
	/*
	 * July 4th - If falls on weekend, it is observed on the closest weekday.
	 * (if Sat, then Friday before, if Sunday, then Monday after)
	 */
	public static boolean isIndependanceDay(Calendar cal) {
		if (cal.get(Calendar.MONTH) == Calendar.JULY && cal.get(Calendar.DAY_OF_MONTH) == 4) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * First Monday in September.
	 */
	public static boolean isLaborDay(Calendar cal) {
		if (cal.get(Calendar.MONTH) == Calendar.SEPTEMBER && cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 && cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return true;
		}
		return false;
	}

}
