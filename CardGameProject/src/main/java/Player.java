import java.util.*;

public class Player {
	protected Stack<Integer> drawPile;
	protected Stack<Integer> discardPile;
	protected boolean lostGame = false;
	protected boolean wonRound = false;
	protected static int total = 0;
	protected int id = ++total;
	
	Player(Stack<Integer> drp){
		drawPile = drp;
		discardPile = new Stack<Integer>();
	}

	public void setDrawPile(Stack<Integer> drp) {
		drawPile = (Stack<Integer>)drp.clone();
	}
	
	public Stack<Integer> getDrawPile() {
		return drawPile;
	}	
	
	public void setDiscardPile(Stack<Integer> dip) {
		discardPile = (Stack<Integer>)dip.clone();
	}	
	
	public void setNewDrawPile() {
		drawPile = (Stack<Integer>)discardPile.clone();
	}
	
	public Integer drawCard() {
		wonRound = false;
		if (drawPile.empty()) {
			if (discardPile.empty()) {
				lostGame = true;
				return null;
			}
			Collections.shuffle(discardPile);
			setNewDrawPile();
			discardPile.clear();
		}
		return drawPile.lastElement();		
	}
	
	
	public String toString() {
		String str = "Player " + id + " (" + (drawPile.size()+discardPile.size()) + " cards): " + drawPile.lastElement();
		return str;
	}	
}
