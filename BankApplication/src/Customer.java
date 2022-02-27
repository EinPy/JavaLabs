
public class Customer {
	private String name;
	private long idNr;
	private static int customers = 100;
	private int customerNr;
	
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		customers+= 1;
		this.customerNr = customers;
	}
	
	public String getName() {
		return name;
	}
	
	public long getIdNr() {
		return idNr;
	}
	
	public int getCustormerNr() {
		return customerNr;
	}
	
	public String toStriing() {
		return name;
	}
	
	
}
