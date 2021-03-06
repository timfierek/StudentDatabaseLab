import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * DatabaseMain handles all exception handling and user input for the 
 * student database.
 * 
 * @author Tim Fierek
 *
 */
public class DatabaseMain {

	/**
	 * Collects console input through method calls and filters
	 * incorrect input, also prints data out.
	 * 
	 */
	public static void main(String[] args) {
		Student[] stuDat = new Student[10];		// Array of students for database
		stuDat[0] = new Student("Tim Fierek", "Steak", "Dexter");
		stuDat[1] = new Student("Ali Beatriz", "Popcorn", "Ann Arbor");
		stuDat[2] = new Student("Charles Diya", "Apples", "Flint");
		stuDat[3] = new Student("Eric Fatima", "Coffee", "East Lansing");
		stuDat[4] = new Student("Gabriel Hanna", "Hotdogs", "Houghton");
		stuDat[5] = new Student("Kendrick Lammar", "Cheese", "Mackinac");
		stuDat[6] = new Student("Yung Gravy", "Caviar", "Novi");
		stuDat[7] = new Student("Jennifer Lopez", "Goldfish", "Ypsilanti");
		stuDat[8] = new Student("Elon Musk", "Cat food", "Holland");
		stuDat[9] = new Student("John Doe", "Lettuce", "Muskegon");
		
		Scanner in = new Scanner(System.in);
		boolean loop = false;					// Variable for continuing input
		int stuNum = -1;						// Student number 
		String infoSelection = "";				// Information choice from user
		System.out.print("Welcome to our Java class. ");
		
		// Loop each time until student enters "no" when prompted to continue
		do {
			// This block collects user input for which student to access
			stuNum = getStudentNum(in) - 1;						// Adjusted for index
			String studentName = stuDat[stuNum].getName();
			String firstName = stuDat[stuNum].getFirstName();
			
			// This block collects collects which info the user would like about the student
			System.out.print("\nStudent " + (stuNum + 1) + " is " 
					+ studentName + ". What would you like to know about "
					+ firstName + "? ");
			infoSelection = getInfoSelection(in);
			
			// Print appropriate output for user selection
			if(infoSelection.equals("hometown")) {
				System.out.print("\n" +firstName + " is from " + stuDat[stuNum].getHometown() + ". ");
			}
			else if(infoSelection.equals("favorite food")) {
				System.out.print("\n" +firstName + "'s favorite food is " 
						+ stuDat[stuNum].getFavoriteFood() + ". ");
			}
			
			// Prompt user to continue or not
			loop = promtToContinue(in);
			
		} while(loop);
		
		System.out.println("\nThanks!");
		in.close();
	}
	
	/**
	 * Prints prompt for user input and ensures correct input and catches exceptions.
	 * 
	 * @param in Scanner used for console input
	 * @return the unadjusted student number entered by user
	 */
	public static int getStudentNum(Scanner in) {
		int selection = -1;
		
		// Print prompt
		System.out.print("\nWhich student would you like to learn more about? (enter a number 1-10): ");
		
		// Loop until correct input is entered
		while (selection < 1 || selection > 10) {
			
			try {
				selection = in.nextInt();
				if(selection < 1 || selection > 10) {
					throw new IndexOutOfBoundsException();
				}
			
				// First catch is for if user enters anything that isn't an int
			} catch (InputMismatchException e) {
				System.out.print("\nInput must be an integer. Try again: ");
				in.nextLine();
				
				// Second catch is for if user's int is not in the inclusive range 1-10
			} catch (IndexOutOfBoundsException e) {
				System.out.print("\nThat student does not exist. Please try again. (enter a number 1-10): ");
				in.nextLine();
			}
		}
		
		// Clear input stream and return value
		in.nextLine();
		return selection;
	}

	/**
	 * Prints prompt for user input and takes in user choice for either favorite food
	 * or hometown. Continues prompting until correct input is entered
	 * 
	 * @param in Scanner for console input
	 * @return "hometown" or "favorite food" depending on user input
	 */
	public static String getInfoSelection(Scanner in) {
		// Print prompt and collect initial value
		System.out.print("(enter \"hometown\" or \"favorite food\"): ");
		String selection = in.nextLine().toLowerCase();
		
		// Loop until correct input is entered
		while(!selection.equals("hometown") && !selection.equals("favorite food")) {
			System.out.print("\nThat data does not exist. Please try again. "
					+ "(enter \"hometown\" or \"favorite food\"): ");
			selection = in.nextLine().toLowerCase();
		}
		
		return selection;
	}

	/**
	 * Prompts user to continue entering info and validates user choice
	 * 
	 * @param in Scanner for console input
	 * @return true if user wants to continue false otherwise
	 */
	public static boolean promtToContinue(Scanner in) {
		System.out.print("Would you like to know more? (enter \"yes\" or \"no\"): ");
		String choice = in.nextLine().toLowerCase();
		
		while(!choice.equals("yes") && !choice.equals("no")) {
			System.out.print("Invalid input. Please enter \"yes\" or \"no\": ");
			choice = in.nextLine().toLowerCase();
		}
		
		if(choice.equals("yes")) {
			return true;
		}
		
		return false;
	}
}
