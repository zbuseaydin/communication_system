
package question;

public class Operator {
	
	public int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	public int talkingTime = 0;
	public int numOfMessages = 0;
	public double MBsOfUsage = 0;
	
	public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
		this.ID = ID;
		this.talkingCharge = talkingCharge;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.discountRate = discountRate;
	}
	
	public double calculateTalkingCost(int minute, Customer customer) {
		if (customer.getAge() < 18 || customer.getAge() > 65)
			return ((double)minute * talkingCharge) * (1 - (double)discountRate / 100.00);
		else
			return ((double)minute * talkingCharge);
	}
	
	public double calculateMessageCost(int quantity, Customer customer, Customer other) {
		if (customer.getOperator() == other.getOperator())
			return ((double)quantity * messageCost) * (1 - (double)discountRate / 100.00);
		else
			return (double)quantity * messageCost;
	}
	
	public double calculateNetworkCost(double amount) {
		return amount * networkCharge;
	}

	public double getTalkingCharge() {
		return talkingCharge;
	}

	public void setTalkingCharge(double talkingCharge) {
		this.talkingCharge = talkingCharge;
	}

	public double getMessageCost() {
		return messageCost;
	}

	public void setMessageCost(double messageCost) {
		this.messageCost = messageCost;
	}

	public double getNetworkCharge() {
		return networkCharge;
	}

	public void setNetworkCharge(double networkCharge) {
		this.networkCharge = networkCharge;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	
}

