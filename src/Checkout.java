import java.util.*;

public class Checkout{
	
	//global calendar instance
	private static Calendar cal = Calendar.getInstance();
	private static Date d = new Date();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String requestedToolCode = "";
		Tool requestedTool = new Tool();
		boolean inList = false;
		int daysRequested = -1;
		int discountPercent = -1;
		
		//adds required tools to Inventory list
		Inventory.addTool("LADW", new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false));
		Inventory.addTool("CHNS", new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true));
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
		Inventory.addTool("JAKD", new Tool("Jackhammer", "DeWalt", "JAKD", 2.99, true, false, false));
		
		
		for (Map.Entry<String,Tool> entry : Inventory.toolList.entrySet()) {
			entry.getValue().printAttributes();
			System.out.println("");
		}
		
		//prompts user for input
		do {
			System.out.println("Enter tool code: ");
			if(in.hasNext()) {
				requestedToolCode = in.next();
			}
			inList = Inventory.toolList.containsKey(requestedToolCode);
			if (!inList) {
				System.out.println("Tool code: " + requestedToolCode + " is not valid. Please try again.");
			}
			else {
				requestedTool = Inventory.toolList.get(requestedToolCode);
			}
		} while(!inList);
		do {
			System.out.println("Enter number of days for rental: ");
			if(in.hasNextInt()) {
				daysRequested = in.nextInt();
			}
			if (daysRequested < 0) {
				System.out.println("Invalid entry. Please enter a value > 0.");
			}
		} while (daysRequested < 0);
		do {
			System.out.println("Enter discount amount: ");
			if(in.hasNextInt()) {
				discountPercent = in.nextInt();
			}
			if (discountPercent > 100 || discountPercent < 0) {
				System.out.println("Invalid entry. Please enter a value 0 to 100.");
			}
		} while (discountPercent > 100 || discountPercent < 0);
		
		checkout(requestedTool, daysRequested, discountPercent);
		
		
	}
	
	
	
	/*
	 * Checks out tool and produces a Rental Agreement.
	 */
	public static RentalAgreement checkout(Tool toolCode, int rentalDayCount, int discountPercent) {
		RentalAgreement ra = new RentalAgreement();
		
		return ra;
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
