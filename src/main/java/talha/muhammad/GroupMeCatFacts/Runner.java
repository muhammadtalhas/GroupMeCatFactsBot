package talha.muhammad.GroupMeCatFacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;

public class Runner extends ConfigReader{

	public static void main(String[] args) {
		String botId = getBotID();
		String fact = null;
		try {
			sendMsg(botId, "Thank you for subscribing to CatFacts by T-dawg (Version 0.1 BETA)");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sendMsg(botId, "A cat fact will be posted every 15 minuites");
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		while (true){
			try {
				fact = getFact();
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				sendMsg(botId, fact);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				TimeUnit.MINUTES.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(botId);
		//TimeUnit.MINUTES.sleep(30);

	}

}
