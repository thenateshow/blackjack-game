import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private List<Card> fullDeck;

	public Deck() {

		fullDeck = new ArrayList<Card>();

	}

	public void initFullDeck() {
		fullDeck.add(new Card('2', "Two", 2, 'S', "Spades"));
		fullDeck.add(new Card('3', "Three", 3, 'S', "Spades"));
		fullDeck.add(new Card('4', "Four", 4, 'S', "Spades"));
		fullDeck.add(new Card('5', "Five", 5, 'S', "Spades"));
		fullDeck.add(new Card('6', "Six", 6, 'S', "Spades"));
		fullDeck.add(new Card('7', "Seven", 7, 'S', "Spades"));
		fullDeck.add(new Card('8', "Eight", 8, 'S', "Spades"));
		fullDeck.add(new Card('9', "Nine", 9, 'S', "Spades"));
		fullDeck.add(new Card('T', "Ten", 10, 'S', "Spades"));
		fullDeck.add(new Card('J', "Jack", 10, 'S', "Spades"));
		fullDeck.add(new Card('Q', "Queen", 10, 'S', "Spades"));
		fullDeck.add(new Card('K', "King", 10, 'S', "Spades"));
		fullDeck.add(new Card('A', "Ace", 11, 'S', "Spades"));

		fullDeck.add(new Card('2', "Two", 2, 'C', "Clubs"));
		fullDeck.add(new Card('3', "Three", 3, 'C', "Clubs"));
		fullDeck.add(new Card('4', "Four", 4, 'C', "Clubs"));
		fullDeck.add(new Card('5', "Five", 5, 'C', "Clubs"));
		fullDeck.add(new Card('6', "Six", 6, 'C', "Clubs"));
		fullDeck.add(new Card('7', "Seven", 7, 'C', "Clubs"));
		fullDeck.add(new Card('8', "Eight", 8, 'C', "Clubs"));
		fullDeck.add(new Card('9', "Nine", 9, 'C', "Clubs"));
		fullDeck.add(new Card('T', "Ten", 10, 'C', "Clubs"));
		fullDeck.add(new Card('J', "Jack", 10, 'C', "Clubs"));
		fullDeck.add(new Card('Q', "Queen", 10, 'C', "Clubs"));
		fullDeck.add(new Card('K', "King", 10, 'C', "Clubs"));
		fullDeck.add(new Card('A', "Ace", 11, 'C', "Clubs"));

		fullDeck.add(new Card('2', "Two", 2, 'H', "Hearts"));
		fullDeck.add(new Card('3', "Three", 3, 'H', "Hearts"));
		fullDeck.add(new Card('4', "Four", 4, 'H', "Hearts"));
		fullDeck.add(new Card('5', "Five", 5, 'H', "Hearts"));
		fullDeck.add(new Card('6', "Six", 6, 'H', "Hearts"));
		fullDeck.add(new Card('7', "Seven", 7, 'H', "Hearts"));
		fullDeck.add(new Card('8', "Eight", 8, 'H', "Hearts"));
		fullDeck.add(new Card('9', "Nine", 9, 'H', "Hearts"));
		fullDeck.add(new Card('T', "Ten", 10, 'H', "Hearts"));
		fullDeck.add(new Card('J', "Jack", 10, 'H', "Hearts"));
		fullDeck.add(new Card('Q', "Queen", 10, 'H', "Hearts"));
		fullDeck.add(new Card('K', "King", 10, 'H', "Hearts"));
		fullDeck.add(new Card('A', "Ace", 11, 'H', "Hearts"));

		fullDeck.add(new Card('2', "Two", 2, 'D', "Diamonds"));
		fullDeck.add(new Card('3', "Three", 3, 'D', "Diamonds"));
		fullDeck.add(new Card('4', "Four", 4, 'D', "Diamonds"));
		fullDeck.add(new Card('5', "Five", 5, 'D', "Diamonds"));
		fullDeck.add(new Card('6', "Six", 6, 'D', "Diamonds"));
		fullDeck.add(new Card('7', "Seven", 7, 'D', "Diamonds"));
		fullDeck.add(new Card('8', "Eight", 8, 'D', "Diamonds"));
		fullDeck.add(new Card('9', "Nine", 9, 'D', "Diamonds"));
		fullDeck.add(new Card('T', "Ten", 10, 'D', "Diamonds"));
		fullDeck.add(new Card('J', "Jack", 10, 'D', "Diamonds"));
		fullDeck.add(new Card('Q', "Queen", 10, 'D', "Diamonds"));
		fullDeck.add(new Card('K', "King", 10, 'D', "Diamonds"));
		fullDeck.add(new Card('A', "Ace", 11, 'D', "Diamonds"));
	}

	public void shuffle() {
		List<Card> tempDeck = new ArrayList<Card>();
		Random random = new Random();
		while(fullDeck.size() > 0) {
			int nextIndex = random.nextInt(fullDeck.size());
			tempDeck.add(fullDeck.get(nextIndex));
			fullDeck.remove(nextIndex);
		}
		fullDeck = tempDeck;
	}

	public void addCardToDeck(Card c) {
		fullDeck.add(c);
	}

	public void removeCardFromDeckAtIndex(int i) {
		fullDeck.remove(i);
	}

	public List<Card> getFullDeck() {
		return fullDeck;
	}

	public String toString() {
		String output = "";
		for(Card c : fullDeck) {
			output += c.toString() + "\n";
		}
		return output;
	}

}