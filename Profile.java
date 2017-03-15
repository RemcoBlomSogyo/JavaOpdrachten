import java.util.ArrayList;

public class Profile {
	private String name;
	private ArrayList<String> bookTitles = new ArrayList<String>(); 
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void addBook(String book) {
		bookTitles.add(book);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getBookTitles() {
		return bookTitles;
	}
}