import java.util.Random;

public class CardDeck {

	Random rand = new Random();
	protected static final String[] deck = {"Two","Three","Four","Five","Six"
		,"Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	
	private static final String[] suit = {"Hearts","Spades","Clubs","Diamonds"};
	private int value;
	String cardType;
	String cardSuit;
	
	public CardDeck(String face, String suit) {
		cardType = face;
		cardSuit = suit;
	}
	
	public int getValue(String Card) {
		for(int i=0;i<13;i++) {
			if(cardType.equals(deck[i])) {
				value = i+2;
			}
			else if(cardType.equals(deck[12])) {
				value = 1;
			}
		}
		return value;
	}
}
	
class BlackJackCard extends CardDeck{
	private String card;
	private int value;
	
	public BlackJackCard(String face, String suit) {
		super(face, suit);
	}
	
	public String cardName() {
		card = cardType + " of " + cardSuit;
		return card;
	}
	
	public int getValue(){
		for(int i=0;i<super.deck.length;i++) {
			if(cardType.equals(deck[i])) {
				if(i<9) {
					value = i+2;
				}
				else if(i>=9 && i!=12) {
					value = 10;
				}
				else if(i==12){
					value = 11;
				}
			}
		}
		return value;
	}
	
}
