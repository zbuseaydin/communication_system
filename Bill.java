
package question;

public class Bill {

	private double limitingAmount;
	private double currentDebt;
	public double amountPayed = 0;
	
	public Bill(double limitingAmount) {
		this.limitingAmount = limitingAmount;
		this.currentDebt = 0;
	}
	
	public boolean check(double amount) {
		return (currentDebt+amount > limitingAmount);
	}
	
	public void add(double amount) {
		currentDebt += amount;
	}
	
	public void pay(double amount) {
		if(amount>currentDebt)
			amount = currentDebt;
		amountPayed += amount;
		currentDebt -= amount;		
	}
	
	public void changeTheLimit(double amount) {
		if(amount>=currentDebt)
			this.limitingAmount = amount;
	}

	public double getLimitingAmount() {
		return limitingAmount;
	}

	public void setLimitingAmount(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}

	public double getCurrentDebt() {
		return currentDebt;
	}

	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
	}
	
}

