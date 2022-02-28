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
					if (option >= 1 && option <= 8) {
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
			"1. Hitta konto utifr�n innehavare\r\n"
			+ "2. S�k kontoinnehavare utifr�n (del av) namn\r\n"
			+ "3. S�tt in\r\n"
			+ "4. Ta ut\r\n"
			+ "5. �verf�ring\r\n"
			+ "6. Skapa konto\r\n"
			+ "7. Ta bort konto\r\n"
			+ "8. Skriv ut konton\r\n"
			+ "9. Avsluta\r\n");
	}
	
	private static String errorMessage() {
		System.out.println("Please enter a whole number between 1 and 8");
		return scan.nextLine();
	}
	
	private static void inputHandler(int option) {
		switch (option) {
		case 1:
			System.out.print("Id: ");
			String idNum = scan.nextLine();
			long idSearch = Long.parseLong(idNum);
			ArrayList<BankAccount> portefolio = bank.findAccountsForHolder(idSearch);
			for (BankAccount acc : portefolio) {
				System.out.println(acc);
			}
			break;
		case 2:
			System.out.print("Part of name: ");
			String namePart = scan.nextLine();
			ArrayList<Customer> customers = bank.findByPartofName(namePart);
			for(Customer cust : customers) {
				System.out.println(cust);
			}
			break;
		case 3:
			System.out.print("Konto: ");
			String toAdd = scan.nextLine();
			System.out.print("Belopp: ");
			String amountS = scan.nextLine();
			long value = Long.parseLong(amountS);
			
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			System.out.print("Namn: ");
			String name = scan.nextLine();
			System.out.print("\nId: ");
			String idS = scan.nextLine();
			long id = Long.parseLong(idS);
			System.out.print("Konto skapad: ");
			System.out.println(bank.addAccount(name, id));
			break;
		case 7:
			break;
		case 8:
			ArrayList<BankAccount> accounts = bank.getAllAccounts();
			for (BankAccount acc : accounts) {
				System.out.println(acc);
			}
			break;
		}
		System.out.println("--------------------------------");
	}
	
}