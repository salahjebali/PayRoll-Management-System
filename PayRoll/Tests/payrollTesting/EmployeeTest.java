package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.BasicEmployee;
import payroll.CheckPayment;
import payroll.CommissionSalaryEmployee;
import payroll.DecorableEmployee;
import payroll.FixedSalaryEmployee;
import payroll.HourSalaryEmployee;
import payroll.TransferPayment;
import payroll.Workcard;

class EmployeeTest {

	Workcard wc = new Workcard();
	DecorableEmployee basic = new BasicEmployee("Bernardo", wc);

	DecorableEmployee fixed = new FixedSalaryEmployee(basic, 1000.0);

	DecorableEmployee commission = new CommissionSalaryEmployee(basic, 100);

	DecorableEmployee hour = new HourSalaryEmployee(basic, 10);

	DecorableEmployee fc = new FixedSalaryEmployee(commission, 1000.0);
	
	DecorableEmployee hfc = new HourSalaryEmployee(fc, 10);

	// BasicEmployee test

	@Test
	public void testConstructorBasic() {
		assertEquals("Bernardo", basic.getName());
		assertEquals("", basic.typeOfSalary());
		assertEquals(0, basic.getEarning());
		assertEquals("Cash Payment", basic.getPaymentMethod().toString());
		assertEquals(0.0, basic.getWallet().getBalance());
		assertEquals("0 0.0", basic.getWorkcard().getCommissionAssolved() + " " + basic.getWorkcard().getWorkedHour());
	}

	@Test
	public void testSetPaymentBasic() {
		basic.setPaymentMethod(new TransferPayment());
		assertEquals("Transfer payment", basic.getPaymentMethod().toString());

		basic.setPaymentMethod(new CheckPayment());
		assertEquals("Check Payment", basic.getPaymentMethod().toString());

	}

	@Test
	public void testReceivePaymentBasic() {
		basic.receivePayment();
		assertEquals(0.0, basic.getWallet().getBalance());
	}

	@Test
	public void testCalcolaBasic() {
		assertEquals(800, basic.calcNetSalary(1000));
	}

	@Test
	public void testGetNetSalaryBasic() {
		assertEquals(0.0, basic.getNetSalary());
	}

	// FixedEmployee test
	@Test
	public void testConstructorFixed() {
		assertEquals("Bernardo", fixed.getName());
		assertEquals(" Fixed", fixed.typeOfSalary());
		assertEquals(1000.0, fixed.getEarning());
		assertEquals("Cash Payment", fixed.getPaymentMethod().toString());
		assertEquals(0.0, fixed.getWallet().getBalance());
		assertEquals("0 0.0", fixed.getWorkcard().getCommissionAssolved() + " " + fixed.getWorkcard().getWorkedHour());
	}

	@Test
	public void testReceivePaymentFixed() {
		fixed.receivePayment();
		assertEquals(800, fixed.getWallet().getBalance());
	}

	@Test
	public void testCalcolaFixed() {
		assertEquals(800, fixed.calcNetSalary(fixed.getEarning()));
	}

	@Test
	public void testGetNetSalaryFixed() {
		assertEquals(800, fixed.getNetSalary());
	}

	// CommissionEmployee test
	@Test
	public void testConstructorCommission() {
		assertEquals("Bernardo", commission.getName());
		assertEquals(" Commission", commission.typeOfSalary());
		assertEquals(0.0, commission.getEarning());
		assertEquals("Cash Payment", commission.getPaymentMethod().toString());
		assertEquals(0.0, commission.getWallet().getBalance());
		assertEquals("0 0.0",
				commission.getWorkcard().getCommissionAssolved() + " " + commission.getWorkcard().getWorkedHour());
	}

	@Test
	public void testReceivePaymentCommission() {
		commission.receivePayment();
		assertEquals(0, commission.getWallet().getBalance());
	}

	@Test
	public void testCalcolaCommission() {
		wc.updateCommission(2);
		assertEquals(160, commission.calcNetSalary(commission.getEarning()));
	}

	@Test
	public void testGetNetSalaryCommission() {
		assertEquals(0.0, commission.getNetSalary());
	}

	// HourEmployee test
	@Test
	public void testConstructorHour() {
		assertEquals("Bernardo", hour.getName());
		assertEquals(" Hour", hour.typeOfSalary());
		assertEquals(0.0, hour.getEarning());
		assertEquals("Cash Payment", hour.getPaymentMethod().toString());
		assertEquals(0.0, hour.getWallet().getBalance());
		assertEquals("0 0.0", hour.getWorkcard().getCommissionAssolved() + " " + hour.getWorkcard().getWorkedHour());
	}

	@Test
	public void testReceivePaymentHour() {
		hour.receivePayment();
		assertEquals(0, hour.getWallet().getBalance());
	}

	@Test
	public void testCalcolaHour() {
		wc.updateHour(10);
		assertEquals(80, hour.calcNetSalary(hour.getEarning()));
	}

	@Test
	public void testGetNetSalaryHour() {
		wc.updateHour(10);
		assertEquals(80, hour.getNetSalary());
	}

	// FixedCommissionEmployee test
	@Test
	public void testConstructorFixedCommission() {
		assertEquals("Bernardo", fc.getName());
		assertEquals(" Commission Fixed", fc.typeOfSalary());
		assertEquals(1000.0, fc.getEarning());
		assertEquals("Cash Payment", fc.getPaymentMethod().toString());
		assertEquals(0.0, fc.getWallet().getBalance());
		assertEquals("0 0.0", fc.getWorkcard().getCommissionAssolved() + " " + fc.getWorkcard().getWorkedHour());
	}

	@Test
	public void testReceivePaymentFixedCommission() {
		fc.receivePayment();
		assertEquals(800, fc.getWallet().getBalance());
	}

	@Test
	public void testCalcolaFixedCommission() {
		wc.updateCommission(2);
		assertEquals(960, fc.calcNetSalary(fc.getEarning()));
	}

	@Test
	public void testGetNetSalaryFixedCommission() {
		wc.updateCommission(2);
		assertEquals(960, fc.getNetSalary());
	}
	
	// CommissionHourFixedEmployee test
		@Test
		public void testConstructorHourFixedCommission() {
			assertEquals("Bernardo", hfc.getName());
			assertEquals(" Commission Fixed Hour", hfc.typeOfSalary());
			assertEquals(1000.0, hfc.getEarning());
			assertEquals("Cash Payment", hfc.getPaymentMethod().toString());
			assertEquals(0.0, hfc.getWallet().getBalance());
			assertEquals("0 0.0", hfc.getWorkcard().getCommissionAssolved() + " " + hfc.getWorkcard().getWorkedHour());
		}

		@Test
		public void testReceivePaymentHourFixedCommission() {
			hfc.receivePayment();
			assertEquals(800, hfc.getWallet().getBalance());
		}

		@Test
		public void testCalcolaHourFixedCommission() {
			wc.updateCommission(8);
			wc.updateHour(20);
			assertEquals(1600, hfc.calcNetSalary(hfc.getEarning()));
		}

		@Test
		public void testGetNetSalaryHourFixedCommission() {
			wc.updateCommission(8);
			wc.updateHour(20);
			assertEquals(1600, hfc.getNetSalary());
		}

}
