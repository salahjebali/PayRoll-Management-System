package payroll;

public abstract class EmployeeDecorator implements DecorableEmployee {

	private DecorableEmployee employee;

	public EmployeeDecorator(DecorableEmployee employee) {
		this.employee = employee;
	}

	// GENERIC INFO
	@Override
	public int getId() {
		return employee.getId();
	}

	@Override
	public String getName() {
		return employee.getName();
	}

	@Override
	public double getEarning() {
		return employee.getEarning();
	}

	@Override
	public String typeOfSalary() {
		return employee.typeOfSalary();
	}

	@Override
	public String getInfo() {
		return employee.getInfo();
	}

	// PAYMENT METHOD
	@Override
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		employee.setPaymentMethod(paymentMethod);
	}

	@Override
	public PaymentMethod getPaymentMethod() {
		return employee.getPaymentMethod();
	}

	public void receivePayment() {
		employee.receivePayment();
	}

	// NET SALARY CALCULATOR
	@Override
	public double getNetSalary() {
		return employee.getNetSalary();
	}

	@Override
	public double calcNetSalary(double lordo) {
		return employee.calcNetSalary(lordo);
	}

	@Override
	public void setNetSalaryCalculator(NetSalaryCalculator nsc) {
		employee.setNetSalaryCalculator(nsc);
	}
	
	@Override
	public Wallet getWallet () {
		return employee.getWallet();
	}
	
	@Override
	public Workcard getWorkcard() {
		return employee.getWorkcard();
	}

}
