import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Checkout{
	
	//global scanner instance
	private static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		Date date = new Date();
		Tool requestedTool = new Tool();
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
		requestedTool = getTool();
		daysRequested = getDayCount();
		discountPercent = getDiscount();
		date = getDate();
		
		//checks out product
				checkout(requestedTool, daysRequested, discountPercent, date);	
				
	}
	
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
		
	
	public static Date getDate() {	
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		formatter.setLenient(false);
		String inputDate = "";
		
		
		try { 
			System.out.println("Enter start date: ");
			if(in.hasNextLine()) {
				inputDate = in.nextLine();
				date = formatter.parse(inputDate);
			}
			else {
				throw new Exception();
			}
		} catch (ParseException e) {
			System.out.println("Invalid entry. Please enter date format as MM/DD/YY");
			getDate();
		} catch (Exception e) {
			System.out.println("Invalid entry. Please enter date format as MM/DD/YY");
			getDate();
		}
		
		return date;
	}

	
	
	/*
	 * Checks out tool and produces a Rental Agreement.
	 */
	public static RentalAgreement checkout(Tool theTool, int rentalDayCount, int discountPercent, Date theDate) {
		RentalAgreement ra = new RentalAgreement(theTool, rentalDayCount, discountPercent);
		
		return ra;
	}
	
		
}
