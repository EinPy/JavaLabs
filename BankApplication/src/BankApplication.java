import java.util.Scanner;

public class BankApplication {
	static Scanner scan = new Scanner(System.in);
	private static Bank bank = new Bank();

	public static void main(String[] args) {
		boolean running = true;
		
		while (running) {
			menue();
			boolean validInput = scan.hasNextInt();
			int option;
			if (!validInput) {
				while (!validInput) {
					System.out.println("Please enter a whole number between 1 and 8");
					String nextIn = scan.nextLine();
					try {
						option = Integer.parseInt(nextIn);
						if (option >= 1 && option <= 8) {
							validInput = true;
							inputHandler(option);
						}else {
							validInput = false;
						}
					} catch (NumberFormatException nfe) {
						validInput = false;
					}
				}	
			}else {
				option = scan.nextInt();
				inputHandler(option);	
			}
			
			

		}
	}
	
	private static void menue() {
		System.out.println(
			"1. Hitta konto utifrån innehavare\r\n"
			+ "2. Sök kontoinnehavare utifrån (del av) namn\r\n"
			+ "3. Sätt in\r\n"
			+ "4. Ta ut\r\n"
			+ "5. Överföring\r\n"
			+ "6. Skapa konto\r\n"
			+ "7. Ta bort konto\r\n"
			+ "8. Skriv ut konton\r\n"
			+ "9. Avsluta\r\n");
	}
	
	private static void inputHandler(int option) {
		switch (option) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			System.out.print("Namn: ");
			String name = scan.nextLine();
			int id = scan.nextInt();
			System.out.print("Konto skapad: ");
			System.out.println(bank.addAccount(name, id));
			break;
		case 7:
			break;
		case 8:
			break;
		}
	}
	
}
