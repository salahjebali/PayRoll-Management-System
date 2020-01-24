package payroll;

public class FixedSalaryEmployee extends EmployeeDecorator {

	private double fixedSalary;
	private final String typeOfSalary;

	public FixedSalaryEmployee(DecorableEmployee employee, double fixedSalary) {
		super(employee);
		this.fixedSalary = fixedSalary;
		typeOfSalary = "Fixed";
	}

	// GENERIC INFO
	@Override
	public String getInfo() {
		return "			**" + "*************			\n" + "| Name: " + super.getName() + "\n| id:  "
				+ super.getId() + "\n| Type of employee: " + typeOfSalary() + " employee" + "\n| Payment: "
				+ super.getPaymentMethod().toString() + "\n| Net salary to send: " + getNetSalary() + "\n \n";
	}

	@Override
	public String typeOfSalary() {
		return super.typeOfSalary() + " " + typeOfSalary;
	}

	// NET SALARY CALCULATOR
	@Override
	public double getNetSalary() {
		return super.calcNetSalary(this.getEarning());
	}

	@Override
	public double getEarning() {
		return super.getEarning() + this.fixedSalary;
	}

	// PAYMENT METHOD
	@Override
	public void receivePayment() {
		super.getPaymentMethod().sendPayment(this.getNetSalary(), super.getWallet());
	}
}