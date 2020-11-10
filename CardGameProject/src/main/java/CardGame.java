import java.util.*;

public class CardGame {
	private final static int numberOfPlayers=2;
	private final static int numberOfCards=40;
	private final static int numberOfSuits=4;
	private Vector<Integer> deck;
	private Player[] players;
	private Vector<Integer> drawnCards;
	private Vector<Integer> drawnSameValueCards;
	private boolean done = false;

    
	CardGame(){
        initDeck();
        initPlayers();
        drawnCards = new Vector<Integer>();
        drawnSameValueCards = new Vector<Integer>();
	}
	
	private void initDeck() {
		deck = new Vector<Integer>();
		for(int i=1; i<=(numberOfCards/numberOfSuits); i++) {
			for (int j=0; j<numberOfSuits; j++) {
				deck.add(i);
			}
		}
		shuffleDeck();
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	private void initPlayers() {
		players = new Player[numberOfPlayers];
		for(int k=0; k<numberOfPlayers; k++) {
			List<Integer> drawPileList = ((Vector<Integer>)deck.clone()).subList(k*numberOfCards/numberOfPlayers, (k+1)*numberOfCards/numberOfPlayers);
			Stack<Integer> drawPile = new Stack<Integer>();
			Integer elem;
			while(!drawPileList.isEmpty()) {
				elem = (Integer)drawPileList.remove(0);
				drawPile.add(elem);
			}
			players[k] = new Player(drawPile); 
		}
	}

	public void clearTotal() {
		Player.total = 0;
	}
	
	public void drawCards(){
		for(int k=0; k<numberOfPlayers; k++) {		
			drawnCards.add(players[k].drawCard());
		}
		if(!drawnCards.contains(null)) {
			for(int k=0; k<numberOfPlayers; k++) {		
				System.out.println(players[k]);
			}			
		}
	}
	
	public void playTurn() {
		int indexOfNull = drawnCards.indexOf(null);
		if(indexOfNull != -1) {
			for(int k=0; k<numberOfPlayers; k++) {		
				if (k != indexOfNull) {
					System.out.println("Player " + players[k].id + " wins the game\n");
				}
			}
			done = true;
			return;
	    }
		int max = Collections.max(drawnCards);
		int firstMaxIndex = drawnCards.indexOf(max);
		int lastMaxIndex = drawnCards.lastIndexOf(max);

		if (firstMaxIndex == lastMaxIndex) {
			players[firstMaxIndex].wonRound = true;
			players[firstMaxIndex].discardPile.addAll(drawnCards);
			if (!drawnSameValueCards.isEmpty()) {
				players[firstMaxIndex].discardPile.addAll(drawnSameValueCards);
				drawnSameValueCards.clear();
			}
			System.out.println("Player " + players[firstMaxIndex].id + " wins this round\n");
		}else {
			System.out.println("No winner in this round\n");
		}
		drawnCards.clear();
		int drawnCard;	
		for(int k=0; k<numberOfPlayers; k++) {
			if ((firstMaxIndex != lastMaxIndex) && (players[k].drawPile.lastElement() == max)) {
				drawnCard = players[k].drawPile.pop();
				drawnSameValueCards.add(drawnCard);	
			} else {		
				drawnCard = players[k].drawPile.pop();
			}
		}
	}
	
	public boolean getDone() {
		return done;
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public int[] getDiscardPileLengths() {
		int[] discardPileLengts = new int[players.length];
		for(int i=0; i<players.length; i++) {
			discardPileLengts[i] = players[i].discardPile.size();
		}
		return discardPileLengts;
	}
	
	public Vector<Integer> getDrawnCards() {
		return drawnCards;
	}
	
	public Vector<Integer> getDeck() {
		return deck;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
}
