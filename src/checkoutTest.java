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
    	String checkoutStr = sf.format(ra1.checkoutDate.getTime());
    	String dueStr = sf.format(ra1.dueDate.getTime());
    	boolean strComp1 = checkoutStr.compareTo("09/03/15") == 0;
    	boolean strComp2 = dueStr.compareTo("09/08/15") == 0;
    	boolean compResult1 = Double.compare(2.99, ra1.theTool.dailyCharge) == 0;
    	boolean compResult2 = Double.compare(5.98, ra1.prediscountCharge) == 0;
    	boolean compResult3 = Double.compare(6.04, ra1.discountAmount) == 0;
    	boolean compResult4 = Double.compare(0.00, ra1.finalAmount) == 0;

    	assertEquals("JAKR", ra1.theTool.toolCode);
    	assertEquals("Jackhammer", ra1.theTool.toolType);
    	assertEquals("Ridgid", ra1.theTool.toolBrand);
    	assertEquals(5, ra1.rentalDayCount);
    	assertEquals(true, strComp1);
    	assertEquals(true, strComp2);
		assertEquals(true, compResult1);
		assertEquals(2, ra1.chargeableDays);
		assertEquals(true, compResult2);
    	assertEquals(101, ra1.discountPercent);
    	assertEquals(true, compResult2);
    	assertEquals(true, compResult3);
    }

    
    @Test
    public void checkoutTest2() {
    	Inventory.addTool("LADW", new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false));	
		Tool tool1 = Inventory.toolList.get("LADW");
    	Calendar date2 = Calendar.getInstance();
    	date2.set(2020, 6, 2);
    	RentalAgreement ra2 = new RentalAgreement(tool1, 3, 10, date2);
    	String checkoutStr = sf.format(ra2.checkoutDate.getTime());
    	String dueStr = sf.format(ra2.dueDate.getTime());
    	boolean strComp1 = checkoutStr.compareTo("07/02/20") == 0;
    	boolean strComp2 = dueStr.compareTo("07/05/20") == 0;
    	boolean compResult1 = Double.compare(1.99, ra2.theTool.dailyCharge) == 0;
    	boolean compResult2 = Double.compare(3.98, ra2.prediscountCharge) == 0;
    	boolean compResult3 = Double.compare(0.40, ra2.discountAmount) == 0;
    	boolean compResult4 = Double.compare(3.58, ra2.finalAmount) == 0;

    	assertEquals("LADW", ra2.theTool.toolCode);
    	assertEquals("Ladder", ra2.theTool.toolType);
    	assertEquals("Werner", ra2.theTool.toolBrand);
    	assertEquals(3, ra2.rentalDayCount);
    	assertEquals(true, strComp1);
    	assertEquals(true, strComp2);
		assertEquals(true, compResult1);
		assertEquals(2, ra2.chargeableDays);
		assertEquals(true, compResult2);
    	assertEquals(10, ra2.discountPercent);
    	assertEquals(true, compResult2);
    	assertEquals(true, compResult3);
    }

    
    @Test
    public void checkoutTest3() {
		Inventory.addTool("CHNS", new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true));
    	Tool tool2 = Inventory.toolList.get("CHNS");
    	Calendar date3 = Calendar.getInstance();
    	date3.set(2015, 6, 2);
    	RentalAgreement ra3 = new RentalAgreement(tool2, 5, 25, date3);
    	String checkoutStr = sf.format(ra3.checkoutDate.getTime());
    	String dueStr = sf.format(ra3.dueDate.getTime());
    	boolean strComp1 = checkoutStr.compareTo("07/02/15") == 0;
    	boolean strComp2 = dueStr.compareTo("07/07/15") == 0;
    	boolean compResult1 = Double.compare(1.49, ra3.theTool.dailyCharge) == 0;
    	boolean compResult2 = Double.compare(4.47, ra3.prediscountCharge) == 0;
    	boolean compResult3 = Double.compare(1.12, ra3.discountAmount) == 0;
    	boolean compResult4 = Double.compare(3.35, ra3.finalAmount) == 0;

    	assertEquals("CHNS", ra3.theTool.toolCode);
    	assertEquals("Chainsaw", ra3.theTool.toolType);
    	assertEquals("Stihl", ra3.theTool.toolBrand);
    	assertEquals(5, ra3.rentalDayCount);
    	assertEquals(true, strComp1);
    	assertEquals(true, strComp2);
		assertEquals(true, compResult1);
		assertEquals(3, ra3.chargeableDays);
		assertEquals(true, compResult2);
    	assertEquals(25, ra3.discountPercent);
    	assertEquals(true, compResult2);
    	assertEquals(true, compResult3);
    }

    
    @Test
    public void checkoutTest4() {
		Inventory.addTool("JAKD", new Tool("Jackhammer", "DeWalt", "JAKD", 2.99, true, false, false));
    	Tool tool4 = Inventory.toolList.get("JAKD");
    	Calendar date4 = Calendar.getInstance();
    	date4.set(2015, 8, 3);
    	RentalAgreement ra4 = new RentalAgreement(tool4, 6, 0, date4);
    	String checkoutStr = sf.format(ra4.checkoutDate.getTime());
    	String dueStr = sf.format(ra4.dueDate.getTime());
    	boolean strComp1 = checkoutStr.compareTo("09/03/15") == 0;
    	boolean strComp2 = dueStr.compareTo("09/09/15") == 0;
    	boolean compResult1 = Double.compare(2.99, ra4.theTool.dailyCharge) == 0;
    	boolean compResult2 = Double.compare(8.97, ra4.prediscountCharge) == 0;
    	boolean compResult3 = Double.compare(0.00, ra4.discountAmount) == 0;
    	boolean compResult4 = Double.compare(8.97, ra4.finalAmount) == 0;

    	assertEquals("JAKD", ra4.theTool.toolCode);
    	assertEquals("Jackhammer", ra4.theTool.toolType);
    	assertEquals("DeWalt", ra4.theTool.toolBrand);
    	assertEquals(6, ra4.rentalDayCount);
    	assertEquals(true, strComp1);
    	assertEquals(true, strComp2);
		assertEquals(true, compResult1);
		assertEquals(3, ra4.chargeableDays);
		assertEquals(true, compResult2);
    	assertEquals(0, ra4.discountPercent);
    	assertEquals(true, compResult2);
    	assertEquals(true, compResult3);
    }

    
    @Test
    public void checkoutTest5() {
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
    	Tool tool3 = Inventory.toolList.get("JAKR");
    	Calendar date5 = Calendar.getInstance();
    	date5.set(2015, 6, 2);
    	RentalAgreement ra5 = new RentalAgreement(tool3, 9, 0, date5);
    	String checkoutStr = sf.format(ra5.checkoutDate.getTime());
    	String dueStr = sf.format(ra5.dueDate.getTime());
    	boolean strComp1 = checkoutStr.compareTo("07/02/15") == 0;
    	boolean strComp2 = dueStr.compareTo("07/11/15") == 0;
    	boolean compResult1 = Double.compare(2.99, ra5.theTool.dailyCharge) == 0;
    	boolean compResult2 = Double.compare(14.95, ra5.prediscountCharge) == 0;
    	boolean compResult3 = Double.compare(0.00, ra5.discountAmount) == 0;
    	boolean compResult4 = Double.compare(14.95, ra5.finalAmount) == 0;

    	assertEquals("JAKR", ra5.theTool.toolCode);
    	assertEquals("Jackhammer", ra5.theTool.toolType);
    	assertEquals("Ridgid", ra5.theTool.toolBrand);
    	assertEquals(9, ra5.rentalDayCount);
    	assertEquals(true, strComp1);
    	assertEquals(true, strComp2);
		assertEquals(true, compResult1);
		assertEquals(5, ra5.chargeableDays);
		assertEquals(true, compResult2);
    	assertEquals(0, ra5.discountPercent);
    	assertEquals(true, compResult2);
    	assertEquals(true, compResult3);
    }

    
    @Test
    public void checkoutTest6() {
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
    	Tool tool3 = Inventory.toolList.get("JAKR");
    	Calendar date6 = Calendar.getInstance();
    	date6.set(2020, 6, 2);
    	RentalAgreement ra6 = new RentalAgreement(tool3, 4, 50, date6);
    	String checkoutStr = sf.format(ra6.checkoutDate.getTime());
    	String dueStr = sf.format(ra6.dueDate.getTime());
    	boolean strComp1 = checkoutStr.compareTo("07/02/20") == 0;
    	boolean strComp2 = dueStr.compareTo("07/06/20") == 0;
    	boolean compResult1 = Double.compare(2.99, ra6.theTool.dailyCharge) == 0;
    	boolean compResult2 = Double.compare(2.99, ra6.prediscountCharge) == 0;
    	boolean compResult3 = Double.compare(1.50, ra6.discountAmount) == 0;
    	boolean compResult4 = Double.compare(1.49, ra6.finalAmount) == 0;

    	assertEquals("JAKR", ra6.theTool.toolCode);
    	assertEquals("Jackhammer", ra6.theTool.toolType);
    	assertEquals("Ridgid", ra6.theTool.toolBrand);
    	assertEquals(4, ra6.rentalDayCount);
    	assertEquals(true, strComp1);
    	assertEquals(true, strComp2);
		assertEquals(true, compResult1);
		assertEquals(1, ra6.chargeableDays);
		assertEquals(true, compResult2);
    	assertEquals(50, ra6.discountPercent);
    	assertEquals(true, compResult2);
    	assertEquals(true, compResult3);
    }

}

