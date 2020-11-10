import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.*;

public class CardGameTest {
	CardGame cardGame;
	Vector<Integer> drawnCards;
	int[] discardPileLengthsBefore;
	int[] discardPileLengthsAfter;
	boolean same;
	Vector<Integer> deckBefore;
	Stack<Integer> drawPile;
	Stack<Integer> discardPile;
	Integer drawnCard;

	@Before
	public void setUp() {
		cardGame = new CardGame();
		same = false;
		deckBefore = new Vector<Integer>();
		discardPile = new Stack<Integer>();
		for(int i=1; i<=10; i++) {
			for (int j=0; j<4; j++) {
				deckBefore.add(i);
				if (j<2) {
					discardPile.add(i);
				}
			}
		}		
	}
	
	@After
	public void tearDown() {
        cardGame.clearTotal();		
	}	

	@Test
	public void testGetDeckSize() {
		assertEquals(40, cardGame.getDeckSize());
	}
	
	@Test
	public void testShuffleDeck() {
		for(int i=0; i<10; i++) {
		   assertNotEquals(deckBefore, cardGame.getDeck());
		   cardGame.shuffleDeck();
		}
	}
	
	@Test
	public void testEmptyDrawPile() {
		cardGame.getPlayers()[0].setDrawPile(new Stack<Integer>());
		cardGame.getPlayers()[0].setDiscardPile(discardPile);
		drawnCard = cardGame.getPlayers()[0].drawCard();
		drawPile = cardGame.getPlayers()[0].getDrawPile();
		assertNotEquals(discardPile, drawPile);
		assertEquals(discardPile.size(), drawPile.size());
	}

	@Test
	public void testHigherCardWins() {
		discardPileLengthsBefore = cardGame.getDiscardPileLengths();
		cardGame.drawCards();
		drawnCards = (Vector<Integer>)cardGame.getDrawnCards().clone();
		cardGame.playTurn();
		discardPileLengthsAfter = cardGame.getDiscardPileLengths();
	    assertEquals(discardPileLengthsAfter[0] == discardPileLengthsBefore[0]+2, drawnCards.get(0) > drawnCards.get(1));
	    assertEquals(discardPileLengthsAfter[1] == discardPileLengthsBefore[1]+2, drawnCards.get(0) < drawnCards.get(1));
	}
	
	@Test
	public void testSameCards() {
		cardGame.drawCards();
		drawnCards = (Vector<Integer>)cardGame.getDrawnCards().clone();
		cardGame.playTurn();
		same = drawnCards.get(0) == drawnCards.get(1);
		discardPileLengthsBefore = cardGame.getDiscardPileLengths();
		cardGame.drawCards();
		drawnCards = (Vector<Integer>)cardGame.getDrawnCards().clone();
		cardGame.playTurn();
		discardPileLengthsAfter = cardGame.getDiscardPileLengths();
	    assertEquals((discardPileLengthsAfter[0] == discardPileLengthsBefore[0]+4), same && (drawnCards.get(0) > drawnCards.get(1)));
	    assertEquals((discardPileLengthsAfter[1] == discardPileLengthsBefore[1]+4), same && (drawnCards.get(0) < drawnCards.get(1)));
	}
	
}
