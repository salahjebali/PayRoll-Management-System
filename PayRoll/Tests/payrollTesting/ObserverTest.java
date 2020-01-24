package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.BasicEmployee;
import payroll.CommissionSalaryEmployee;
import payroll.DecorableEmployee;
import payroll.FixedSalaryEmployee;
import payroll.HourSalaryEmployee;
import payroll.MonthlyPayrollObserver;
import payroll.ObservablePayroll;
import payroll.Observer;
import payroll.Payroll;
import payroll.ResetMonthlyObserver;
import payroll.ResetWeeklyObserver;
import payroll.WeeklyPayrollObserver;
import payroll.Workcard;

class ObserverTest {
	/*			PER VERIFICARE IL TEST RIMUOVERE COMMENTI QUI E DAI METODI SETDAYS(INT D)
	ObservablePayroll p = Payroll.getInstance();
	
	Workcard wc = new Workcard();
	DecorableEmployee basic = new BasicEmployee("Bernardo", wc);
	DecorableEmployee fixed = new FixedSalaryEmployee(basic, 1000.0);
	DecorableEmployee commission = new CommissionSalaryEmployee(basic, 100);
	DecorableEmployee fc = new FixedSalaryEmployee(commission, 1000.0);
	DecorableEmployee hfc = new HourSalaryEmployee(fc, 10);
	
	
	
	Observer mp = new MonthlyPayrollObserver(p);
	Observer wp = new WeeklyPayrollObserver(p);

	Observer rm = new ResetMonthlyObserver(p);
	Observer rw = new ResetWeeklyObserver(p);
	
	@Test
	public void testUpdateMonthlyPayrollObserver() {
		p.hire(fixed);
		p.setDays(30);
		mp.update();
		assertEquals(800.0, fixed.getWallet().getBalance());
	}
	
	@Test
	public void testUpdateWeeklyPayrollObserver() {
		p.hire(commission);
		wc.updateCommission(10);
		p.setDays(21);
		wp.update();
		assertEquals(800.0, commission.getWallet().getBalance());
	}
	
	@Test
	public void testUpdateResetMonthlyObserver() {
		p.hire(hfc);
		wc.updateCommission(1);
		wc.updateHour(10);
		p.setDays(30);
		rm.update();
		assertEquals(0.0, fc.getWorkcard().getCommissionAssolved());
		assertEquals(0.0, fc.getWorkcard().getWorkedHour());
		assertEquals(0, p.getDays());
	}
	
	@Test
	public void testUpdateResetWeeklyObserver() {
		p.hire(hfc);
		wc.updateCommission(1);
		wc.updateHour(10);
		p.setDays(14);
		rm.update();
		assertEquals(1, fc.getWorkcard().getCommissionAssolved());
		assertEquals(10.0, fc.getWorkcard().getWorkedHour());
		assertEquals(14, p.getDays());
	}
	*/
}
