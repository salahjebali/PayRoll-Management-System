package payroll;

public interface NetSalaryCalculator {

	public double calcNetSalary(double gross) throws Exception;

	public String getTypeOfDeduction();
}
