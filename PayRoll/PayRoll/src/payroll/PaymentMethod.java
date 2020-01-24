package payroll;

public interface PaymentMethod {

	public void sendPayment(double netSalary, Wallet wallet);

	public String getTypeOfMethod();

}
