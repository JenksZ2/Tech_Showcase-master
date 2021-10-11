package com.techshowcase.java;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;


public class ReadJSON {


	public static void albumLookup(int albumNum) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/photos");
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();

			if(uc.getResponseCode() == 200) {
				InputStream is = uc.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String jsonText = br.lines().collect(Collectors.joining());
				JSONArray json = new JSONArray(jsonText);

				for (int i = 0; i < json.length(); i++) {
					JSONObject a = (JSONObject) json.get((i));

					int albumId = a.getInt("albumId");

					if (albumId == albumNum) {
						int id = a.getInt("id");
						System.out.print("[" + id + "] ");

						String title = (String) a.get("title");
						System.out.println(title);
					}
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}