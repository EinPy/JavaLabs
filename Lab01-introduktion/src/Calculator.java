import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double n1 = scan.nextDouble();
		double n2 = scan.nextDouble();
		System.out.println("Summan av talen är " + (n1 + n2));
		System.out.println("Skilnaden mellan talen är " + Math.abs(n1 - n2));
		System.out.println("Produkten av talen är " + (n1 * n2));
		System.out.println("Kvoten mellan talen är " + (n1 / n2) + "\n");

	}

}
