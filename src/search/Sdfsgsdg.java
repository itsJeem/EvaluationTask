package search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Sdfsgsdg {
	
	    public static void main(String args[]) throws IOException {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Type the directory of the PDF File : ");
	        String PDFdir = scan.nextLine();
	        System.out.println("Input the phrase to find");
	        String phrase = scan.nextLine();
	        File file = new File(PDFdir);
	        PDDocument doc = PDDocument.load(file);
	        PDFTextStripper findPhrase = new PDFTextStripper();
	        String text = findPhrase.getText(doc);
	        String PDF_content = text;
	        String result = PDF_content.contains(phrase) ? "Yes" : "No";
	        System.out.println(result);
	        doc.close();
	    }
	}  
