package talha.muhammad.GroupMeCatFacts;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GroupmeBot extends CatFact {
	public static void sendMsg(String botKey, String Msg) throws IOException {
		try {
			URL url = new URL("https://api.groupme.com/v3/bots/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			System.out.println(Msg);
			String payload = "{ \"bot_id\": \"" + botKey + "\",\"text\" :\"" + Msg + "\"}";
			System.out.println(payload);
			
			OutputStream os = conn.getOutputStream();
			os.write(payload.getBytes());
			os.flush();
			System.out.println(conn.getResponseCode());

			/*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}*/

		} catch (MalformedURLException e) {
			System.out.println("Malformed URL Boy..");
			// e.printStackTrace();
		}
	}
}
