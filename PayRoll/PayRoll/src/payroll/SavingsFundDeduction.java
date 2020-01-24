package payroll;

public class SavingsFundDeduction extends NetSalaryCalcDecorator {

	private double deposit;
	private final String typeOfDeduction;

	public SavingsFundDeduction(NetSalaryCalculator nsc, double deposit) {
		super(nsc);
		this.deposit = deposit;
		typeOfDeduction = "SavingsFund Deduction";
	}

	@Override
	public double calcNetSalary(double gross) throws Exception {
		if(gross < deposit) {
			throw new Exception("Your salary is not enough");
		}
		return super.calcNetSalary(gross) - this.deposit;
	}

	@Override
	public String getTypeOfDeduction() {
		return super.getTypeOfDeduction() +" " + this.typeOfDeduction;
	}

}
