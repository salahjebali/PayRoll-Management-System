package payrollTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Wallet;

class WalletTest {

	Wallet w = new Wallet(1, "Bernardo");

	@Test
	public void testConstructorWallet() {
		assertEquals("id: 1 name: Bernardo", w.getOwner());
		assertEquals(0, w.getBalance());
	}

	@Test
	public void testDeposite() {
		w.deposit(23);
		w.deposit(10);
		assertEquals(33, w.getBalance());
	}
	
}
