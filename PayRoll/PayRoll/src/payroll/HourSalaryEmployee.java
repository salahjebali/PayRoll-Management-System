package payroll;

public class HourSalaryEmployee extends EmployeeDecorator {

	private double hourRate;
	private final String typeOfSalary;

	public HourSalaryEmployee(DecorableEmployee employee, double hourRate) {
		super(employee);
		this.hourRate = hourRate;
		typeOfSalary = "Hour";
	}

	// GENERIC INFO
	@Override
	public String getInfo() {
		return "			***************			\n" + "| Name: " + super.getName() + "\n| id:  " + super.getId()
				+ "\n| Type of employee: " + typeOfSalary() + " employee" + "\n| Payment: "
				+ super.getPaymentMethod().toString() + "\n| Net salary to send: " + getNetSalary() + "\n \n";
	}

	@Override
	public String typeOfSalary() {
		return super.typeOfSalary() + " " + this.typeOfSalary;
	}

	private double calculateEarnings() {
		return this.hourRate * super.getWorkcard().getWorkedHour();
	}

	// NET SALARY CALCULATOR
	@Override
	public double getNetSalary() {
		return super.calcNetSalary(this.getEarning());
	}

	@Override
	public double getEarning() {
		return super.getEarning() + this.calculateEarnings();
	}

	// PAYMENT METHOD
	@Override
	public void receivePayment() {
		super.getPaymentMethod().sendPayment(this.getNetSalary(), super.getWallet());
	}
}