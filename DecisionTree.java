/*
	DecisionTree.java
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class DecisionTree {
	
	ArrayList<List<String>> nodes = new ArrayList<List<String>>();
	ArrayList<List<String>> edges = new ArrayList<List<String>>();
	
	// reads the text file and puts values in nodes and edges list
	public void readFile() {
		
		File file = new File("decision-tree-data.txt");
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				List<String> lineParts = Arrays.asList(line.split(", "));
				if (lineParts.size() == 3) {
					edges.add(lineParts);
				} else {
					nodes.add(lineParts);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		searchNode("N1");
	}
	
	// finds the right node based on the edge or first input
	private void searchNode(String targetNode) {
		for (List<String> node : nodes) {
			if (node.get(0).equals(targetNode)) {
				System.out.println(node.get(1));
				if (node.get(1).contains("?")) {
					askAnswer(node.get(0));
				}
				return;
			}
		}
	}
	
	// finds the right edge based on current node and answer
	private void searchEdge(String currentNode, String input) {
		for (List<String> edge : edges) {
			if (edge.get(0).equals(currentNode) && edge.get(2).equals(input)) {
				searchNode(edge.get(1));
			}
		}
	}
	
	// handles input from user
	private void askAnswer(String currentNode) {
		Scanner scan = new Scanner(System.in);
		String userInput = "";
		while (!userInput.equals("Ja") && !userInput.equals("Nee")) {
			System.out.print("(Ja/Nee)");
			userInput = scan.nextLine();
		}
		searchEdge(currentNode, userInput);
	}
}