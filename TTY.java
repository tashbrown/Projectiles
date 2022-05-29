/* Tasheem Brown
 * tbrown50
 * Project #1
 * MW 2:00pm - 3:15pm
 * 
 * I did not collaborate with anyone on this assignment
 */

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class TTY {

	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();

	public static void main(String[] args) {

		double distance = ran.nextDouble();
		double height = ran.nextDouble();
		double speed = 0;
		int score = 0;

		System.out.println("How to play:" + "\nWhen prompted to do so, please enter a speed value and an angle."
				+ "\nYou will attempt to launch a projectile over the wall based on these values and based on the height and distance. ");

		// Creates rounds each time a projectile is launched
		for (int round = 1; round >= 0; round++) {
			System.out.println("--------------------------------------------");
			System.out.println(">>> Round: " + round + " <<< " + "| [Current Score: " + score + "] |    ╎");
			System.out.println("--------------------------------------------");
			System.out.println("| Height: " + height + " |");
			System.out.println("| Distance: " + distance + " |");

			System.out.print("Enter a speed value: ");
			speed = scan.nextDouble();
			System.out.print("Enter an angle: ");
			double angle = scan.nextDouble();
			// Convert given angle to radians
			angle = Math.toRadians(angle);

			// Given formula for projectile launched from ground (height 0) at a speed and
			// an angle of elevation
			double formula = ((distance) * (Math.tan(angle)))
					- (((9.8) * (Math.pow(distance, 2))) / ((2) * (Math.pow((speed) * (Math.cos(angle)), 2))));

			// When projectile is over the wall by more than 3 meters...
			if (formula - height > 3) {
				System.out.println("[plenty of room]");
				score += 2; // Increment score by 2
			}
			// When projectile is over the wall by 3 meters or less (note: the height is
			// 0)...
			else if (formula - height <= 3 && formula - height >= 0) {
				System.out.println("[you made it]");
				score += 4;
			}
			// When projectile hits the wall near the top...
			else if (formula - height >= -3 && formula - height < 0) {
				System.out.println("[not quite over]");
				score--; // Decrement by 1
			}
			// When projectile hits the wall much further down from the top, so less than 3
			// meters down (-3)
			else if (formula - height < -3) {
				System.out.println("[not even close]");
				score -= 3;
			}

			System.out.println("-----------------------------------------");
			// Prompt user to decide if they want to go on to another round or end the game.
			System.out.println("Enter 'continue' to go to the next round or 'quit' to end the game: ");

			String next = scan.next().toLowerCase(); // Allows user to enter a string

			// Continue playing (Go on to next round)
			if (next.equals("continue")) {
				continue;

				// End the game
			}
			if (next.equals("quit")) {
				System.out.println();
				System.out.println("--------------------------------------------");
				System.out.println("Final Score: " + score);
				System.out.println("--------------------------------------------\nGame Over.");
				break;
			} else {
				break;
			}

		}

	}

}
