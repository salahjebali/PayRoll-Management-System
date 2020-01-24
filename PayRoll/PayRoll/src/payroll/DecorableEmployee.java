package payroll;

public interface DecorableEmployee {
	public String getName();

	public int getId();

	public double getNetSalary();

	public String typeOfSalary();

	public String getInfo();

	public void setPaymentMethod(PaymentMethod paymentMethod);

	public PaymentMethod getPaymentMethod();

	public double getEarning();

	public double calcNetSalary(double lordo);

	public void receivePayment();

	public void setNetSalaryCalculator(NetSalaryCalculator nsc);
	
	public Wallet getWallet( );
	
	public Workcard getWorkcard();
	
}
