import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts;
	
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}
	
	public int addAccount(String holderName, long idNr) {
		//check if person already excists first
		for (BankAccount bc : accounts) {
			Customer holder = bc.getHolder();
			if (holder.getIdNr() == idNr) {
				BankAccount newAcc = new BankAccount (holder);
				accounts.add(newAcc);
				return newAcc.getAccountNumber();
			}
		}
		BankAccount newAcc = new BankAccount (holderName, idNr);
		accounts.add(newAcc);
		return newAcc.getAccountNumber();
	}
//	
//	public Customer findHolder(long idNr) {
//		// return this customer or nul
//	}
//	
//	public boolean removeAccount(int number) {
//		
//	}
//	
//	public ArrayList<BankAccount> getAllAccounts(){
//		
//	}
//	
//	public BankAccound findByNumber(int accountNumber) {
//		
//	}
//	
//	public ArrayList<BankAccount> findAccountsForHolder(long idNr){
//		
//	}
//	
//	public ArrayList<Customer> findByPartofName(String namePart){
//		
//	}

}
