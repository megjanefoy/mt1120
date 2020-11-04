import java.util.*;

public class Tool{
	String toolType;
	String toolBrand;
	String toolCode;
	double dailyCharge;
	boolean weekdayCharge;
	boolean weekendCharge;
	boolean holidayCharge;

	public Tool() {
		
	}
	
	public Tool(String type, String brand, String code, double charge, boolean weekday, boolean weekend, boolean holiday) {
		this.toolType = type;
		this.toolBrand = brand;
		this.toolCode = code;
		this.dailyCharge = charge;
		this.weekdayCharge = weekday;
		this.weekendCharge = weekend;
		this.holidayCharge = holiday;
	}
	
	public void printAttributes() {
		System.out.println("Tool type is: " + toolType);
		System.out.println("Tool brand is: " + toolBrand);
		System.out.println("Tool code is: " + toolCode);
		System.out.println("Tool charge is: $" + dailyCharge);
		System.out.println("Tool weekdayCharge is: " + weekdayCharge);
		System.out.println("Tool weekendCharge is: " + weekendCharge);
		System.out.println("Tool holidayCharge is: " + holidayCharge);
	}

}
