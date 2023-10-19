import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Play {

	private Shoe shoe;
	private Shoe discard;
	private List<Card> dealer;
	private List<Card> player;
	private int playerCount;
	private int dealerCount;

	public Play() {
		shoe = new Shoe(1);
		shoe.shuffle();
		discard = new Shoe();

		Scanner scanner = new Scanner(System.in);
		boolean quit = false;

		while(!quit) {
			if(shoe.getShoe().size() < 15) {
				shoe = new Shoe(1);
				shoe.shuffle();
				discard = new Shoe();
			}
			System.out.println("Type 'q' to quit, or 'd' to deal.");
			String action = scanner.nextLine();
			if(action.equals("q")) {
				quit = true;
			}
			else if(action.equals("d")) {
				System.out.print("\033[H\033[2J");
				deal();
				boolean stillPlaying = true;
				boolean checkForInsurance = true;
				int aceCount = 0;
				if(player.get(0).getPointValue() == 11) {
					aceCount++;
				}
				if(player.get(1).getPointValue() == 11) {
					aceCount++;
				}
				while(stillPlaying) {
					boolean playerTurn = true;
					while(playerTurn){
						if(checkForInsurance && dealer.get(1).getPointValue() == 11) {
							boolean invalidOption = true;
							printCurrentHand(true);
							System.out.println("The dealer has 11. Would you like insurance? (y/n)");
							while(invalidOption){
								String insurance = scanner.nextLine();
								if(insurance.equals("y")) {
									System.out.print("\033[H\033[2J");
									invalidOption = false;
									System.out.println("You purchased insurance.");
									if(dealer.get(0).getPointValue() == 10) {
										System.out.println("The dealer has blackjack.");
										if(playerCount == 21) {
											System.out.println("You push.");
										}
										else {
											System.out.println("Your insurance pays out.");
										}
										printCurrentHand(false);
										stillPlaying = false;
										playerTurn = false;
									}
									else {
										System.out.println("The dealer does not have blackjack.");
										System.out.println("Your insurance is lost.");
									}
								}
								else if(insurance.equals("n")) {
									System.out.print("\033[H\033[2J");
									invalidOption = false;
									System.out.println("You declined insurance.");
									if(dealer.get(0).getPointValue() == 10) {
										System.out.println("The dealer has blackjack.");
										if(playerCount == 21) {
											System.out.println("You push.");
										}
										else {
											System.out.println("You lost.");
										}
										printCurrentHand(false);
										stillPlaying = false;
										playerTurn = false;
									}
									else {
										System.out.println("The dealer does not have blackjack.");
										System.out.println("Your insurance is lost.");
									}
								}
								else {
									System.out.println("Type y for insurance or n for no insurance");
								}
							}
							checkForInsurance = false;
						}
						else if(playerCount > 21) {
							if(aceCount > 0) {
								playerCount -= 10;
								aceCount--;
								boolean invalidOption = true;
								while(invalidOption){
									printCurrentHand(true);
									System.out.println("You have " + playerCount + ". The dealer has " + dealer.get(1).getPointValue() + ".\nType 'h' to hit, or 's' to stand.");
									String hitOrStand = scanner.nextLine();
									if(hitOrStand.equals("h")) {
										invalidOption = false;
										dealToPlayer();
										System.out.print("\033[H\033[2J");
									}
									else if(hitOrStand.equals("s")) {
										invalidOption = false;
										playerTurn = false;
										System.out.print("\033[H\033[2J");
									}
									else {
										System.out.print("\033[H\033[2J");
										System.out.println("Not a valid option.");
									}
								}
							}
							else {
								printCurrentHand(false);
								System.out.println("You have " + playerCount + ". You bust.\n");
								stillPlaying = false;
								playerTurn = false;
							}
						}
						else if(playerCount == 21) {
							boolean invalidOption = true;
							printCurrentHand(true);
							System.out.println("You have 21! Let's see what the dealer gets... (type 's' to stand)");
							while(invalidOption){
								String onlyStand = scanner.nextLine();
								if(onlyStand.equals("s")){
									invalidOption = false;
									playerTurn = false;
									System.out.print("\033[H\033[2J");
								}
								else {
									System.out.println("No, type 's' please.");
								}
							}
						}
						else {
							boolean invalidOption = true;
							while(invalidOption){
								printCurrentHand(true);
								if (aceCount > 0) {
									System.out.println("You have a soft " + playerCount  + ". The dealer has " + dealer.get(1).getPointValue() + ".\nType 'h' to hit, or 's' to stand.");
								}
								else {
									System.out.println("You have " + playerCount + ". The dealer has " + dealer.get(1).getPointValue() + ".\nType 'h' to hit, or 's' to stand.");
								}
								String hitOrStand = scanner.nextLine();
								if(hitOrStand.equals("h")) {
									invalidOption = false;
									dealToPlayer();
									if(player.get(player.size()-1).getPointValue() == 11) {
										aceCount++;
									}
									System.out.print("\033[H\033[2J");
								}
								else if(hitOrStand.equals("s")) {
									invalidOption = false;
									playerTurn = false;
									System.out.print("\033[H\033[2J");
								}
								else {
									System.out.print("\033[H\033[2J");
									System.out.println("Not a valid option.");
								}
							}
						}
					}
					//dealer turn
					boolean dealerTurn = true;
					while(stillPlaying && dealerTurn){
						printCurrentHand(false);
						System.out.println("You have " + playerCount + ". The dealer has " + dealerCount + ".\n");
						if(dealerCount > 21) {
							System.out.println("The dealer bust. You win!\n");
							stillPlaying = false;
							dealerTurn = false;
						}
						else if(dealerCount >= 17) {
							System.out.println("The dealer stands.");
							if(playerCount > dealerCount) {
								System.out.println("You win!! Congratulations.\n");
							}
							else if (playerCount == dealerCount) {
								System.out.println("You push. Could be worse.\n");
							}
							else {
								System.out.println("You lose. Too bad.\n");
							}
							stillPlaying = false;
							dealerTurn = false;
						}
						else {
							boolean invalidOption = true;
							while(invalidOption) {
								System.out.println("The dealer hits. Type 'c' to continue.");
								String continueInput = scanner.nextLine();
								if(continueInput.equals("c")) {
									invalidOption = false;
								}
								System.out.print("\033[H\033[2J");
							}
							dealToDealer();
						}
					}

					stillPlaying = false;
				}

			}
			else {
				System.out.print("\033[H\033[2J");
				System.out.println("Not a valid option. Try again.\n");
			}
		}
	}

	private void deal() {
		dealer = new ArrayList<Card>();
		player = new ArrayList<Card>();
		dealerCount = 0;
		playerCount = 0;
		dealToPlayer();
		dealToDealer();
		dealToPlayer();
		dealToDealer();
	}

	private void dealToPlayer() {
		Card c = shoe.getCardFromShoe(0);
		player.add(c);
		discard.addCardToShoe(c);
		playerCount += c.getPointValue();
		shoe.removeCardFromShoeAtIndex(0);
	}

	private void dealToDealer() {
		Card c = shoe.getCardFromShoe(0);
		dealer.add(c);
		discard.addCardToShoe(c);
		dealerCount += c.getPointValue();
		shoe.removeCardFromShoeAtIndex(0);
	}

	private void printCurrentHand(boolean hidden) {
		String dealerHand = "Dealer: ";
		String playerHand = "Player: ";
		for(int i = 0; i < dealer.size(); i++) {
			if(i == 0 && hidden == true) {
				dealerHand += "**, ";
			}
			else if(i == dealer.size() - 1) {
				dealerHand += "" + dealer.get(i).getName() + dealer.get(i).getSuit() + "\n";
			}
			else {
				dealerHand += "" + dealer.get(i).getName() + dealer.get(i).getSuit() + ", ";
			}
		}
		for(int i = 0; i < player.size(); i++) {
			if(i == player.size() - 1) {
				playerHand += "" + player.get(i).getName() + player.get(i).getSuit() + "\n";
			}
			else {
				playerHand += "" + player.get(i).getName() + player.get(i).getSuit() + ", ";
			}
		}
		System.out.println(dealerHand);
		System.out.println(playerHand);
	}

}