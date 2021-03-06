
/**
 * Student.java contains the constructor and various methods for a 
 * student object to be used in the student database and accessed in
 * DatabaseMain.java
 * 
 * @author Tim Fierek
 *
 */
public class Student {
	private String name;
	private String favFood;
	private String hometown;
	
	public Student(String name, String favFood, String hometown) {
		this.name = name;
		this.favFood = favFood;
		this.hometown = hometown;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstName() {
		if(name.indexOf(' ') == -1) {
			return name;
		}
		else {
			return name.substring(0, name.indexOf(' '));
		}
	}
	
	public String getFavoriteFood() {
		return favFood;
	}
	
	public String getHometown() {
		return hometown;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFavoriteFood(String favFood) {
		this.favFood = favFood;
	}
	
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
}
