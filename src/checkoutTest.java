import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.*;


public class checkoutTest {
	static SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yy");
	
    @Test
    public void getToolTest() {
    	Inventory.addTool("LADW", new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false));
		Inventory.addTool("CHNS", new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true));
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
		Inventory.addTool("JAKD", new Tool("Jackhammer", "DeWalt", "JAKD", 2.99, true, false, false));
		
    	String toolCode1 = "LADW";
    	String toolCode2 = "CHNS";
    	String toolCode3 = "JAKR";
    	String toolCode4 = "JAKD";
    	String toolCode5 = "NOPE";
    	
    	boolean bool1 = Inventory.toolList.containsKey(toolCode1);
    	boolean bool2 = Inventory.toolList.containsKey(toolCode2);
    	boolean bool3 = Inventory.toolList.containsKey(toolCode3);
    	boolean bool4 = Inventory.toolList.containsKey(toolCode4);
    	boolean bool5 = Inventory.toolList.containsKey(toolCode5);
    	
    	assertEquals(true, bool1);
    	assertEquals(true, bool2);
    	assertEquals(true, bool3);
    	assertEquals(true, bool4);
    	assertEquals(false, bool5);
    	
    	Tool tool1 = Inventory.toolList.get(toolCode1);
    	Tool tool2 = Inventory.toolList.get(toolCode2);
    	Tool tool3 = Inventory.toolList.get(toolCode3);
    	Tool tool4 = Inventory.toolList.get(toolCode4);

    	assertEquals("Werner", tool1.toolBrand);
    	assertEquals("Stihl", tool2.toolBrand);
    	assertEquals("Ridgid", tool3.toolBrand);
    	assertEquals("DeWalt", tool4.toolBrand);
    }
    
    
    @Test
    public void checkoutTest1() {
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
    	Tool tool3 = Inventory.toolList.get("JAKR");
    	Calendar date1 = Calendar.getInstance();	
    	date1.set(2015, 8, 3);
    	RentalAgreement ra1 = new RentalAgreement(tool3, 5, 101, date1);

    	assertEquals("JAKR", ra1.theTool.toolCode);
    	String checkoutStr = sf.format(ra1.checkoutDate.getTime());
    	boolean strComp = checkoutStr.compareTo("09/03/15") == 0;
    	assertEquals(true, strComp);
    	assertEquals(5, ra1.rentalDayCount);
    	assertEquals(101, ra1.discountPercent);
    }

    
    @Test
    public void checkoutTest2() {
    	Inventory.addTool("LADW", new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false));	
		Tool tool1 = Inventory.toolList.get("LADW");
    	Calendar date2 = Calendar.getInstance();
    	date2.set(2020, 6, 2);
    	RentalAgreement ra2 = new RentalAgreement(tool1, 3, 10, date2);

    	assertEquals("LADW", ra2.theTool.toolCode);
    	String checkoutStr = sf.format(ra2.checkoutDate.getTime());
    	boolean strComp = checkoutStr.compareTo("07/02/20") == 0;
    	assertEquals(true, strComp);
    	assertEquals(3, ra2.rentalDayCount);
    	assertEquals(10, ra2.discountPercent);
    }

    
    @Test
    public void checkoutTest3() {
		Inventory.addTool("CHNS", new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true));
    	Tool tool2 = Inventory.toolList.get("CHNS");
    	Calendar date3 = Calendar.getInstance();
    	date3.set(2015, 6, 2);
    	RentalAgreement ra3 = new RentalAgreement(tool2, 5, 25, date3);

    	assertEquals("CHNS", ra3.theTool.toolCode);
    	String checkoutStr = sf.format(ra3.checkoutDate.getTime());
    	boolean strComp = checkoutStr.compareTo("07/02/15") == 0;
    	assertEquals(true, strComp);
    	assertEquals(5, ra3.rentalDayCount);
    	assertEquals(25, ra3.discountPercent);
    }

    
    @Test
    public void checkoutTest4() {
		Inventory.addTool("JAKD", new Tool("Jackhammer", "DeWalt", "JAKD", 2.99, true, false, false));
    	Tool tool4 = Inventory.toolList.get("JAKD");
    	Calendar date4 = Calendar.getInstance();
    	date4.set(2015, 8, 3);
    	RentalAgreement ra4 = new RentalAgreement(tool4, 6, 0, date4);

    	assertEquals("JAKD", ra4.theTool.toolCode);
    	String checkoutStr = sf.format(ra4.checkoutDate.getTime());
    	boolean strComp = checkoutStr.compareTo("09/03/15") == 0;
    	assertEquals(true, strComp);
    	assertEquals(6, ra4.rentalDayCount);
    	assertEquals(0, ra4.discountPercent);
    }

    
    @Test
    public void checkoutTest5() {
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
    	Tool tool3 = Inventory.toolList.get("JAKR");
    	Calendar date5 = Calendar.getInstance();
    	date5.set(2015, 6, 2);
    	RentalAgreement ra5 = new RentalAgreement(tool3, 9, 0, date5);

    	assertEquals("JAKR", ra5.theTool.toolCode);
    	String checkoutStr = sf.format(ra5.checkoutDate.getTime());
    	boolean strComp = checkoutStr.compareTo("07/02/15") == 0;
    	assertEquals(true, strComp);
    	assertEquals(9, ra5.rentalDayCount);
    	assertEquals(0, ra5.discountPercent);
    }

    
    @Test
    public void checkoutTest6() {
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
    	Tool tool3 = Inventory.toolList.get("JAKR");
    	Calendar date6 = Calendar.getInstance();
    	date6.set(2020, 6, 2);
    	RentalAgreement ra6 = new RentalAgreement(tool3, 4,50, date6);

    	assertEquals("JAKR", ra6.theTool.toolCode);
    	String checkoutStr = sf.format(ra6.checkoutDate.getTime());
    	boolean strComp = checkoutStr.compareTo("07/02/20") == 0;
    	assertEquals(true, strComp);
    	assertEquals(4, ra6.rentalDayCount);
    	assertEquals(50, ra6.discountPercent);
    }

}

