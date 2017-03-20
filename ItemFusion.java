/*
	ItemFusion.java
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class ItemFusion {
	
	// 0 = name, 1 = price
	ArrayList<List<String>> items = new ArrayList<List<String>>();
	
	// 0 = item1, 1 = item2, 2 = fused item
	ArrayList<List<String>> fusions = new ArrayList<List<String>>();
	
	public void readData() {
		File file = new File("item-fusion-data.txt");
		
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.contains("~") && !line.equals("Name ~ Cost")) {
					if (line.substring(0,1).equals("*")) {
						line = line.substring(1);
					}
					List<String> lineParts = Arrays.asList(line.split(" ~ "));
					for (String part : lineParts) {
						System.out.println(part);
					}
					items.add(lineParts);
				} else if (line.contains("+") && line.contains("=")) {
					List<String> lineParts = Arrays.asList(line.split(" \\+ | = "));
					for (String part : lineParts) {
						System.out.println(part);
					}
					fusions.add(lineParts);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}		
	}

/*
	Find cheapest way to get item
	
	get prize of item
	get all possibilities to get item
	get prize of possibilities by prices of items
	
	loop over items of possibilities
	get prize of item
	get all possibilities to get item
	get prize of possibilities by prices of items
	
	get alle possibilities to get those items to get the item
	etc
	
	
*/

}