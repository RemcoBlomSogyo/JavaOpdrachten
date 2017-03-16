/*
	QuoteLauncher.java
	
	Holds the six quotes and names and launches the progam.
	
	Made by Remco Blom
*/

public class QuoteLauncher {
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
	
    public static void main(String[] args) {
        Quote quote = new Quote();
		quote.printToPromt();
    }
}

