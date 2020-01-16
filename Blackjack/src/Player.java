import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	Scanner key = new Scanner(System.in);
	private ArrayList<BlackJackCard> hand = new ArrayList<BlackJackCard>();
	private int winCount;
	private int handValue;
	private boolean hit;
	private char res;
	
	public Player() {
		winCount = 0;
		handValue = 0;
		res = 'a';
	}
	public Player(int score) {
		handValue = score;
	}
	public void addCard(BlackJackCard temp) {
		hand.add(temp);
	}
	public void resetHand() {
		hand.clear();
	}
	public void setWinCount(int wins) {
		winCount = wins;
	}
	public int getWinCount() {
		return winCount;
	}
	public int getHandSize() {
		return hand.size();
	}
	public int getHandValue() {
		handValue = 0;
		for(int i=0;i<hand.size();i++) {
			handValue += hand.get(i).getValue();
		}
		return handValue;
	}
	public boolean hit() {
		System.out.println("Do you want to hit? [y,n] ");
		res = key.next().charAt(0);
		if(res != 'y') {
			hit = false;
		}
		else {
			hit = true;
		}
		return hit;
	}
	public String toString(int handValue) {
		String handCards = "";
		for(int i=0; i<hand.size(); i++) {
			handCards += hand.get(i).cardName()+ " | ";
		}
		return handCards + handValue;
	}
}