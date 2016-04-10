package talha.muhammad.GroupMeCatFacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader extends GroupmeBot{
	@SuppressWarnings("finally")
	public static String getBotID() {
		String botId = null;
		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream("config/config.properties");

			// load a properties file
			prop.load(input);
			botId = prop.getProperty("BotId");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			return botId;
		}
		
	}
}
