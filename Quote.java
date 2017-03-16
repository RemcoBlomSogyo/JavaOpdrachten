/*
	Quote.java
	
	Gets the right quote and name based on current date 
	and prints it to the terminal.
	
	Made by Remco Blom
*/

import java.time.LocalDate;

public class Quote {
	private int dayIndex;
	private String sentence;
	private String name;
	
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
	public void calculateDayIndex() {
		LocalDate date = LocalDate.now();
		setDayIndex(date.getDayOfYear() % 6);
	}
	
	// gets the quote from the other class
	public void chooseQuote() {
		QuoteLauncher launcher = new QuoteLauncher();
		setSentence(launcher.getSentence(dayIndex));
		setName(launcher.getName(dayIndex)); 
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
		calculateDayIndex();
		chooseQuote();
		setName(capitalize(getName()));
		setSentence(addQuotes(addDot(capitalize(getSentence()))));
		System.out.println(mergeWords(getSentence(), getName()));
	}
}
