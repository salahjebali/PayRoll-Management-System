	package payroll;

public class CheckPayment implements PaymentMethod {

	private Check check;

	private final String typeOfMethod;

	public CheckPayment() {
		typeOfMethod = "Check Payment Method";
	}

	@Override
	public void sendPayment(double netSalary, Wallet wallet) {
		check = new Check("Azienda", wallet.getOwner(), netSalary);
		System.out.println(check.getCheck());
		wallet.deposit(netSalary);
	}

	@Override
	public String getTypeOfMethod() {
		return this.typeOfMethod;
	}

	@Override
	public String toString() {

		return "Check Payment";
	}
}
