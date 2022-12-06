package search;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.lang.Object;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PdfRead {
	public static void main(String[] args) throws IOException, COSVisitorException {
		Scanner sc = new Scanner(System.in);
		PDDocument document;
		try {

			System.out.println("Input the phrase to find");
			String phrase = sc.nextLine();
//			File file = new File("javau.pdf");
//
//			PDDocument doc = PDDocument.load(file);
			
			document = PDDocument.load("doc.pdf");
			PDDocumentInformation info = document.getDocumentInformation();
			System.out.println("Page Count=" + document.getNumberOfPages());
			System.out.println("Title=" + info.getTitle());
			System.out.println("Author=" + info.getAuthor());
			PDFTextStripper findPhrase = new PDFTextStripper();
	        String text = findPhrase.getText(document);
	        String PDF_content = text;
	        if (PDF_content.contains(phrase)){
	        	System.out.println("the word is there");
	        }
	        else
	        {
	        	System.out.println("the word isn't there ");
	        }
	        		
	
	        
	        document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}