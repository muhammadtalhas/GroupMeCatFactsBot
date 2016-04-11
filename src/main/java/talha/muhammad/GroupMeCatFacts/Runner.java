package talha.muhammad.GroupMeCatFacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;

public class Runner extends ConfigReader{

	public static void main(String[] args) throws IOException {
		ConfigReader getBotId = new ConfigReader();
		String botId = null;
		try {
			botId = getBotId.getBotID();
		} catch (IOException e2) {
			System.out.println("Could Not Load Config file");
		}
		String fact = null;
		try {
			sendMsg(botId, "Thank you for subscribing to CatFacts (Version 0.1 BETA)");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				sendMsg(botId, "Cat Facts Bot has crashed :(- InterruptedException");
				e.printStackTrace();
				System.exit(-1);
			}
			sendMsg(botId, "A cat fact will be posted every 6 Hours");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				sendMsg(botId, "Cat Facts Bot has crashed :(- InterruptedException");
				e.printStackTrace();
				System.exit(-1);
			}
		} catch (IOException e1) {
			sendMsg(botId, "Cat Facts Bot haz an error :(- IOException");
			e1.printStackTrace();
			System.exit(-1);
		}
		
		
		while (true){
			try {
				fact = getFact();
			} catch (JSONException e) {
				sendMsg(botId, "Cat Facts Bot haz an error :(- JSONException");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				sendMsg(botId, fact);
			} catch (IOException e) {
				sendMsg(botId, "Cat Facts Bot haz an error :(- IOException");
				e.printStackTrace();
				System.exit(-1);

			}
			try {
				TimeUnit.HOURS.sleep(6);
				TimeUnit.MINUTES.sleep(30);
			} catch (InterruptedException e) {
				sendMsg(botId, "Cat Facts Bot has crashed :(- InterruptedException");
				e.printStackTrace();
				System.exit(-1);
			}
		}


	}

}
