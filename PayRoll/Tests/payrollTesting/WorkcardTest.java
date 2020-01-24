package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Workcard;

class WorkcardTest {

	Workcard wc = new Workcard();
	
	@Test
	public void testConstructor() {
		assertEquals(0, wc.getCommissionAssolved());
		assertEquals(0, wc.getWorkedHour());
	}
	
	@Test
	public void testUpdateHours() {
		wc.updateHour(10);
		assertEquals(10, wc.getWorkedHour());
		wc.updateHour(3);
		assertEquals(13, wc.getWorkedHour());
		
	}
	
	@Test
	public void testupdateCommssion() {
		wc.updateCommission(10);
		assertEquals(10, wc.getCommissionAssolved());
		wc.updateCommission(3);
		assertEquals(13, wc.getCommissionAssolved());
	}
	
	@Test
	public void testReset() {
		wc.updateCommission(13);
		wc.updateHour(18);
		assertEquals(13, wc.getCommissionAssolved());
		assertEquals(18, wc.getWorkedHour());
		wc.resetC();
		wc.resetH();
		assertEquals(0, wc.getCommissionAssolved());
		assertEquals(0, wc.getWorkedHour());
	}
	
	
	
}
