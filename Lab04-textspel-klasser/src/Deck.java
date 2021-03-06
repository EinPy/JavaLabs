import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> cards;
	
	//konstruktor
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public void createDeck() {
		//genererar kort
		for (Suit cardSuit : Suit.values()) {
			for (Value val : Value.values()) {
				//legg til 1 og 1 av 52 kort
				this.cards.add(new Card(cardSuit, val));
			}
		}
	}
	
	public void shuffle() {
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		//anvender random modulen
		Random r = new Random();
		int rIndex = 0;
		int orgSize = this.cards.size();
		for (int i = 0; i < orgSize; i++) {
			// -1 pga av det ær 0 indekserat
			rIndex = r.nextInt((this.cards.size()-1) + 1) + 0;
			tmpDeck.add(this.cards.get(rIndex));
			this.cards.remove(rIndex);
		}
		this.cards = tmpDeck;
	}
	
	public String toString() {
		String out = "";
		for (Card c : this.cards) {
			out += c.toString() + "\n";
		}
		return out;
	}
	
	public int deckSize() {
		return this.cards.size();
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	public void clear() {
		int cards = deckSize();
		for (int i = 0; i < cards; i++) {
			removeCard(0);
		}
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public void addCard(Card newCard){
		this.cards.add(newCard);
	}
	
	public void draw(Deck from) {
		this.cards.add(from.getCard(0));
		from.removeCard(0);
	}
	
	public int cardsValue() {
		int v = 0;
		int aces = 0;
		
		for(Card aCard : this.cards) {
			switch(aCard.getValue()) {
			case TWO: v += 2; break;
			case THREE: v += 3; break;
			case FOUR: v += 4; break;
			case FIVE: v += 5; break;
			case SIX: v += 6; break;
			case SEVEN: v += 7; break;
			case EIGHT: v += 8; break;
			case NINE: v += 9; break;
			case TEN: v += 10; break;
			case JACK: v += 10; break;
			case QUEEN: v += 10; break;
			case KING: v += 10; break;
			case ACE: aces +=1; break;
			}
		}
		if (aces >0) {
			for(int i = 0; i < aces;i++) {
				if (v+11 <= 21) {
					v+=11;
				}else {
					v += 1;
				}
			}
		}
		return v;
	}
	
}
