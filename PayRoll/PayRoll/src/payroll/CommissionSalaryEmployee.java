package payroll;

public class CommissionSalaryEmployee extends EmployeeDecorator {

	private double commissionRate;
	
	private final String typeOfSalary;

	public CommissionSalaryEmployee(DecorableEmployee employee, double commissionRate) {
		super(employee);
		this.commissionRate = commissionRate;
		typeOfSalary = "Commission";
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

	private double calculateCommission() {
		return commissionRate * super.getWorkcard().getCommissionAssolved();
	}


	// NET SALARY CALCULATOR
	@Override
	public double getNetSalary() {
		return super.calcNetSalary(this.getEarning());
	}

	@Override
	public double getEarning() {
		return super.getEarning() + this.calculateCommission();
	}

	// PAYMENT METHOD
	@Override
	public void receivePayment() {
		super.getPaymentMethod().sendPayment(this.getNetSalary(), super.getWallet());
	}
}
