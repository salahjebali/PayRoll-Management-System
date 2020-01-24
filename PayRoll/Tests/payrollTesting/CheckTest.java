package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Check;

class CheckTest {

	Check c = new Check("Company", "Employee", 100);

	@Test
	public void testConstructorCheck() {
		assertEquals("From: Company\nTo: Employee\nTotal amount: € 100.0", c.getCheck());
	}
}
