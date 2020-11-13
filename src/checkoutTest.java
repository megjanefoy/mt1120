import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.*;


public class checkoutTest {
	
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
    public void checkoutTest() {
    	Inventory.addTool("LADW", new Tool("Ladder", "Werner", "LADW", 1.99, true, true, false));
		Inventory.addTool("CHNS", new Tool("Chainsaw", "Stihl", "CHNS", 1.49, true, false, true));
		Inventory.addTool("JAKR", new Tool("Jackhammer", "Ridgid", "JAKR", 2.99, true, false, false));
		Inventory.addTool("JAKD", new Tool("Jackhammer", "DeWalt", "JAKD", 2.99, true, false, false));
    	
		Tool tool1 = Inventory.toolList.get("LADW");
    	Tool tool2 = Inventory.toolList.get("CHNS");
    	Tool tool3 = Inventory.toolList.get("JAKR");
    	Tool tool4 = Inventory.toolList.get("JAKD");
    	
    	Calendar date1 = Calendar.getInstance();
    	Calendar date2 = Calendar.getInstance();
    	Calendar date3 = Calendar.getInstance();
    	Calendar date4 = Calendar.getInstance();
    	Calendar date5 = Calendar.getInstance();
    	Calendar date6 = Calendar.getInstance();
    	
    	date1.set(2015, 8, 3);
    	date2.set(2020, 6, 2);
    	date3.set(2015, 6, 2);
    	date4.set(2015, 8, 3);
    	date5.set(2015, 6, 2);
    	date6.set(2020, 6, 2);
    	
    	//prints rental agreement scenarios
    	System.out.println("Test 1");
    	Checkout.checkout(tool3, 5, 101, date1);
    	System.out.println("Test 2");
    	Checkout.checkout(tool1, 3, 10, date2);
    	System.out.println("Test 3");
    	Checkout.checkout(tool2, 5, 25, date3);
    	System.out.println("Test 4");
    	Checkout.checkout(tool4, 6, 0, date4);
    	System.out.println("Test 5");
    	Checkout.checkout(tool3, 9, 0, date5);
    	System.out.println("Test 6");
    	Checkout.checkout(tool3, 4, 50, date6);
    }

}

