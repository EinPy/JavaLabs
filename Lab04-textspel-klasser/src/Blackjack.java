import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        System.out.println(" ____________________________________________\n" + 
                           "|                                            |\n" + 
                           "|  Welcome to the Bratthalls BlackJack Game! |\n" +
                           "|____________________________________________|\n");


        System.out.println("What is your name?");
        String userName = sc.nextLine();

        System.out.println("Hello " + userName + "! Let's play!\n");
        
        //dealers deck
        Deck currentDeck = new Deck();
        currentDeck.createDeck();
        currentDeck.shuffle();
        //System.out.print(currentDeck);
        
        //players deck
        Deck playerDeck = new Deck();
        
        //start game
        boolean playing = true;
        
        while(playing) {
        	playerDeck.draw(currentDeck);
        	playerDeck.draw(currentDeck);
        	
        	while(true) {
        		boolean winner = false;
        		System.out.println("Your hand:\n" + playerDeck.toString() +"Your deck is valued at: " + playerDeck.cardsValue());
        		if (playerDeck.cardsValue() == 21) {
        			System.out.println("BLACKJACK YOU WIN YOU FUCKING BEAST!");
        			winner = true;
        			
        		}else {
        			System.out.println("Do you wish to hit or start over?\n Hit(1), New Hand(2)");
        		}
        		System.out.println("Do you want to play again(2)");
        		int input = sc.nextInt();
        		if (input == 1) {
        			playerDeck.draw(currentDeck);
        			System.out.println("You drew: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
        			if (playerDeck.cardsValue() > 21) {
        				System.out.println("Du ær trash! val: " + playerDeck.cardsValue() + "\n\n");
        				playerDeck.clear();
        				break;
        			}
        		}else {
        			if (winner) {
        				playerDeck.clear();
        			}else {
        				System.out.println("fegis, your hand was valued at: "+ + playerDeck.cardsValue() +" \n\n");
        			}
        			playerDeck.clear();
        			break;
        		}
        	}
        }
	}
}
