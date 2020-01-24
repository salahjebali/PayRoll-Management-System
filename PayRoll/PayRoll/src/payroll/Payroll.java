package payroll;

import java.util.*;

public class Payroll extends TimerTask implements ObservablePayroll {

	private Collection<DecorableEmployee> myListOfEmployees;
	private Collection<Observer> myListOfObserver;
	private static Payroll instance;
	private static Timer timer;

	private static int days = 0;

	private Payroll() {
		myListOfEmployees = new ArrayList<DecorableEmployee>();
		myListOfObserver = new ArrayList<Observer>();
	}

	public static Payroll getInstance() {
		if (instance == null) {
			instance = new Payroll();
		}
		return instance;
	}

	public void startCompany() { // Client responsability
		Calendar today = Calendar.getInstance();
		timer = new Timer();

		// ogni secondo, dal momento in cui viene eseguito questo metodo viene eseguito
		// il metodo run
		timer.schedule(this, today.getTime(), 300); // period: 1 day = 1000*60*60*24
	}

	@Override
	public void addObs(Observer o) {
		myListOfObserver.add(o);
	}

	@Override
	public void remove(Observer o) {
		myListOfObserver.remove(o);
	}

	@Override
	public void notifyObs() {
		myListOfObserver.forEach(x -> x.update());
	}

	public void hire(DecorableEmployee e) {
		myListOfEmployees.add(e);
	}

	public void fire(DecorableEmployee e) {
		myListOfEmployees.remove(e);
	}

	public Collection<DecorableEmployee> getMyListOfEmployees() {
		return myListOfEmployees;
	}

	public void upDay() { // useless, moreover it should be private
		days++;
	}

	public int getDays() {
		return days;
	}
	/*
	public void setDays(int d) {
		days = d;
	}*/

	public void resetDays() {
		days = 0;
	}

	@Override
	public void run() {
		days = days + 1;
		System.out.print(days + " ");
		notifyObs();
	}
}
