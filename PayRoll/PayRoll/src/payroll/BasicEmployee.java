package payroll;

public class BasicEmployee implements DecorableEmployee {

	private String name;
	private static int countId = 0;
	private int id;
	private final String typeOfSalary;
	private PaymentMethod paymentMethod;
	private double earning;
	private NetSalaryCalculator nsc;
	private Wallet mywallet;
	private Workcard workcard;

	public BasicEmployee(String name, Workcard workcard) {
		this.name = name;
		countId = countId + 1;
		id = countId;
		typeOfSalary = "";
		this.earning = 0;
		paymentMethod = new CashPayment(); // default payment
		nsc = new BasicNetSalaryCalculator();
		mywallet = new Wallet(this.id, this.name);
		this.workcard = workcard;
	}

	// GENERIC INFO

	@Override
	public String getInfo() {
		return "			***************			\n" + "| Name: " + getName() + "\n| id:  " + getId()
				+ "\n| Type of employee: " + typeOfSalary() + " employee" + "\n| Payment: "
				+ getPaymentMethod().toString() + "\n| Net salary to send: " + getNetSalary() + "\n \n";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String typeOfSalary() {
		return typeOfSalary;
	}

	@Override
	public int getId() {
		return id;
	}

	// PAYMENT METHODS
	@Override
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public PaymentMethod getPaymentMethod() {
		return this.paymentMethod;
	}

	@Override
	public void receivePayment() {
		this.getPaymentMethod().sendPayment(getNetSalary(), getWallet());
	}

	@Override
	public Wallet getWallet() {
		return this.mywallet;
	}

	// NET SALARY CALCULATOR
	@Override
	public double getNetSalary() {
		return this.calcNetSalary(this.getEarning());
	}

	@Override
	public double getEarning() {
		return earning;
	}

	@Override
	public double calcNetSalary(double lordo) {
		double net = -1;
		try {
			net = nsc.calcNetSalary(lordo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return net;
	}

	@Override
	public void setNetSalaryCalculator(NetSalaryCalculator nsc) {
		this.nsc = nsc;
	}

	@Override
	public Workcard getWorkcard() {
		return workcard;
	}

}

