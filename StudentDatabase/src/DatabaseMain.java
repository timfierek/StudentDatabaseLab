
/**
 * DatabaseMain handles all exception handling and user input for the 
 * student database.
 * 
 * @author Tim Fierek
 *
 */
public class DatabaseMain {

	/**
	 * Collects console input and catches and handles exceptions and 
	 * incorrect input, also prints data out.
	 * 
	 */
	public static void main(String[] args) {
		Student[] studentDatabase = new Student[10];
		studentDatabase[0] = new Student("Tim Fierek", "Steak", "Dexter");
		studentDatabase[1] = new Student("Ali Beatriz", "Popcorn", "Ann Arbor");
		studentDatabase[2] = new Student("Charles Diya", "Apples", "Flint");
		studentDatabase[3] = new Student("Eric Fatima", "Coffee", "East Lansing");
		studentDatabase[4] = new Student("Gabriel Hanna", "Hotdogs", "Houghton");
		studentDatabase[5] = new Student("Kendrick Lammar", "Cheese", "Mackinac");
		studentDatabase[6] = new Student("Yung Gravy", "Caviar", "Novi");
		studentDatabase[7] = new Student("Jennifer Lopez", "Goldfish", "Ypsilanti");
		studentDatabase[8] = new Student("Elon Musk", "Cat food", "Holland");
		studentDatabase[9] = new Student("John Doe", "Lettuce", "Muskegon");
	}

}
