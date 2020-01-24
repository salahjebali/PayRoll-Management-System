package payroll;

public class MonthlyPayrollObserver implements Observer {
	ObservablePayroll p;

	public MonthlyPayrollObserver(ObservablePayroll p) {
		p.addObs(this);
		this.p = p;
	}

	@Override
	public void update() {

		if (p.getDays() % 30 == 0) {
			System.out.println();
			p.getMyListOfEmployees().stream().filter(e -> e.typeOfSalary().contains("Fixed"))
					.forEach(x -> x.receivePayment());
		}
	}

}
