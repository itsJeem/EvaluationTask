package search;

import java.io.FileWriter;
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

public class GetRequest {
	public static void main(String[] args) throws IOException, InterruptedException {

//		String path="http://api.zippopotam.us/us/90210";

		Scanner sc = new Scanner(System.in);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.zippopotam.us/us/90210")).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String resu = response.body();
		System.out.println(resu);
		
		if (resu.contains("error")) {
			System.out.println("there is an error.");
			Gson gson = new Gson();

			ErrorHandling err = gson.fromJson(response.body(), ErrorHandling.class);
			System.out.println(err.getError());

		}
		else {
		

		boolean bool = true;
		do {
			System.out.println("\n\n1. create a file with json content.");
			System.out.println("2. read from existing file.");
			System.out.println("3. search from file.");
			System.out.println("4. exit.");
			System.out.println("choose your need : ");
			Integer choice = sc.nextInt();

			switch (choice) {
			
			case 1:
				CreateFile cr = new CreateFile();
				cr.create();
				
				break;

			case 2:
				Search sr = new Search();
				sr.display();
				break;
				
			case 3:
				ReadF re = new ReadF();
				re.search();
				break;
			
			
			case 4:
				System.out.println("exiting . . . . ");
				bool = false;
				break;
			}

		} while (bool);
		
		
		
		
		}
		
		
		
		
		
		
		

	}

}
