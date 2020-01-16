import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private static final int numFaces = 13;
	private static final int numSuits = 4;
	private static final int numCards = 52;
	protected static final String[] deck = {"Two","Three","Four","Five","Six"
			,"Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	
	private static final String[] suit = {"Hearts","Spades","Clubs","Diamonds"};
	
	Random rand= new Random();
	
	private int topCardIndex;
	private ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>(); 
	
	public Deck() {
		topCardIndex = 0;
		for(int i=0; i<numSuits;i++) {
			for(int j=0; j<numFaces;j++) {
				cards.add(new BlackJackCard(deck[j],suit[i]));
			}
		}
	}
	
	public int cardsLeft() {
		return topCardIndex+1;
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
		topCardIndex = numCards-1;
	}
	
	public BlackJackCard nextCard() {
		return cards.get(topCardIndex--);
	}
	
	public String toString(BlackJackCard card) {
		return card.cardName();
	}
}
