package payroll;

public class BeneficalDeduction extends DeductionDecorator {

	private final String typeOfDeduction;

	public BeneficalDeduction(NetSalaryCalculator basic) {
		super(basic);
		typeOfDeduction = "BeneficalDeduction 8XMILLE";
	}

	@Override
	public double getDeduction(double gross) {
		return gross * 0.008;
	}

	@Override
	public String getDeductionInfo() {
		return typeOfDeduction;
	}
}
