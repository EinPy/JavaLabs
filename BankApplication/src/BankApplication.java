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
	
	private static String errorMessage() {
		System.out.println("Please enter a whole number between 1 and 8");
		return scan.nextLine();
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
			System.out.print("\nId: ");
			String idS = scan.nextLine();
			long id = Long.parseLong(idS);
			System.out.print("Konto skapad: ");
			System.out.println(bank.addAccount(name, id));
			break;
		case 7:
			break;
		case 8:
			break;
		}
		System.out.println("--------------------------------");
	}
	
}
