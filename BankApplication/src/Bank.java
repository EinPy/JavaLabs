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
				insertSorted(newAcc);
				return newAcc.getAccountNumber();
			}
		}
		BankAccount newAcc = new BankAccount (holderName, idNr);
		insertSorted(newAcc);
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
	public ArrayList<BankAccount> getAllAccounts(){
		return accounts;
	}
	
	public BankAccount findByNumber(int accountNumber) {
		for (BankAccount acc : accounts) {
			if (acc.getAccountNumber() == accountNumber) {
				return acc;
			}
		}
		return null;
		
	}
	
	public ArrayList<BankAccount> findAccountsForHolder(long idNr){
		ArrayList<BankAccount> portefolio = new ArrayList<BankAccount>();
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getIdNr() == idNr) {
				portefolio.add(acc);
			}
		}
		return portefolio;
	}
	
	public ArrayList<Customer> findByPartofName(String namePart){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getName().contains(namePart)) {
				customers.add(acc.getHolder());
			}
		}
		return customers;
	}
	
	private void insertSorted(BankAccount bankAcc) {
		int pos = 0;
		//ugly
		if (accounts.size()>0) {
			while(pos < accounts.size() && accounts.get(pos).getHolder().getName().compareTo(bankAcc.getHolder().getName()) < 0) {
				pos++;
			}
		}
		accounts.add(pos,bankAcc);
	}

}
