package payroll;

import java.util.Collection;

public interface ObservablePayroll {
	
	public void addObs(Observer o);
	
	public void remove(Observer o);
	
	public void notifyObs();
	
	public void hire(DecorableEmployee e);
	
	public void fire(DecorableEmployee e);
	
	public void startCompany();
	
	public int getDays();
	
	public Collection<DecorableEmployee> getMyListOfEmployees();
	
	public void resetDays();
	
	//public void setDays(int days);	Questo metodo e' stato utilizzato per testare gli observer
}
