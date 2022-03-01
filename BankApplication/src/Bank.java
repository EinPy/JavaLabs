import java.util.ArrayList;
import java.util.HashSet;

public class Bank {
	private ArrayList<BankAccount> accounts;
	
	//new bank without accounts
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}
	
	//adds account to bank
	public int addAccount(String holderName, long idNr) {
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
	
	//finds user with id number
	public Customer findHolder(long idNr) {
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getIdNr() == idNr) {
				return acc.getHolder();
			}
		}
		return null;
	}
	
	//removes account
	public boolean removeAccount(int number) {
		int pos = 0, ind = 0;
		boolean found = false;
		for (BankAccount acc : accounts) {
			if (acc.getAccountNumber() == number) {
				found = true;
				ind = pos;
			}
			pos += 1;
		}
		//shifts all account to the right of index one step left
		if (found && ind != accounts.size()-1) {
			for (int i = ind+1; i < accounts.size(); i++) {
				accounts.set(i-1,accounts.get(i));
			}
		}else if (!found) {
			return false;
		}
		accounts.remove(accounts.size()-1);
		return true;
		
		
	}
	
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
	
	// finds all the accounts of a certain person
	public ArrayList<BankAccount> findAccountsForHolder(long idNr){
		ArrayList<BankAccount> portefolio = new ArrayList<BankAccount>();
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getIdNr() == idNr) {
				portefolio.add(acc);
			}
		}
		return portefolio;
	}
	
	//find all people with namePart, hashSet to keep track of customers
	public ArrayList<Customer> findByPartofName(String namePart){
		ArrayList<Customer> customers = new ArrayList<Customer>();
		HashSet<String> seen = new HashSet<String>();
		for (BankAccount acc : accounts) {
			if (acc.getHolder().getName().toLowerCase().contains(namePart.toLowerCase()) && !seen.contains(acc.getHolder().getName())) {
				customers.add(acc.getHolder());
				seen.add(acc.getHolder().getName());
			}
		}
		return customers;
	}
	
	private void insertSorted(BankAccount bankAcc) {
		int pos = 0;
		if (accounts.size()>0) {
			//better way to do this?
			while(pos < accounts.size() && accounts.get(pos).getHolder().getName().compareTo(bankAcc.getHolder().getName()) < 0) {
				pos++;
			}
		}
		accounts.add(pos,bankAcc);
	}

}
