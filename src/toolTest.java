import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class toolTest {

	@Test
	public void testCreateTool() {
		Tool aTool = new Tool("type1", "brand1", "code1", 5.55, true, true, true);
		assertEquals("type1", aTool.toolType);
		assertEquals("brand1", aTool.toolBrand);
		assertEquals("code1", aTool.toolCode);
		assertEquals(5.55, aTool.dailyCharge);
		assertEquals(true, aTool.weekdayCharge);
		assertEquals(true, aTool.weekendCharge);
		assertEquals(true, aTool.holidayCharge);
	}

}
