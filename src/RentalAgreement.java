import java.util.*;
import java.text.*;


public class RentalAgreement {
	static SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yy");
	static Calendar checkoutDate = Calendar.getInstance();
	static Calendar dueDate = Calendar.getInstance();
	static Tool theTool = new Tool();
	static int rentalDayCount = -1;
	static int discountPercent = -1;
	static int chargeableDays = -1;
	static double prediscountCharge = 0.0;
	static double discountAmount = 0.0;
	static double finalAmount = 0.0;
	
	public RentalAgreement(Tool aTool, int dayCount, int discPercent, Calendar aDate) {
		checkoutDate = (Calendar) aDate.clone();
		dueDate = (Calendar) aDate.clone();
		dueDate.add(Calendar.DATE, dayCount);
		theTool = aTool;
		rentalDayCount = dayCount;
		discountPercent = discPercent;
		chargeableDays = calculateChargeableDays();
		prediscountCharge = calculatePrediscountCharge();
		discountAmount = calculateDiscountAmount();
		finalAmount = calculateFinalAmount();
	}
	
	
	/*
	 * Prints Rental Agreement information
	 */
	public void printRentalAgreement() {
		System.out.println("Tool Code: " + theTool.toolCode);
		System.out.println("Tool Type: " + theTool.toolType);
		System.out.println("Tool Brand: " + theTool.toolBrand);
		System.out.println("Rental Days: " + rentalDayCount);
		System.out.println("Checkout Date: " + sf.format(checkoutDate.getTime()));
		System.out.println("Due Date: " + sf.format(dueDate.getTime()));
		System.out.println("Daily Rental Charge: $" + theTool.dailyCharge);
		System.out.println("Charge Days: " + chargeableDays);
		System.out.println("Pre-Discount Charge: $" + String.format("%.2f", prediscountCharge));
		System.out.println("Discount Percent: " + discountPercent + "%");
		System.out.println("Discount Amount: $" + String.format("%.2f", discountAmount));
		System.out.println("Final Charge: $" + String.format("%.2f", finalAmount));
		
		
	}
	
	
	/*
	 * Calculates final charge.
	 */
	public static double calculateFinalAmount() {
		double finalAmnt = prediscountCharge - discountAmount;
//		String finalStr = String.format("%.2f", finalAmnt);
//		finalAmnt = Double.parseDouble(finalStr);
		
		if(finalAmnt < 0.0) {
			finalAmnt = 0.0;
		}
		
		return finalAmnt;
	}
	
	
	/*
	 * Calculates discount amount.
	 */
	public static double calculateDiscountAmount() {
		double discountAmnt = prediscountCharge * (double)(discountPercent/100.0);
		String discountStr = String.format("%.2f", discountAmnt);
		discountAmnt = Double.parseDouble(discountStr);
		
		return discountAmnt;
	}
	
	
	/*
	 * Calculates pre-discount charge.
	 */
	public static double calculatePrediscountCharge() {
		double prediscountAmt = 0.0;
		prediscountAmt = chargeableDays * theTool.dailyCharge;
		String prediscountStr = String.format("%.2f", prediscountAmt);
		prediscountAmt = Double.parseDouble(prediscountStr);
		
		return prediscountAmt;
	}
	
	
	/*
	 * Calculates chargeable days.
	 */
	public static int calculateChargeableDays() {
		Calendar checkDate = (Calendar) checkoutDate.clone();
		int numChargeableDays = rentalDayCount;
		
		for(int i = 0; i < rentalDayCount; ++i) {
			checkDate.add(Calendar.DATE, 1);
			if(!theTool.weekendCharge && isWeekend(checkDate)) {
				--numChargeableDays;
			}
			else if(!theTool.holidayCharge && (isIndependenceDay(checkDate) || isLaborDay(checkDate))){
				--numChargeableDays;
			}
		}
		if(numChargeableDays < 0) {
			numChargeableDays = 0;
		}
		
		return numChargeableDays;
	}
	
	
	/*
	 * Checks if date falls on the weekend.
	 * (A weekend day being either Saturday or Sunday)
	 */
	public static boolean isWeekend(Calendar cal) {
		if((cal.get(Calendar.DAY_OF_WEEK) == 1) || (cal.get(Calendar.DAY_OF_WEEK) == 7)){
			return true;
		}
		return false;
	}
	
	
	/*
	 * Checks if date falls on Independence Day.
	 * If falls on weekend, it is observed on the closest weekday.
	 * (if Saturday, then Friday before; if Sunday, then Monday after)
	 */
	public static boolean isIndependenceDay(Calendar cal) {
		Calendar observed = Calendar.getInstance();
		observed.set(Calendar.MONTH, 6);
		observed.set(Calendar.DATE, 4);
		observed.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		
		
		switch(observed.get(Calendar.DAY_OF_WEEK)){
			//Saturday
			case 7:
				observed.set(Calendar.DATE, 3);
				break;
			//Sunday
			case 1: 
				observed.set(Calendar.DATE, 5);
				break;
			//Weekday
			default : 
				break;
        }
		
		if (cal.get(Calendar.MONTH) == Calendar.JULY && cal.get(Calendar.DATE) == observed.get(Calendar.DATE)) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * Checks if date falls on Labor Day.
	 * (First Monday in September)
	 */
	public static boolean isLaborDay(Calendar cal) {
		if (cal.get(Calendar.MONTH) == Calendar.SEPTEMBER && cal.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 && cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
			return true;
		}
		return false;
	}

}
