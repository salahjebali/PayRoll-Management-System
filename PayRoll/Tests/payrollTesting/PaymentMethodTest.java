package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.CashPayment;
import payroll.CheckPayment;
import payroll.TransferPayment;

class PaymentMethodTest {

	CheckPayment checkPayment = new CheckPayment();
	CashPayment cashPayment = new CashPayment();
	TransferPayment transferPayment = new TransferPayment();

	@Test
	public void testGetterCheckPayment() {
		assertEquals("Check Payment Method", checkPayment.getTypeOfMethod());
	}

	@Test
	public void testGetterCashPayment() {
		assertEquals("Transfer Payment Method", transferPayment.getTypeOfMethod());
	}

	@Test
	public void testGetterTransferPayment() {
		assertEquals("Cash Payment Method", cashPayment.getTypeOfMethod());
	}
	
	//Manca da testare i metodi send ma richiamano tutti i metodi di wallet dunque già testati in wallet test
	
	
	
	
}
