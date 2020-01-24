package payroll;

public class WeeklyPayrollObserver implements Observer {

	ObservablePayroll p;

	public WeeklyPayrollObserver(ObservablePayroll p) {
		p.addObs(this);
		this.p = p;
	}

	@Override
	public void update() {

		if (p.getDays() % 7 == 0) {
			System.out.println(); // what's its aim? 

			p.getMyListOfEmployees().stream().filter(e -> !e.typeOfSalary().contains("Fixed"))
					.forEach(x -> x.receivePayment());

		}
	}

}
