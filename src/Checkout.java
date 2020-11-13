import java.util.*;

public class Checkout{
	
	//scanner instance
	private static Scanner in = new Scanner(System.in);
	
	
	/*
	 * Main Method.
	 */
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		Tool requestedTool = new Tool();
		int daysRequested = -1;
		int discountPercent = -1;
		
		//adds required tools to Inventory list
		Inventory.addTool("LADW", new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false));
		Inventory.addTool("CHNS", new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true));
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
		Inventory.addTool("JAKD", new Tool("Jackhammer", "DeWalt", "JAKD", 2.99, true, false, false));
		
		//prompts user for input
		requestedTool = getTool();
		daysRequested = getDayCount();
		discountPercent = getDiscount();
		date = getDate();
		
		//checks out product
		checkout(requestedTool, daysRequested, discountPercent, date);		
	}
	
	
	/*
	 * Gets requested Tool object.
	 */
	public static Tool getTool() {
		boolean inList = false;
		Tool reqTool = new Tool();
		String inputToolCode = "";
		
		try {
			System.out.println("Enter tool code: ");
			if(in.hasNext()) {
				inputToolCode = in.next();
			}
			inList = Inventory.toolList.containsKey(inputToolCode);
			if (inList) {
				reqTool = Inventory.toolList.get(inputToolCode);
			}
			else {
				throw new Exception();
			}
		} catch(Exception e) {
			System.out.println("Invalid tool coode. Please try again.");
			getTool();
		}
		
		return reqTool;
	}
		
		
	/*
	 * Gets requested rental day count.
	 */
	public static int getDayCount() {
		int inputNumDays = 0;

		try {
			System.out.println("Enter number of days for rental: ");
			if(in.hasNextInt()) {
				inputNumDays = in.nextInt();
			}
			if (inputNumDays <= 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid entry. Please enter a value > 0.");
			getDayCount();
		}
		
		return inputNumDays;
	}
		
	
	/*
	 * Gets discount amount.
	 */
	public static int getDiscount() {
		int inputDiscount = 0;
		
		try {
			System.out.println("Enter discount amount: ");
			if(in.hasNextInt()) {
				inputDiscount = in.nextInt();
			}
			if (inputDiscount > 100 || inputDiscount < 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid entry. Please enter value 0 to 100.");
			getDiscount();
		}
		
		return inputDiscount;
	}
		
	
	/*
	 * Gets start date of rental.
	 */
	public static Calendar getDate() {	
		Scanner input = new Scanner(System.in);
		Calendar date = Calendar.getInstance();
		String inputDate = "";
		
		System.out.println("Enter start date: ");
		if(input.hasNextLine()) {
			inputDate = input.nextLine();
			String[] arr = inputDate.split("/"); 
			int theMonth = (int) Integer.parseInt(arr[0]);
			int theDate = (int) Integer.parseInt(arr[1]);
			int theYear = (int) Integer.parseInt(arr[2]) %100;
			
			if (theMonth >= 1 && theMonth <= 12) {
				date.set(Calendar.MONTH, theMonth-1);
			}
			else {
				System.out.println("Invalid month. Please enter date format as MM/DD/YY");
				getDate();
			}
			if (theDate >= 1 || theDate <= 31) {
				date.set(Calendar.DATE, theDate);
			}
			else {
				System.out.println("Invalid date. Please enter date format as MM/DD/YY");
				getDate();
			}
			if(theYear >= 0 || theYear <= (date.get(Calendar.YEAR)%100)) {
				date.set(Calendar.YEAR, theYear);
			}
			else {
				System.out.println("Invalid year. Please enter date format as MM/DD/YY");
				getDate();
			}
		}
		else {
			System.out.println("Invalid entry. Please enter date format as MM/DD/YY");
			getDate();
		}

		return date;
	}

	
	
	/*
	 * Checks out tool and produces/print a Rental Agreement.
	 */
	public static void checkout(Tool theTool, int rentalDayCount, int discountPercent, Calendar theDate) {
		RentalAgreement ra = new RentalAgreement(theTool, rentalDayCount, discountPercent, theDate);
		ra.printRentalAgreement();
		System.out.println("");
	}
	
		
}
