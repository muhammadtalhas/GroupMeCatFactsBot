package talha.muhammad.GroupMeCatFacts;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CatFact {
	/*public static void main(String[] args) throws IOException, JSONException
	{
		String fact = getFact();
		System.out.println(fact);
		
	}*/
	public static String getFact() throws IOException, JSONException
	{
		StringBuffer response = new StringBuffer();
		String URI = "http://catfacts-api.appspot.com/api/facts";
		URL obj = new URL(URI);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		JSONObject jsonResult = new JSONObject(response.toString());
		JSONArray fact = jsonResult.getJSONArray("facts");

		String factString = fact.toString();
		factString = factString.replace("[", "");
		factString = factString.replace("]", "");
		factString = factString.replace("\"", "");
		return factString;
		
	}

}
