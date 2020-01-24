package payroll;

public class ResetMonthlyObserver implements Observer {
	ObservablePayroll p;

	public ResetMonthlyObserver(ObservablePayroll p) {
		p.addObs(this);
		this.p = p;
	}

	@Override
	public void update() {
		if (p.getDays() % 30 == 0) {
			p.getMyListOfEmployees().stream().filter(e -> e.typeOfSalary().contains("Fixed"))
					.forEach(x -> x.getWorkcard().resetC());

			p.getMyListOfEmployees().stream().filter(e -> e.typeOfSalary().contains("Fixed"))
					.forEach(x -> x.getWorkcard().resetH());

			p.resetDays();
		}
	}

}
