import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class rentalAgreementTest {
	Tool aTool = new Tool("type1", "brand1", "code1", 5.55, true, false, false);
	Calendar aDate = Calendar.getInstance();
	RentalAgreement rntlAgmt = new RentalAgreement(aTool, 10, 10, aDate);

	@Test
	public void createRentalAgreementTest() {
		assertEquals("type1", rntlAgmt.theTool.toolType);
		assertEquals(10, rntlAgmt.rentalDayCount);
		assertEquals(10, rntlAgmt.discountPercent);
	}
	
	
	@Test
	public void calculateFinalAmountTest() {
		rntlAgmt.prediscountCharge = 10.00;
		rntlAgmt.discountAmount = 5.00;
		double result = rntlAgmt.calculateFinalAmount();
		boolean compResult = Double.compare(5.0, result) == 0;
		assertEquals(true, compResult);
	}
	
	
	@Test
	public void calculateDiscountAmountTest() {
		rntlAgmt.prediscountCharge = 10.00;
		double result = rntlAgmt.calculateDiscountAmount();
		boolean compResult = Double.compare(1.0, result) == 0;
		assertEquals(true, compResult);
	}
	
	
	@Test
	public void calculatePrediscountChargeTest() {
		rntlAgmt.chargeableDays = 10;
		double result = rntlAgmt.calculatePrediscountCharge();
		boolean compResult = Double.compare(55.50, result) == 0;
		assertEquals(true, compResult);
	}
	
	
	@Test
	public void calculateChargeableDaysTest() {
		//test dates around Independence Day
		rntlAgmt.checkoutDate.set(Calendar.MONTH, 6);
		rntlAgmt.checkoutDate.set(Calendar.DATE, 1);
		rntlAgmt.rentalDayCount = 10;
		assertEquals(6, rntlAgmt.calculateChargeableDays());
		rntlAgmt.rentalDayCount = 3;
		assertEquals(1, rntlAgmt.calculateChargeableDays());
		
		//test dates around Labor Day
		rntlAgmt.checkoutDate.set(Calendar.MONTH, 8);
		rntlAgmt.checkoutDate.set(Calendar.DATE, 1);
		rntlAgmt.rentalDayCount = 10;
		assertEquals(7, rntlAgmt.calculateChargeableDays());
		rntlAgmt.rentalDayCount = 6;
		assertEquals(3, rntlAgmt.calculateChargeableDays());
	}
	
	
	@Test
	public void isWeekendTest() {
		rntlAgmt.checkoutDate.set(Calendar.MONTH, 6);
		rntlAgmt.checkoutDate.set(Calendar.DATE, 11);
		assertEquals(true, rntlAgmt.isWeekend(rntlAgmt.checkoutDate));
		
		rntlAgmt.checkoutDate.set(Calendar.DATE, 13);
		assertEquals(false, rntlAgmt.isWeekend(rntlAgmt.checkoutDate));
	}
	
	
	@Test
	public void isIndependenceDayTest() {
		rntlAgmt.checkoutDate.set(Calendar.MONTH, 6);
		rntlAgmt.checkoutDate.set(Calendar.DATE, 3);
		assertEquals(true, rntlAgmt.isIndependenceDay(rntlAgmt.checkoutDate));
		
		rntlAgmt.checkoutDate.set(Calendar.DATE, 6);
		assertEquals(false, rntlAgmt.isIndependenceDay(rntlAgmt.checkoutDate));
	}
	
	
	@Test
	public void isLaborDayTest() {
		rntlAgmt.checkoutDate.set(Calendar.MONTH, 8);
		rntlAgmt.checkoutDate.set(Calendar.DATE, 7);
		assertEquals(true, rntlAgmt.isLaborDay(rntlAgmt.checkoutDate));
		
		rntlAgmt.checkoutDate.set(Calendar.DATE, 14);
		assertEquals(false, rntlAgmt.isLaborDay(rntlAgmt.checkoutDate));
	}
}
