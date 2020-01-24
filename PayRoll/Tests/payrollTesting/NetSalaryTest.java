package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.BasicNetSalaryCalculator;
import payroll.BeneficalDeduction;
import payroll.GovernmentDeduction;
import payroll.NetSalaryCalculator;
import payroll.SavingsFundDeduction;

class NetSalaryTest {

	NetSalaryCalculator basic = new BasicNetSalaryCalculator();
	NetSalaryCalculator savings = new SavingsFundDeduction(basic, 100.0);

	NetSalaryCalculator gov = new GovernmentDeduction(basic);
	NetSalaryCalculator gov2 = new GovernmentDeduction(savings);

	NetSalaryCalculator ben = new BeneficalDeduction(basic);
	NetSalaryCalculator ben2 = new BeneficalDeduction(savings);

	NetSalaryCalculator govben = new GovernmentDeduction(ben2);
	NetSalaryCalculator bengov = new BeneficalDeduction(gov2);

	@Test
	public void testConstructor() {
		assertEquals("Basic Tax Deduction", basic.getTypeOfDeduction());
	}

	@Test
	public void testBasicCalcNetSalary() {
		try {
			assertEquals(80, basic.calcNetSalary(100));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConstructorSavings() {
		assertEquals("Basic Tax Deduction SavingsFund Deduction", savings.getTypeOfDeduction());
	}

	@Test
	public void testExcCalcNetSalarySavings() {
		try {
			savings.calcNetSalary(10);
			fail("Expected Exception");
		} catch (Exception exc) {
			assertEquals("Your salary is not enough", exc.getMessage());
		}
	}

	@Test
	public void testCalcNetSalary() {
		try {
			assertEquals(60, savings.calcNetSalary(200));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConstructorGov() {
		assertEquals("Basic Tax Deduction GovernmentDeduction 5XMILLE", gov.getTypeOfDeduction());
	}

	@Test
	public void testConstructorGov2() {
		assertEquals("Basic Tax Deduction SavingsFund Deduction GovernmentDeduction 5XMILLE",
				gov2.getTypeOfDeduction());
	}

	@Test
	public void testConstructorBen() {
		assertEquals("Basic Tax Deduction BeneficalDeduction 8XMILLE", ben.getTypeOfDeduction());
	}

	@Test
	public void testConstructorBen2() {
		assertEquals("Basic Tax Deduction SavingsFund Deduction BeneficalDeduction 8XMILLE", ben2.getTypeOfDeduction());
	}

	@Test
	public void testConstructorGovBen() {
		assertEquals("Basic Tax Deduction SavingsFund Deduction BeneficalDeduction 8XMILLE GovernmentDeduction 5XMILLE",
				govben.getTypeOfDeduction());
	}

	@Test
	public void testGovBenDeduction() {
		try {
			assertEquals(687.0, govben.calcNetSalary(1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConstructorBenGov() {
		assertEquals("Basic Tax Deduction SavingsFund Deduction GovernmentDeduction 5XMILLE BeneficalDeduction 8XMILLE",
				bengov.getTypeOfDeduction());
	}

	@Test
	public void testBenGovDeduction() {
		try {
			assertEquals(1001.8, bengov.calcNetSalary(1400));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
