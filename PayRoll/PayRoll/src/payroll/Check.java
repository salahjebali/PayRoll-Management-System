package payroll;

public class Check {

	private String from;
	private String to;
	private double howMuch;

	public Check(String from, String to, double howMuch) {
		this.from = from;
		this.to = to;
		this.howMuch = howMuch;
	}

	public String getCheck() {
		String s = "From: " + from + "\n";
		s = s + "To: " + to + "\n";
		s = s + "Total amount: € " + howMuch;
		return s;
	}

}
