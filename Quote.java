/*
	Quote.java
	
	Made by Remco Blom
*/

import java.time.LocalDate;

/*
	Holds the six quotes and names and launches the progam
*/
public class Quote {
    private String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };
	
	public String getSentence(int index) {
		return quotes[index][1];
	}

	public String getName(int index) {
		return quotes[index][0];
	}
	
    public static void main(String... args) {
        QuotePrinter printer = new QuotePrinter();
		printer.printToPromt();
    }
}

/*
	Gets the right quote and name based on current date 
	and prints it to the terminal
*/
class QuotePrinter {
	private int dayIndex;
	private String sentence;
	private String name;
	
	public int getDayIndex() {
		return dayIndex;
	}
	
	public void setDayIndex(int index) {
		dayIndex = index;
	}
	
	public String getSentence() {
		return sentence;
	}
	
	public void setSentence(String sntnc) {
		sentence = sntnc;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String nm) {
		name = nm;
	}
	
	// gets current date and convert it into an index for the quote array
	public void calcDayIndex() {
		LocalDate date = LocalDate.now();
		setDayIndex(date.getDayOfYear() % 6);
	}
	
	// gets the quote from the other class
	public void chooseQuote() {
		Quote quote = new Quote();
		setSentence(quote.getSentence(dayIndex));
		setName(quote.getName(dayIndex)); 
	}

	// makes first char of string a capital letter
	public String capitalize(String word) {
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}

	// adds a dot behind string when there is no other punctuation
	public String addDot(String word) {
		if (word.charAt(word.length() - 1) != '.' || word.charAt(word.length() - 1) != '!' ) {
			word = word + ".";
		}
		return word;
	}

	// adds quotes around string
	public String addQuotes(String word) {
		return "\"" + word + "\"";
	}
	
	// merges strings, words are seperated by two lines
	public String mergeWords(String sentence, String name) {
		return sentence + " -- " + name;
	}

	// calls other methods and prints to terminal
	public void printToPromt() {
		calcDayIndex();
		chooseQuote();
		setName(capitalize(getName()));
		setSentence(addQuotes(addDot(capitalize(getSentence()))));
		System.out.println(mergeWords(getSentence(), getName()));
	}
}
