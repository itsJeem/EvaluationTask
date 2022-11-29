package search;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;

public class CreateFile {
	public static void create() throws IOException, InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://api.zippopotam.us/us/90210")).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String resu = response.body();
		
		
		Gson gson = new Gson();
		Data data = new Gson().fromJson(resu, Data.class);
		
	System.out.println("Enter name of .txt file: ");
	String fileName = sc.next();
	try (FileWriter file = new FileWriter(fileName + ".txt")) {
		gson.toJson(data, file);
		file.flush();
		file.close();
	}

	catch (IOException e) {
		e.printStackTrace();
	}
}
	
}
