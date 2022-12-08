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
import java.lang.Object;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfRead {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File fr;

		String input = null;
		Set<String> set = new LinkedHashSet<>();
		String[] words;
		List<String> listOfAllWords = new ArrayList<>();
		String path;
		System.out.println("Enter name of .pdf file you wanna search from: ");
		String fileName = sc.next() + ".pdf";
		System.out.println(fileName);
		PDDocument doc = PDDocument.load(new File(fileName));

		System.out.println("Enter words  : - ex to exit");
		boolean tr = true;
		while (tr) {
			input = sc.next();
			if ("ex".equalsIgnoreCase(input)) {
				break;
			}
			listOfAllWords.add(input);
		}

		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();

		// Retrieving text from PDF document
		String text = pdfStripper.getText(doc);
		int count = 0;

		// Closing the document

		for (String sf : listOfAllWords) {
			if (text.contains(sf)) {
				System.out.println("the word " + sf + " is there!");
				set.add(sf);
			} else {
				System.out.println("the word " + sf + " is not there!");

			}
		}

		System.out.println("\nwords that are in file : " + set + "\n");

		System.out.println("---------MOVING WORDS TO ANOTHER DIRECTORY---------");

		
		path = "C:\\Users\\user014\\eclipse-workspace\\EvaluationTask\\";
		// Using Scanner class to get the folder name from the user

		System.out.println("Choose where u want?\n1. create a new directory.\n2.exist file");
		Integer ch = sc.nextInt();
		
		if (ch == 1) {
		System.out.println("Enter the name of the desired a directory: ");
		path = path + sc.next();
		// Instantiate the File class
		File f1 = new File(path);
		// Creating a folder using mkdir() method
		boolean bool = f1.mkdir();
		if (bool) {
			System.out.println("Folder is created successfully");
		} else {
			System.out.println("Error Found!");

		}
		
		//here will be moving to exist one
	      PDPage page = doc.getPage(0);
	      PDPageContentStream contentStream = new PDPageContentStream(doc, page);
	      
	      //Begin the Content stream 
	      contentStream.beginText(); 
	       
	      //Setting the font to the Content stream  
	      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

	      //Setting the position for the line 
	      contentStream.newLineAtOffset(25, 500);


	      contentStream.showText(set.toString()); 
	      //Ending the content stream
	      contentStream.endText();

	      System.out.println("Content added");

	      //Closing the content stream
	      contentStream.close();
	      
	      System.out.println("Enter PDF name:");
	      String Fname =sc.next();
	      //Saving the document
	      doc.save(new File(path +"\\" +Fname+".pdf"));

	      //Closing the document
	      doc.close();

		}
		
		if (ch==2) {
			
			  System.out.println("Enter Name Of Directory");
			  String Dirname=sc.next();
			  path = "C:\\Users\\user014\\eclipse-workspace\\EvaluationTask\\"+Dirname+"\\";
			
			//here will be moving to exist one
		      PDPage page = doc.getPage(0);
		      PDPageContentStream contentStream = new PDPageContentStream(doc, page);
		      
		      //Begin the Content stream 
		      contentStream.beginText(); 
		       
		      //Setting the font to the Content stream  
		      contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

		      //Setting the position for the line 
		      contentStream.newLineAtOffset(25, 500);


		      contentStream.showText(set.toString()); 
		      //Ending the content stream
		      contentStream.endText();

		      System.out.println("Content added");

		      //Closing the content stream
		      contentStream.close();
		      System.out.println("Enter PDF name:");
		      String pName =sc.next();
		      //Saving the document
		      doc.save(new File(path+pName+".pdf"));

		      //Closing the document
		      doc.close();
			
		}
//		PDDocument pdfdoc = new PDDocument();
//		pdfdoc.addPage(new PDPage());
//
//		// path where the PDF file will be store
//		pdfdoc.save("C:\\Users\\user014\\eclipse-workspace\\EvaluationTask\\Sample.pdf");
//		// prints the message if the PDF is created successfully
//		System.out.println("PDF created");
//		// closes the document
//		pdfdoc.close();

	}
}