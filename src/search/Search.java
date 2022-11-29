package search;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class Search {
	
	public static void display() throws IOException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
	
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.zippopotam.us/us/90210")).build();
	HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	String resu = response.body();
	
	
	Gson gson = new Gson();
	Data data = new Gson().fromJson(resu, Data.class);
	
	
	System.out.println("Enter name of .txt file you wanna display: ");
	String fileName2 = sc.next();
	try {
		Reader reader = Files.newBufferedReader(Paths.get(fileName2 + ".txt"));
		Map<?, ?> map = gson.fromJson(reader, Map.class);
		System.out.println("\nresults from a file :");
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue() + "\n");
		}
		reader.close();
	}

	catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	
}
