package test;

import java.net.HttpURLConnection;
import java.net.URL;

public class JsonWithoutLib {
	String url = "https://swapi.dev/api/people/1/";
	HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	
}
