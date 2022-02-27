import java.util.Scanner;

public class BankApplication {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean running = true;
		while (running) {
			run();
			boolean validInput = scan.hasNextInt();
			while (!validInput) {
				System.out.println("Please enter a whole number between 1 and 8");
				validInput = scan.hasNextInt();
			}
			int option = scan.nextInt();
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
				break;
			case 7:
				break;
			case 8:
				break;
			}

		}
	}
		run();
		int test = scan.nextInt();
		run();
		test = scan.nextInt();
	}
	
	
	private static void run() {
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
	
}
