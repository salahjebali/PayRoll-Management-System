package payroll;

public class Wallet {

	private int id;
	private String name;
	private double balance;

	public Wallet(int id, String name) {
		this.id = id;
		this.name = name;
		balance = 0;
	}

	public void deposit(double amount) {
		this.balance = this.balance + amount;
	}

	public double getBalance() {
		return this.balance;
	}

	public void take(double amount) throws Exception {

		if (balance < amount) {
			throw new Exception("fondi insufficienti");
		}
		balance = balance - amount;
	}

	public String getOwner() {
		String s = "id: " + this.id + " name: " + this.name;
		return s;
	}

}
