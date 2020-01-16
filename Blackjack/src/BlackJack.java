import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
	Scanner key = new Scanner(System.in);
	private ArrayList<Player> players = new ArrayList<Player>();
	private Dealer dealer;
	private boolean hit;
	private ArrayList<Player> busted = new ArrayList<Player>();
	private Player winCheck;
	private boolean playerWin;
	private String playerScores = " ";
	private int playersBeat;
	
	public BlackJack() {
		System.out.println("How many players will you have (excludes dealer): ");
		int players = key.nextInt();
		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(new Dealer());
		for(int i=0; i<players;i++) {
			playerList.add(new Player());
		}
		dealer= (Dealer) playerList.get(0);
		dealer.shuffle();
	}
	public void playGame() {
		//dealer deals two cards to each player
		for(int i=1;i<players.size();i++) {
			players.get(i).addCard(dealer.deal());
			players.get(i).addCard(dealer.deal());
		}
		//dealer deals two cards to self
		dealer.addCard(dealer.deal());
		dealer.addCard(dealer.deal());
		//player hand value
		for(int i=1; i<players.size();i++) {
			System.out.println("Player " + i + ": " + players.get(i).toString(players.get(i).getHandValue()));
		}
		System.out.println("Dealer: " + dealer.toString(dealer.getHandValue()));
		for(int i=1;i<players.size();i++) {
			hit = players.get(i).hit();
			while(hit==true) {
				players.get(i).addCard(dealer.deal());
				System.out.println("Player" + i +": " + players.get(i).toString(players.get(i).getHandValue()));
				if(players.get(i).getHandValue()>21) {
					System.out.println("Player " + i + " has busted");
					busted.add(players.get(i));
				}
				if(i == players.size()-1 && dealer.hit() == true) {
					dealer.addCard(dealer.deal());
					System.out.println("Dealer: " + dealer.toString(dealer.getHandValue()));
					if(dealer.getHandValue()>21) {
						System.out.println("The dealer has busted");
						busted.add(dealer);
					}
				}
				hit = players.get(i+1).hit();
			}
		}
		//Winner determination
		for(int i=1; i<players.size();i++) {
			winCheck = players.get(i);
			for(int j = 1;j<players.size();j++) {
				if(winCheck.getHandValue() > dealer.getHandValue() && !busted.contains(winCheck) && winCheck.getHandValue() > players.get(j).getHandValue()) {
					playersBeat++;
				}
			}
			if(playersBeat == players.size()-1) {
				System.out.println("Player " + i + " has won");
				playerWin = true;
				winCheck.setWinCount(winCheck.getWinCount()+1);
			}
			
		}
		if(playerWin == false && !busted.contains(dealer)) {
			System.out.println("The dealer has won");
			dealer.setWinCount(dealer.getWinCount()+1);
		}
		else if(playerWin == false) {
			System.out.println("The game is a draw");
		}
		for(int i = 1; i<players.size();i++) {
			playerScores += "Player" + i + "wins: " + players.get(i).getWinCount() + " ";
			System.out.println( playerScores + " Dealer wins: " + dealer.getWinCount());
			System.out.println("Do you want to play again [y,n]: ");
			if(key.next().charAt(0) == 'y') {
				players.get(i).resetHand();
				dealer.resetHand();
				if(dealer.numCards()<=10) {
					dealer.shuffle();
				}
			}
			else {
				System.out.println("Goodbye");
				players.remove(i);
			}
		}
		if(players.size()==1) {
			System.exit(0);
		}
		else {
			playGame();
		}
	}
}
