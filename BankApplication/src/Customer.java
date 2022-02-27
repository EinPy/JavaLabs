
public class Customer {
	private String name;
	private long idNr;
	private int customerNr;
	
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
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
