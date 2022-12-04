package search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ReadF {
	public static void search() throws IOException 
	   {
		Scanner sc = new Scanner(System.in);
		
    
		String input = null;
		Set<String> set = new LinkedHashSet<>();
		String[] words;
		List<String> listOfAllWords = new ArrayList<>();
		System.out.println("Enter name of .txt file you wanna search from: ");
		String fileName = sc.next();

		System.out.println("Enter words  :");
		boolean tr = true;
		while (tr) {
			input = sc.next();
			if ("stop".equalsIgnoreCase(input)) {
				break;
			}
			listOfAllWords.add(input);

		}

		System.out.println("Input list: " + listOfAllWords);

		for (String sf : listOfAllWords) {
			FileReader fr = new FileReader(fileName + ".txt");
			BufferedReader br = new BufferedReader(fr);
			int count = 0;
			String s;

			while ((s = br.readLine()) != null) {
				s = s.replaceAll("\\W", " ");

				words = s.split(" ");
				for (String word : words) {
					if (word.contains(sf)) {
						count++;
					}
				}
			}
			if (count == 1) {
				set.add(sf);
			} else if (count > 1) {
				System.out.println("Not added to set");
			}

			fr.close();
			
		}


		System.out.println("\nUnique words : " + set + "\n");
}
}