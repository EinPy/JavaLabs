
public class BankAccount {
	private Customer owner;
	private double value;
	private static int accounts = 1000;
	private int accountNumber;
	
	public BankAccount(String holderName, long holderId) {
		this.owner = new Customer(holderName, holderId);
		this.value = 0;
		accounts += 1;
		this.accountNumber = accounts;
	}
	
	public BankAccount (Customer holder) {
		this.owner = holder;
		this.value = 0;
		accounts += 1;
		this.accountNumber = accounts;
	}
	
	public Customer getHolder() {
		return owner;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getAmount() {
		return value;
	}
	
	public void deposit(double amount) {
		value += amount;
	}
	
	public void withdraw(double amount) {
		value -= amount;
	}
	
	public String toString() {
		return String.format("konto %d (%s): %.2f)",
				accountNumber, owner.toString(), value);
	}
	
	
}
