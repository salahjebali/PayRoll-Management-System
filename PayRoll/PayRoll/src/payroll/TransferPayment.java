package payroll;

public class TransferPayment implements PaymentMethod {

	private final String typeOfMethod;

	public TransferPayment() {
		typeOfMethod = "Transfer Payment Method";
	}

	@Override
	public void sendPayment(double netSalary, Wallet wallet) {
		System.out.println("sending € " + netSalary + " to your bank account... ");
		wallet.deposit(netSalary);
	}

	@Override
	public String getTypeOfMethod() {
		return this.typeOfMethod;
	}

	@Override
	public String toString() {
		return "Transfer payment";
	}
}
