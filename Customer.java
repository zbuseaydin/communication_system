
package question;

public class Customer {
		
	public int ID;
	public String name;
	private int age;
	private Operator operator;
	private Bill bill;
	public int talkingTime = 0;
	public int numOfMessages = 0;
	public double MBsOfUsage = 0;
	
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.bill = new Bill(limitingAmount);
	}
	
	public void talk(int minute, Customer other) {
		if(this.ID != other.ID) {
			double totalCost = operator.calculateTalkingCost(minute, this);
			if(!bill.check(totalCost)) {
				bill.add(totalCost);
				talkingTime += minute;
				other.talkingTime += minute;
				operator.talkingTime += minute;
				other.operator.talkingTime += minute;
			}
		}
	}
	
	public void message(int quantity, Customer other) {
		if(this.ID != other.ID) {
			double totalCost = operator.calculateMessageCost(quantity, this, other);
			if(!(bill.check(totalCost))) {
				bill.add(totalCost);
				numOfMessages += quantity;
				operator.numOfMessages += quantity;
			}
		}
	}
	
	public void connection(double amount) {
		double totalCost = operator.calculateNetworkCost(amount);
		if(!bill.check(totalCost)) {
			bill.add(totalCost);
			MBsOfUsage += amount;
			operator.MBsOfUsage += amount;
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public Bill getBill() {
		return bill;
	}
	
	public void setBill(Bill bill) {
		this.bill = bill;
	}

}

