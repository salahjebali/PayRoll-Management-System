package payroll;

public class BasicNetSalaryCalculator implements NetSalaryCalculator {

	private final String typeOfDeduction;
	private final double taxDeduction;

	public BasicNetSalaryCalculator() {
		typeOfDeduction = "Basic Tax Deduction";
		taxDeduction = 0.20;
	}
	
	@Override
	public double calcNetSalary(double gross) {
		return gross - gross * taxDeduction;
	}

	@Override
	public String getTypeOfDeduction() {
		return typeOfDeduction;
	}

}
