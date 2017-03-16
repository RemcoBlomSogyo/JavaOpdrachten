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
	}
}