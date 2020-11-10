
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardGame cardGame = new CardGame();
		while(!cardGame.getDone()) {
			cardGame.drawCards();
			cardGame.playTurn();
		}

	}

}
