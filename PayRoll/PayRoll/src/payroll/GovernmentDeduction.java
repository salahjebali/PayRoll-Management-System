package payroll;

public class GovernmentDeduction extends DeductionDecorator {

	private final String typeOfDeduction;

	public GovernmentDeduction(NetSalaryCalculator nsc) {
		super(nsc);
		typeOfDeduction = "GovernmentDeduction 5XMILLE";
	}

	@Override
	public double getDeduction(double gross) {
		return gross * 0.005; // 5 X MILLE
	}

	@Override
	public String getDeductionInfo() {
		return typeOfDeduction;
	}
}
