package payroll;

public abstract class NetSalaryCalcDecorator implements NetSalaryCalculator {

	private NetSalaryCalculator nsc;

	public NetSalaryCalcDecorator(NetSalaryCalculator nsc) {
		this.nsc = nsc;
	}

	@Override
	public double calcNetSalary(double gross)throws Exception {
		return nsc.calcNetSalary(gross);
	}

	@Override
	public String getTypeOfDeduction() {
		return nsc.getTypeOfDeduction();
	}
	
}
