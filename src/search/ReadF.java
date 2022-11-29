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
		
    
  List<String> listOfWords = new ArrayList<>();
  
  System.out.println("Enter number of words:");
  Integer num=sc.nextInt();
  String input;
  
  System.out.println("Enter " + num + " words  :");
  for (int i=0; i<num; i++) {
	  
    String[] words=null;
    FileReader fr = new FileReader("java.txt");
    BufferedReader br = new BufferedReader(fr); 
    int count=0; 
	String s;  
    
    input=sc.next();
    

    while((s=br.readLine())!=null)
    {
       words=s.split(" ");
        for (String word : words) 
        {
               if (word.equals(input))
               {
                 count++;
               }
        }
    }
    if(count==1)
    {
       listOfWords.add(input);
    }
    else if (count>1)
    {
       System.out.println("");
    }
  
       fr.close();
       count=0;
	   }
  
 
  Set<String> set = new LinkedHashSet<>();
  set.addAll(listOfWords);

  listOfWords.clear();

  listOfWords.addAll(set);
  System.out.println("\n unique words : "+listOfWords+"\n");
}
}