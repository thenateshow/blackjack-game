public class Card {

	char name;
	String fullName;
	int pointValue;
	char suit;
	String fullSuit;
	
	public Card(char name, String fullName, int pointValue, char suit, String fullSuit) {
		this.name = name;
		this.fullName = fullName;
		this.pointValue = pointValue;
		this.suit = suit;
		this.fullSuit = fullSuit;
	}

	public void setName(char name) {
		this.name = name;
	}
	public char getName() {
		return name;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}
	public int getPointValue() {
		return pointValue;
	}
	public void setSuit(char suit) {
		this.suit = suit;
	}
	public char getSuit() {
		return suit;
	}
	public void setFullSuit(String fullSuit) {
		this.fullSuit = fullSuit;
	}
	public String getFullSuit() {
		return fullSuit;
	}

	public String toString() {
		return "This is the " + fullName + " of " + fullSuit + ", abbreviated as " + name + suit + ", point value " + pointValue + ".";
	}


}