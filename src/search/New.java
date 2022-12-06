package search;
	import java.beans.EventHandler;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.directory.SearchResult;

public class New {
	    public static void main(String[] args) throws IOException, Exception {
	        
	    	String indexFolder = "C:\\Index\\"; // Specify the path to the index folder
	    	String documentsFolder = "C:\\Files\\"; // Specify the path to a folder containing documents to search

	    	// Create a new index or
	    	// Open an existing index
	    	Index index = new Index(indexFolder);

	    	// Subscribe to index events
	    	index.getEvents().ErrorOccurred.add(new EventHandler<IndexErrorEventArgs>() {
	    	    public void invoke(Object sender, IndexErrorEventArgs args) {
	    	        System.out.println(args.getMessage()); // Writing error messages to the console
	    	    }
	    	});

	    	// Add files synchronously
	    	index.add(documentsFolder); // Synchronous indexing documents from the specified folder

	    	// Perform search
	    	String query = "elementum"; // Specify a search query
	    	SearchResult result = index.search(query); // Searching in the index

	    	// Use search results
	    	// Printing the result
	    	System.out.println("Documents found: " + result.getDocumentCount());
	    	System.out.println("Total occurrences found: " + result.getOccurrenceCount());
	    	for (int i = 0; i < result.getDocumentCount(); i++) {
	    	    FoundDocument document = result.getFoundDocument(i);
	    	    System.out.println("\tDocument: " + document.getDocumentInfo().getFilePath());
	    	    System.out.println("\tOccurrences: " + document.getOccurrenceCount());
	    	}

	    	// Highlight occurrences in text
	    	if (result.getDocumentCount() > 0) {
	    	    FoundDocument document = result.getFoundDocument(0); // Getting the first found document
	    	    String path = "C:\\Output\\Highlighted.html";
	    	    OutputAdapter outputAdapter = new FileOutputAdapter(path); // Creating the output adapter to a file
	    	    HtmlHighlighter highlighter = new HtmlHighlighter(outputAdapter); // Creating the HtmlHighlighter object
	    	    index.highlight(document, highlighter); // Generating output HTML formatted document with highlighted search results

	    	}
	    }
	}

