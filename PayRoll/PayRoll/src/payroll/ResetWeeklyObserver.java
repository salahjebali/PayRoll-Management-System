package payroll;

public class ResetWeeklyObserver implements Observer {
	ObservablePayroll p;

	public ResetWeeklyObserver(ObservablePayroll p) {
		p.addObs(this);
		this.p = p;
	}

	@Override
	public void update() {
		if (p.getDays() % 7 == 0) {
			p.getMyListOfEmployees().stream().filter(e -> !e.typeOfSalary().contains("Fixed"))
					.forEach(x -> x.getWorkcard().resetC());

			p.getMyListOfEmployees().stream().filter(e -> !e.typeOfSalary().contains("Fixed"))
					.forEach(x -> x.getWorkcard().resetH());
		}
	}

}
