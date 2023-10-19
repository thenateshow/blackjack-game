import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		System.out.print("\033[H\033[2J");
		while(!exit){
			System.out.println("1 - Play Blackjack");
			System.out.println("\nq - Quit");
			String choice = scanner.nextLine();
			if(choice.equals("q")) {
				System.out.println("Bye!!");
				exit = true;
			}
			else if(choice.equals("1")) {
				System.out.print("\033[H\033[2J");
				Play player = new Play();
				System.out.print("\033[H\033[2J");
				System.out.println("Thanks for playing!\n* * * * * * * * * *");
			}
			else {
				System.out.print("\033[H\033[2J");
				System.out.println("Not a valid option. Try again.\n");
			}
		}
	}
}