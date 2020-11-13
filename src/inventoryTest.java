import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class inventoryTest {

	@Test
	public void testAddTool() {
		Tool aTool = new Tool();
		
		Inventory.addTool("code1", aTool);
		boolean added = Inventory.toolList.containsKey("code1");
		assertEquals(true, added);
		
		Inventory.toolList.remove("code1");
		boolean removed = Inventory.toolList.containsKey("code1");
		assertEquals(false, removed);
	}

}
