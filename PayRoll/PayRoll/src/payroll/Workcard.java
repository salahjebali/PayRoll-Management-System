package payroll;

public class Workcard {

	private int commissionAssolved;
	private double workedHour;

	public Workcard() {
		commissionAssolved = 0;
		workedHour = 0;
	}

	public void updateHour(double n) {
		workedHour = workedHour + n;
	}

	public void updateCommission(int n) {
		commissionAssolved = commissionAssolved + n;
	}

	public int getCommissionAssolved() {
		return commissionAssolved;
	}

	public double getWorkedHour() {
		return workedHour;
	}

	public void resetH() {
		workedHour = 0;
	}

	public void resetC() {
		commissionAssolved = 0;
	}
}
