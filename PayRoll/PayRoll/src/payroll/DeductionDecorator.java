package payroll;

public abstract class DeductionDecorator extends NetSalaryCalcDecorator {

	public DeductionDecorator(NetSalaryCalculator basic) {
		super(basic);
	}

	@Override
	public double calcNetSalary(double gross) throws Exception{
		return super.calcNetSalary(gross) - this.getDeduction(gross);
	}

	@Override
	public String getTypeOfDeduction() {
		return super.getTypeOfDeduction() + " " + this.getDeductionInfo();
	}

	// HOOK METHODS
	public abstract double getDeduction(double gross);

	public abstract String getDeductionInfo();

}
