package payroll;

public class CashPayment implements PaymentMethod {

	private final String typeOfMethod;

	public CashPayment() {
		typeOfMethod = "Cash Payment Method";
	}

	@Override
	public void sendPayment(double netSalary, Wallet wallet) { 
		System.out.println("Here is your salary: € " + netSalary);
		wallet.deposit(netSalary);
	}

	@Override
	public String getTypeOfMethod() {
		return this.typeOfMethod;
	}

	@Override
	public String toString() {
		return "Cash Payment";
	}
}
