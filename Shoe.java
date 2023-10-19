import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Shoe {
	
	private List<Card> shoe;

	public Shoe(){
		shoe = new ArrayList<Card>();
	}

	public Shoe(int numDecks) {
		shoe = new ArrayList<Card>();
		for(int i = 0; i < numDecks; i++) {
			Deck deck = new Deck();
			deck.initFullDeck();
			for(Card c : deck.getFullDeck()){
				shoe.add(c);
			}
		}
	}

	public void shuffle() {
		List<Card> tempDeck = new ArrayList<Card>();
		Random random = new Random();
		while(shoe.size() > 0) {
			int nextIndex = random.nextInt(shoe.size());
			tempDeck.add(shoe.get(nextIndex));
			shoe.remove(nextIndex);
		}
		shoe = tempDeck;
	}

	public List<Card> getShoe() {
		return shoe;
	}

	public void addCardToShoe(Card c) {
		shoe.add(c);
	}

	public void removeCardFromShoeAtIndex(int i) {
		shoe.remove(i);
	}

	public Card getCardFromShoe(int i) {
		return shoe.get(i);
	}

	public String toString() {
		String output = "";
		for(Card c : shoe) {
			output += c.toString() + "\n";
		}
		return output;
	}
}