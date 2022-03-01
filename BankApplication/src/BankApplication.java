import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	private static Scanner scan = new Scanner(System.in);
	private static Bank bank = new Bank();

	public static void main(String[] args) {
		boolean running = true;
		
		while (running) {
			menue();
			boolean takingInput = true;
			int option;
			String in = scan.nextLine();
			while (takingInput) {
				try {
					option = Integer.parseInt(in);
					if (option >= 1 && option <= 9) {
						inputHandler(option);
						takingInput = false;
						break;
					}else {
						in = errorMessage();
					}
				} catch (NumberFormatException nfe){
					in = errorMessage();
				}
				
			}
		}
	}
	
	private static void menue() {
		System.out.print(
			"1. Hitta konto utifrrÂn innehavare\r\n"
			+ "2. Sˆk kontoinnehavare utifrÂnn (del av) namn\r\n"
			+ "3. S‰tt in\r\n"
			+ "4. Ta ut\r\n"
			+ "5. ÷verfˆring\r\n"
			+ "6. Skapa konto\r\n"
			+ "7. Ta bort konto\r\n"
			+ "8. Skriv ut konton\r\n"
			+ "9. Avsluta\r\n"
			+ "val: ");
	}
	
	private static String errorMessage() {
		System.out.println("Please enter a whole number between 1 and 8");
		return scan.nextLine();
	}
	
	private static void inputHandler(int option) {
		switch (option) {
		case 1:{
			System.out.print("Id: ");
			String idNum = scan.nextLine();
			long idSearch = Long.parseLong(idNum);
			ArrayList<BankAccount> portefolio = bank.findAccountsForHolder(idSearch);
			for (BankAccount acc : portefolio) {
				System.out.println(acc);
			}
			break;
		}
		case 2:
			System.out.print("Part of name: ");
			String namePart = scan.nextLine();
			ArrayList<Customer> customers = bank.findByPartofName(namePart);
			if (customers.size() == 0) {
				System.out.println("No customers found");
			}
			for(Customer cust : customers) {
				System.out.println(cust);
			}
			break;
			
		case 3:
			System.out.print("Konto: ");
			String toAdd = scan.nextLine();
			int accNum = Integer.parseInt(toAdd);
			System.out.print("Belopp: ");
			String amountS = scan.nextLine();
			double value = Double.parseDouble(amountS);
			BankAccount acc = bank.findByNumber(accNum);
			if (acc == null) {
				System.out.println("Not a valid account number");
			}else {
				if (value >= 0) {
					acc.deposit(value);
					System.out.println(acc);
				}else {
					System.out.println("cannot insert negative money");
				}
				
			}
			
			break;
			
		case 4:
			System.out.print("Fr√•n konto: ");
			String from = scan.nextLine();
			int fromA = Integer.parseInt(from);
			System.out.print("Belopp: ");
			String val = scan.nextLine();
			double money = Double.parseDouble(val);
			BankAccount frm = bank.findByNumber(fromA);
			
			if (frm == null) {
				System.out.println("Not a valid account number");
			} else if (money < frm.getAmount()) {
				frm.withdraw(money);
				System.out.println("Velyckad transaktion, uppdaterad saldo: ");
				System.out.println(frm);
			} else {
				System.out.printf("uttaget misslyckades, endast %.2f pÂ kontot!\n", frm.getAmount());
			}
			break;
			
		case 5:
			System.out.print("Fr√•n konto: ");
			String from1 = scan.nextLine();
			int fromA1 = Integer.parseInt(from1);
			System.out.print("Til konto: ");
			String to = scan.nextLine();
			int toI = Integer.parseInt(to);
			System.out.print("Belopp: ");
			String v = scan.nextLine();
			double amount = Double.parseDouble(v);
			
			BankAccount fr = bank.findByNumber(fromA1);
			BankAccount reciever = bank.findByNumber(toI);
			
			if (fr == null || reciever == null) {
				System.out.println("Not a valid account number");
			} else if (amount < fr.getAmount()) {
				fr.withdraw(amount);
				reciever.deposit(amount);
				System.out.println("Velyckad transaktion, uppdaterade kontodetaljer: ");
				System.out.println(fr);
				System.out.println(reciever);
			}else {
				System.out.printf("uttaget misslyckades, endast %.2f p√• kontot!\n", fr.getAmount());
			}
			break;
			
		case 6:
			System.out.print("Namn: ");
			String name = scan.nextLine();
			System.out.print("Id: ");
			String idS = scan.nextLine();
			long id = Long.parseLong(idS);
			System.out.print("Konto skapad: ");
			System.out.println(bank.addAccount(name, id));
			break;
			
		case 7:
			System.out.print("Konto: ");
			String konto  = scan.nextLine();
			int k = Integer.parseInt(konto);
			boolean removed = bank.removeAccount(k);
			if(removed) {
				System.out.println("konto tatt bort");
			}else {
				System.out.println("hittade inte et konto med det kontonumret");
			}
			break;
			
		case 8:{
			ArrayList<BankAccount> portefolio = bank.getAllAccounts();
			for (BankAccount a : portefolio) {
				System.out.println(a);
			}
			break;
		}
		case 9:
			System.exit(0);
			break;
		}
		System.out.println("--------------------------------");
	}
	
}
