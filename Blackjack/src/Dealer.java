public class Dealer extends Player{
	Deck deck = new Deck();
	private boolean hit;
	Dealer(){
		super();
		hit = true;
	}
	public void shuffle() {
		deck.shuffle();
	}
	public BlackJackCard deal() {
		return deck.nextCard();
	}
	public int numCards() {
		return deck.cardsLeft();
	}
	public boolean hit() {
		if(getHandValue() >19) {
			hit = false;
		}
		else {
			hit = true;
		}
		return hit;
	}
}
